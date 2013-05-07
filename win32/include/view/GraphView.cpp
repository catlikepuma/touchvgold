//! \file GraphView.cpp
//! \brief ʵ��MFC��ͼ���ڻ��� GiGraphViewMfc
// Copyright (c) 2004-2013, Zhang Yungui
// License: LGPL, https://github.com/rhcad/touchvg

#include "stdafx.h"
#include "GraphView.h"
#include <afxpriv.h>
#include <canvasgdip.h>
#include <giimagep.h>
#include <mgcmd.h>
#include <mgjsonstorage.h>
#include <mgselect.h>
#include <string>
#include <vector>

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

static const UINT WM_DELAY_LBUTTONUP = WM_USER + 101;

BEGIN_MESSAGE_MAP(GiGraphViewMfc, CWnd)
    //{{AFX_MSG_MAP(GiGraphViewMfc)
    ON_WM_ERASEBKGND()
    ON_WM_PAINT()
    ON_WM_SIZE()
    ON_WM_KEYDOWN()
    ON_WM_CHAR()
    ON_WM_MOUSEWHEEL()
    ON_WM_CREATE()
    ON_WM_HSCROLL()
    ON_WM_VSCROLL()
    ON_WM_MOUSEMOVE()
    ON_WM_LBUTTONDOWN()
    ON_WM_LBUTTONUP()
    ON_WM_LBUTTONDBLCLK()
    ON_MESSAGE(WM_DELAY_LBUTTONUP, OnDelayLButtonUp)
    ON_WM_CONTEXTMENU()
    ON_UPDATE_COMMAND_UI(ID_FILE_SAVE, OnUpdateFileSave)
    ON_COMMAND(ID_FILE_SAVE, OnFileSave)
    ON_COMMAND(ID_FILE_SAVE_AS, OnFileSaveAs)
    ON_MESSAGE_VOID(WM_INITIALUPDATE, OnInitialUpdate)
    ON_COMMAND(ID_EDIT_SELECT_ALL, OnSelectAll)
	ON_UPDATE_COMMAND_UI(ID_EDIT_SELECT_ALL, OnUpdateSelectAll)
    ON_COMMAND(ID_EDIT_CLEAR_ALL, OnClearAll)
	ON_UPDATE_COMMAND_UI(ID_EDIT_CLEAR_ALL, OnUpdateClearAll)
    //}}AFX_MSG_MAP
END_MESSAGE_MAP()

static struct {
    LPCTSTR caption;
    LPCSTR  name;
} s_cmds[] = {
    { _T("ѡ��"),      "select" },
    { _T("ɾ��"),      "erase" },
    { _T("���ֻ�"),    "splines" },
    { _T("ֱ�߶�"),    "line" },
    { _T("����"),      "rect" },
    { _T("������"),    "square" },
    { _T("��Բ"),      "ellipse" },
    { _T("Բ"),        "circle" },
    { _T("������"),    "triangle" },
    { _T("����"),      "diamond" },
    { _T("�����"),    "polygon" },
    { _T("�ı���"),    "quadrangle" },
    { _T("����"),      "lines" },
    { _T("ƽ���ı���"), "parallelogram" },
    { _T("������"),    "cuboid" },
    { _T("������"),    "cube" },
    { _T("����"),      "grid" },
    { _T("Բ����"),    "cylinder" },
    { _T("��Բ����"),  "halfcylinder" },
    { _T("Բ����"),    "torus" },
    { _T("��Բ����"),  "halftorus" },
    { _T("����Բ��"),  "arc3p" },
    { _T("Բ��Բ��"),  "arc-cse" },
    { _T("����Բ��"),  "arc-tan" },
    { _T("����ϵ����"),  "xfdemo" },
    { _T("�������"),  "hittest" },
};
static const int s_cmdCount = sizeof(s_cmds)/sizeof(s_cmds[0]);

// see MgContextAction in mgaction.h
static LPCTSTR const ACTION_NAMES[] = { NULL,
    _T("ȫѡ"), _T("��ѡ"), _T("��ͼ"), _T("ȡ��"),
    _T("ɾ��"), _T("��¡"), _T("����"), _T("�Ǳ�"), _T("����"), _T("������"), _T("����"), _T("����"),
    _T("�༭"), _T("����"), _T("�պ�"), _T("���պ�"), _T("�ӵ�"), _T("ɾ��"), _T("����"), _T("����"),
    _T("��ת"), _T("����ͼ"),
};

class MgViewMfc : public MgView
{
public:
    GiGraphViewMfc* view;
    MgMotion        motion;
    bool            penMode;
    bool            needLayout;

    MgViewMfc(GiGraphViewMfc* m_proxy)
        : view(m_proxy), penMode(false), needLayout(false) {
        motion.view = this;
    }

    void release() {
        delete this;
    }

    void setPoint(const CPoint& pt)
    {
        motion.point.set((float)pt.x, (float)pt.y);
        motion.pointM = motion.point * xform()->displayToModel();
    }

    void regen()
    {
        graph()->clearCachedBitmap();
        view->Invalidate();
        if (needLayout) {
            needLayout = false;
            view->shapeAdded(NULL);
        }
    }

    void redraw(bool) { view->Invalidate(); }
    MgShapeDoc* doc() { return view->doc(); }
    GiTransform* xform() { return view->xform(); }
    GiGraphics* graph() { return view->graph(); }
    bool useFinger() { return penMode; }
    void shapeAdded(MgShape* shape) { view->shapeAdded(shape); }
    void shapeMoved(MgShape*, int) { needLayout = true; }

    bool drawHandle(GiGraphics* gs, const Point2d& pnt, int type)
    {
        GiContext ctx(0, GiColor::Black(), kGiLineSolid,
            GiColor(240, 240, 240, type ? 200 : 128));
        bool old = gs->setAntiAliasMode(false);
        gs->drawRect(&ctx, Box2d(pnt, gs->xf().displayToModel(type ? 3.f : 1.5f, true), 0));
        gs->setAntiAliasMode(old);
        return true;
    }

    bool isContextActionsVisible()
    {
        return view->GetLastActivePopup() != view;
    }

    bool showContextActions(int, const int* actions, const Box2d&, const MgShape*)
    {
        return view->showContextActions(actions);
    }
};

static struct ClickParams {
    HANDLE  hThread;
    HWND    hWnd;
    DWORD   downTick;
    UINT    downFlags;
} s_clickParams = { NULL, NULL };

static DWORD WINAPI ClickThread(LPVOID p);

GiGraphViewMfc::GiGraphViewMfc()
    : m_graph(GiCanvasGdip::Create)
    , m_bRealPan(false), m_shapeAdded(NULL), m_image(NULL), m_lastChanges(0)
    , m_moved(false), m_delayUp(false), m_downTime(0), m_downFlags(0)
{
    m_doc = MgShapeDoc::create();
    m_pan.cx = m_pan.cy = 0;
    m_bkColor = GetSysColor(COLOR_WINDOW);

    m_proxy = new MgViewMfc(this);
    context().setLineWidth(50.f, true); // 0.5mm
    context().setLineAlpha(172);
}

GiGraphViewMfc::~GiGraphViewMfc()
{
    if (s_clickParams.hThread) {
        CloseHandle(s_clickParams.hThread);
        s_clickParams.hThread = NULL;
    }

    if (m_proxy) {
        m_proxy->release();
        m_proxy = NULL;
    }
    if (m_doc) {
        m_doc->release();
        m_doc = NULL;
    }
    delete m_image;

    if (!m_tmpPicFile.IsEmpty()) {
        ::DeleteFile(m_tmpPicFile);
    }

    mgGetCommandManager()->unloadCommands();
}

BOOL GiGraphViewMfc::PreCreateWindow(CREATESTRUCT& cs)
{
    if (!CWnd::PreCreateWindow(cs))
        return FALSE;

    cs.dwExStyle |= WS_EX_CLIENTEDGE;
    cs.style &= ~WS_BORDER;
    cs.lpszClass = AfxRegisterWndClass(CS_HREDRAW|CS_VREDRAW|CS_DBLCLKS,
        ::LoadCursor(NULL, IDC_ARROW), HBRUSH(COLOR_WINDOW+1), NULL);

    return TRUE;
}

BOOL GiGraphViewMfc::OnEraseBkgnd(CDC*)
{
    return TRUE;                                // ��OnPaint�л��������
}

void GiGraphViewMfc::OnPaint()
{
    CPaintDC dc(this);
    GiCanvasWin *cv = m_graph.canvas;

    COLORREF color = m_doc->getPageRectW().isEmpty() ? m_bkColor
        : GetSysColor(COLOR_APPWORKSPACE);
    dc.SetBkColor(color);                       // ��beginPaint()��Ӧ�ñ���ɫ

    if (cv->beginPaint(dc))                     // ׼����ͼ��ʹ�û�ͼ����
    {
        OnPaint_(cv);
        cv->endPaint();                         // �ύ��ͼ���������
    }
}

void GiGraphViewMfc::OnPaint_(GiCanvasWin *cv)
{
    // ��ʾ��ǰ�������ʽͼ������
    if (m_pan.cx != 0 || m_pan.cy != 0)     // ��̬ƽ��
        cv->clearWindow();                  // �������ͼ��ı���
    if (!cv->drawCachedBitmap((float)m_pan.cx, (float)m_pan.cy))
    {
        if (0 == m_pan.cx && 0 == m_pan.cy)
            cv->clearWindow();                  // �������
        if (!cv->drawCachedBitmap(0, 0, true)){ // ��ʾ����ͼ
            if (HasBackground()) {
                DrawBackground(cv);
                cv->saveCachedBitmap(true);     // ���汳��ͼ
            }
            else if (!m_doc->getPageRectW().isEmpty()) {
                GiContext ctx(0, GiColor::Invalid(), kGiLineNull,
                    GiColor(m_bkColor));
                m_graph.gs.drawRect(&ctx, m_doc->getPageRectW(), false);
            }
        }
        DrawShapes(&m_graph.gs);            // ��ʾ��ʽͼ��
        cv->saveCachedBitmap();             // ������ʽͼ������
    }
    else if (m_shapeAdded)                  // �ڱ���ͼ�������ʾ��ͼ��
    {
        m_shapeAdded->draw(0, m_graph.gs);
        cv->saveCachedBitmap();             // ������ʽͼ������
    }
    m_shapeAdded = NULL;

    DynDraw(&m_graph.gs);                   // ��ʾ��̬ͼ��
}

void GiGraphViewMfc::OnSize(UINT nType, int cx, int cy)
{
    CWnd::OnSize(nType, cx, cy);

    // ������ʾ���ڵĴ�СΪ�ͻ�����С(������������)
    if (nType != SIZE_MINIMIZED && cx > 1 && cy > 1)
    {
        m_graph.xf.setWndSize(cx, cy);
        OnZoomed();
    }
}

void GiGraphViewMfc::OnZoomed(bool clear)
{
    if (clear) {
        regen();
    }
    Invalidate();

    Box2d rect;

    // m_rcLimits: ���޷�Χ��Ӧ�����귶Χ, ����
    rect = m_doc->getExtent() * m_graph.xf.modelToDisplay();
    rect.inflate(1, 1);
    rect.get(m_rcLimits);

    // m_rcScrWnd: ��ǰ���ڶ�Ӧ�����귶Χ, ����
    rect = Box2d(m_graph.xf.getCenterW(),
        m_graph.xf.getWidth() / m_graph.xf.getWorldToDisplayX(),
        m_graph.xf.getHeight() / m_graph.xf.getWorldToDisplayY());
    rect *= m_graph.xf.worldToDisplay();
    rect.get(m_rcScrWnd);

    // ��m_rcLimits���Ͻ�Ϊԭ�����m_rcScrWnd��m_rcLimits
    ::OffsetRect(&m_rcScrWnd, -m_rcLimits.left, -m_rcLimits.top);
    ::OffsetRect(&m_rcLimits, -m_rcLimits.left, -m_rcLimits.top);

    // ����m_rcScrWnd���ֳ���m_rcLimits
    ::UnionRect(&m_rcLimits, &m_rcLimits, &m_rcScrWnd);

    SCROLLINFO si;
    si.cbSize = sizeof(si);
    si.fMask = SIF_RANGE | SIF_PAGE | SIF_POS;
    si.nMin = 0;

    if (m_rcLimits.right - m_rcLimits.left > m_rcScrWnd.right - m_rcScrWnd.left)
    {
        si.nMax = max(1, m_rcLimits.right - m_rcLimits.left);
        si.nPage = m_rcScrWnd.right - m_rcScrWnd.left;
        si.nPos = m_rcScrWnd.left;
        ::EnableScrollBar(m_hWnd, SB_HORZ, ESB_ENABLE_BOTH);
        ::SetScrollInfo(m_hWnd, SB_HORZ, &si, TRUE);
    }
    else
    {
        ::EnableScrollBar(m_hWnd, SB_HORZ, ESB_DISABLE_BOTH);
    }

    if (m_rcLimits.bottom - m_rcLimits.top > m_rcScrWnd.bottom - m_rcScrWnd.top)
    {
        si.nMax = max(1, m_rcLimits.bottom - m_rcLimits.top);
        si.nPage = m_rcScrWnd.bottom - m_rcScrWnd.top;
        si.nPos = m_rcScrWnd.top;
        ::EnableScrollBar(m_hWnd, SB_VERT, ESB_ENABLE_BOTH);
        ::SetScrollInfo(m_hWnd, SB_VERT, &si, TRUE);
    }
    else
    {
        ::EnableScrollBar(m_hWnd, SB_VERT, ESB_DISABLE_BOTH);
    }
}

void GiGraphViewMfc::shapeAdded(MgShape* shape)
{
    m_shapeAdded = shape;
    OnZoomed(false);
}

void GiGraphViewMfc::DrawShapes(GiGraphics* gs)
{
    m_doc->draw(*gs);
}

void GiGraphViewMfc::OnZoomExtent()
{
    Box2d rect(m_doc->getExtent() * m_graph.xf.modelToWorld());
	rect.unionWith(m_doc->getPageRectW());
    if (m_graph.xf.zoomTo(rect, NULL))
        OnZoomed();
}

void GiGraphViewMfc::OnZoomWidth()
{
    Box2d rect(m_doc->getExtent() * m_graph.xf.modelToWorld());
    rect.unionWith(m_doc->getPageRectW());
    rect.set(rect.center(), rect.width(), 1);
    if (m_graph.xf.zoomTo(rect, NULL))
        OnZoomed();
}

void GiGraphViewMfc::OnZoom100()
{
    if (m_graph.xf.zoomScale(1.f))
        OnZoomed();
}

void GiGraphViewMfc::OnViewGray()
{
    m_graph.gs.setColorMode(kGiColorGray == m_graph.gs.getColorMode()
        ? kGiColorReal : kGiColorGray);
    m_graph.canvas->clearCachedBitmap();
    Invalidate();
}

void GiGraphViewMfc::OnUpdateViewGray(CCmdUI* pCmdUI)
{
    pCmdUI->SetCheck(kGiColorGray == m_graph.gs.getColorMode() ? 1 : 0);
}

void GiGraphViewMfc::OnUpdateAntiAlias(CCmdUI* pCmdUI)
{
    pCmdUI->SetCheck(m_graph.gs.isAntiAliasMode() ? 1 : 0);
}

void GiGraphViewMfc::OnViewAntiAlias()
{
    m_graph.gs.setAntiAliasMode(!m_graph.gs.isAntiAliasMode());
    m_graph.canvas->clearCachedBitmap();
    Invalidate();
}

void GiGraphViewMfc::SetBackColor(COLORREF color)
{
    m_bkColor = color;
    regen();
}

void GiGraphViewMfc::OnViewBkColor()
{
    CColorDialog dlg (m_bkColor);
    if (IDOK == dlg.DoModal())
    {
        SetBackColor(dlg.GetColor());
    }
}

void GiGraphViewMfc::OnViewBkImage()
{
    CFileDialog dlg(TRUE, NULL, NULL, OFN_HIDEREADONLY | OFN_FILEMUSTEXIST,
        _T("ͼƬ�ļ� (*.jpg, *.png)|*.jpg;*.png||"), this);

    if (dlg.DoModal() == IDOK) {
        if (LoadImage(dlg.GetPathName()) && getPageRectW().isEmpty()) {
            setPageRectW(Box2d((float)m_image->getWidth(), (float)m_image->getHeight()));
        }
    }
}

void GiGraphViewMfc::OnUpdateViewScale(CCmdUI* pCmdUI)
{
    CString str;
    str.Format(_T("%.2lf%%"), m_graph.xf.getViewScale() * 100.0);
    pCmdUI->SetText(str);
}

void GiGraphViewMfc::OnZoomIn()
{
    if (m_graph.xf.zoomByFactor(0.5f))
        OnZoomed();
}

void GiGraphViewMfc::OnZoomOut()
{
    if (m_graph.xf.zoomByFactor(-0.5f))
        OnZoomed();
}

void GiGraphViewMfc::OnPanLeft()
{
    if (m_graph.xf.zoomPan( (float)m_graph.xf.getWidth() / 4, 0))
        OnZoomed();
}

void GiGraphViewMfc::OnPanRight()
{
    if (m_graph.xf.zoomPan(-(float)m_graph.xf.getWidth() / 4, 0))
        OnZoomed();
}

void GiGraphViewMfc::OnPanUp()
{
    if (m_graph.xf.zoomPan(0,  (float)m_graph.xf.getHeight() / 4))
        OnZoomed();
}

void GiGraphViewMfc::OnPanDown()
{
    if (m_graph.xf.zoomPan(0, -(float)m_graph.xf.getHeight() / 4))
        OnZoomed();
}

void GiGraphViewMfc::OnChar(UINT nChar, UINT nRepCnt, UINT nFlags)
{
    if (nChar == '-' || nChar == '_') {
        OnZoomOut();
    }
    else if (nChar == '+' || nChar == '=') {
        OnZoomIn();
    }
    else {
        CWnd::OnChar(nChar, nRepCnt, nFlags);
    }
}

BOOL GiGraphViewMfc::OnZoomKeyDown(UINT nChar)
{
    BOOL ret = TRUE;

    if (nChar == VK_ADD || nChar == VK_SUBTRACT)        // �Ӽ���:������ʾ
    {
        if (nChar == VK_ADD)
            OnZoomIn();
        else
            OnZoomOut();
    }
#ifdef VK_OEM_PLUS
    else if (nChar == VK_OEM_PLUS || nChar == VK_OEM_MINUS) // �Ӽ���
    {
        if (nChar == VK_OEM_PLUS)
            OnZoomIn();
        else
            OnZoomOut();
    }
#endif
    else if (VK_LEFT == nChar || VK_RIGHT == nChar
        || VK_UP == nChar || VK_DOWN == nChar)          // �����:ƽ����ʾ
    {
        if (VK_LEFT == nChar)
            OnPanLeft();
        if (VK_RIGHT == nChar)
            OnPanRight();
        if (VK_UP == nChar)
            OnPanUp();
        if (VK_DOWN == nChar)
            OnPanDown();
    }
    else
    {
        ret = FALSE;
    }

    return ret;
}

BOOL GiGraphViewMfc::OnMouseWheel(UINT nFlags, short zDelta, CPoint)
{
    if (nFlags & MK_LBUTTON)
        return FALSE;

    // (Ctrl��ո�)+����: ������ʾ
    if ((nFlags & MK_CONTROL) || GetAsyncKeyState(VK_SPACE) < 0) {
        if (m_graph.xf.zoomByFactor(zDelta > 0 ? 0.2f : -0.2f))
            OnZoomed();
    }
    else if (nFlags & MK_SHIFT) {   // Shift+����: ����ƽ��, nFlags=0xFF
        SendMessage(WM_KEYDOWN, zDelta > 0 ? VK_LEFT : VK_RIGHT, 0xFF0000);
    }
    else {
        SendMessage(WM_KEYDOWN, zDelta > 0 ? VK_UP : VK_DOWN, 0xFF0000);
    }

    return TRUE;
}

int GiGraphViewMfc::OnCreate(LPCREATESTRUCT lpCreateStruct)
{
    if (CWnd::OnCreate(lpCreateStruct) == -1)
        return -1;

    // ��ʾ������������ʱ˫�򶼲��ɹ���
    //
    SCROLLINFO si;
    si.cbSize = sizeof(si);
    si.fMask = SIF_RANGE;
    si.nMin = 0;
    si.nMax = 1;
    ::SetScrollInfo(m_hWnd, SB_HORZ, &si, FALSE);
    ::SetScrollInfo(m_hWnd, SB_VERT, &si, FALSE);
    ::EnableScrollBar(m_hWnd, SB_BOTH, ESB_DISABLE_BOTH);

    return 0;
}

void GiGraphViewMfc::OnHScroll(UINT nSBCode, UINT nPos, CScrollBar*)
{
    SCROLLINFO si;
    si.cbSize = sizeof(si);
    si.fMask = SIF_RANGE | SIF_PAGE | SIF_POS | SIF_TRACKPOS;
    ::GetScrollInfo(m_hWnd, SB_HORZ, &si);
    int nPage = static_cast<int>(si.nPage);

    switch (nSBCode)
    {
    case SB_LEFT:               // Scroll to far left.
        si.nPos = si.nMin;
        break;
    case SB_LINELEFT:           // Scroll left.
        si.nPos = max(si.nPos - max(20, nPage / 10), si.nMin);
        break;
    case SB_LINERIGHT:          // Scroll right.
        si.nPos = min(si.nPos + max(20, nPage / 10), si.nMax);
        break;
    case SB_PAGELEFT:           // Scroll one page left.
        si.nPos = max(si.nPos - nPage, si.nMin);
        break;
    case SB_PAGERIGHT:          // Scroll one page right.
        si.nPos = min(si.nPos + nPage, si.nMax);
        break;
    case SB_RIGHT:              // Scroll to far right.
        si.nPos = si.nMax;
        break;
    case SB_THUMBPOSITION:      // Scroll to absolute position.
        si.nPos = nPos;
        m_pan.cx = m_pan.cy = 0;
        break;
    case SB_THUMBTRACK:         // Drag to absolute position.
        OnHScrThumbTrack(si, nPos);
        break;
    case SB_ENDSCROLL:          // End draging
        if (m_graph.xf.zoomPan((float)(m_rcScrWnd.left - si.nPos), 0))
        {
            ::OffsetRect(&m_rcScrWnd, si.nPos - m_rcScrWnd.left, 0);
            m_pan.cx = 0;
            Invalidate();
        }
        else
            si.nPos = m_rcScrWnd.left;
        break;
    }

    ::SetScrollPos(m_hWnd, SB_HORZ, si.nPos, TRUE);
}

void GiGraphViewMfc::OnHScrThumbTrack(SCROLLINFO &si, UINT nPos)
{
    si.nPos = nPos;
    m_pan.cx = m_rcScrWnd.left - si.nPos;
    Invalidate();
    if (NeedUpdatePan())
    {
        if (m_graph.xf.zoomPan((float)(m_rcScrWnd.left - si.nPos), 0))
        {
            ::OffsetRect(&m_rcScrWnd, si.nPos - m_rcScrWnd.left, 0);
            m_pan.cx = 0;
        }
        else
            si.nPos = m_rcScrWnd.left;
    }
}

void GiGraphViewMfc::OnVScroll(UINT nSBCode, UINT nPos, CScrollBar*)
{
    SCROLLINFO si;
    si.cbSize = sizeof(si);
    si.fMask = SIF_RANGE | SIF_PAGE | SIF_POS | SIF_TRACKPOS;
    ::GetScrollInfo(m_hWnd, SB_VERT, &si);
    int nPage = static_cast<int>(si.nPage);

    switch (nSBCode)
    {
    case SB_TOP:                // Scroll to far up.
        si.nPos = si.nMin;
        break;
    case SB_LINEUP:             // Scroll up.
        si.nPos = max(si.nPos - max(20, nPage / 10), si.nMin);
        break;
    case SB_LINEDOWN:           // Scroll down.
        si.nPos = min(si.nPos + max(20, nPage / 10), si.nMax);
        break;
    case SB_PAGEUP:             // Scroll one page up.
        si.nPos = max(si.nPos - nPage, si.nMin);
        break;
    case SB_PAGEDOWN:           // Scroll one page down.
        si.nPos = min(si.nPos + nPage, si.nMax);
        break;
    case SB_BOTTOM:             // Scroll to far down.
        si.nPos = si.nMax;
        break;
    case SB_THUMBPOSITION:      // Scroll to absolute position.
        si.nPos = nPos;
        m_pan.cx = m_pan.cy = 0;
        break;
    case SB_THUMBTRACK:         // Drag to absolute position.
        OnVScrThumbTrack(si, nPos);
        break;
    case SB_ENDSCROLL:          // End draging
        if (m_graph.xf.zoomPan(0, (float)(m_rcScrWnd.top - si.nPos)))
        {
            ::OffsetRect(&m_rcScrWnd, 0, si.nPos - m_rcScrWnd.top);
            m_pan.cy = 0;
            Invalidate();
        }
        else
            si.nPos = m_rcScrWnd.top;
        break;
    }

    ::SetScrollPos(m_hWnd, SB_VERT, si.nPos, TRUE);
}

void GiGraphViewMfc::OnVScrThumbTrack(SCROLLINFO &si, UINT nPos)
{
    si.nPos = nPos;
    m_pan.cy = m_rcScrWnd.top - si.nPos;
    Invalidate();
    if (NeedUpdatePan())
    {
        if (m_graph.xf.zoomPan(0, (float)(m_rcScrWnd.top - si.nPos)))
        {
            ::OffsetRect(&m_rcScrWnd, 0, si.nPos - m_rcScrWnd.top);
            m_pan.cy = 0;
        }
        else
            si.nPos = m_rcScrWnd.top;
    }
}

bool GiGraphViewMfc::NeedUpdatePan()
{
    return m_bRealPan //|| fabsf(m_graph.xf.getViewScale() - 1.0) < 0.01
        || abs(m_pan.cx) > m_graph.xf.getWidth() * 4 / 5
        || abs(m_pan.cy) > m_graph.xf.getHeight() * 4 / 5;
}

void GiGraphViewMfc::OnUpdateRealPan(CCmdUI* pCmdUI)
{
    pCmdUI->SetCheck(m_bRealPan ? 1 : 0);
}

void GiGraphViewMfc::OnViewRealPan()
{
    m_bRealPan = !m_bRealPan;
}

CString GiGraphViewMfc::GetCmdCaption(UINT nID)
{
    int index = nID - GetFirstCmdID();
    if (index >= 0 && index < s_cmdCount) {
        return s_cmds[index].caption;
    }

    index = nID - GetContextActionFirstID();
    if (index >= 0 && index < sizeof(m_actions)/sizeof(m_actions[0])) {
		int action = m_actions[index];
        return ACTION_NAMES[action];
	}

    return _T("");
}

LPCSTR GiGraphViewMfc::GetCmdName(UINT nID)
{
    int index = nID - GetFirstCmdID();
    return (index >= 0 && index < s_cmdCount) ? s_cmds[index].name : "";
}

void GiGraphViewMfc::OnUpdateCmds(CCmdUI* pCmdUI)
{
    LPCSTR name = GetCmdName(pCmdUI->m_nID);
    LPCSTR curname = mgGetCommandManager()->getCommandName();

    pCmdUI->SetText(GetCmdCaption(pCmdUI->m_nID));
    pCmdUI->Enable(*name != 0);
    pCmdUI->SetCheck(strcmp(name, curname) == 0 ? 1 : 0);
}

void GiGraphViewMfc::OnCmds(UINT nID)
{
    if (nID >= GetFirstCmdID() && nID - GetFirstCmdID() < s_cmdCount) {
        setCommand(s_cmds[nID - GetFirstCmdID()].name);
    }
}

bool GiGraphViewMfc::setCommand(const char* name)
{
    bool ret = true;

    if (strcmp(name, "*zoomin") == 0) {
        OnZoomIn();
    }
    else if (strcmp(name, "*zoomout") == 0) {
        OnZoomOut();
    }
    else if (strcmp(name, "*zoomall") == 0) {
        OnZoomExtent();
    }
    else if (strcmp(name, "*zoom100") == 0) {
        OnZoom100();
    }
    else if (strcmp(name, "*zoomwidth") == 0) {
        OnZoomWidth();
    }
    else {
        ret = mgGetCommandManager()->setCommand(&m_proxy->motion, name);
    }

    return ret;
}

CString GiGraphViewMfc::getCommand() const
{
    USES_CONVERSION;
    return A2T((LPSTR)mgGetCommandManager()->getCommandName());
}

void GiGraphViewMfc::DynDraw(GiGraphics* gs)
{
    MgCommand* cmd = mgGetCommandManager()->getCommand();
    if (cmd) {
        cmd->draw(&m_proxy->motion, gs);
    }

    GiContext ctx(0, GiColor(128, 0, 0, 16), kGiLineDashDotdot);
    gs->drawRect(&ctx, m_doc->getExtent());

    ctx.setLineColor(0, 0, 128);
    gs->drawRect(&ctx, m_doc->getPageRectW(), false);
}

void GiGraphViewMfc::OnMouseMove(UINT nFlags, CPoint point)
{
    CWnd::OnMouseMove(nFlags, point);

    MgCommand* cmd = mgGetCommandManager()->getCommand();

    m_proxy->motion.dragging = (!m_delayUp && (nFlags & MK_LBUTTON)
        && (m_downFlags & MK_LBUTTON));
    m_proxy->setPoint(point);

    if (m_downFlags & MK_MBUTTON)       // �ո�+����϶�: ƽ����ʾ
    {
        m_graph.xf.zoomTo(m_proxy->motion.startPointM);
        m_graph.xf.zoomPan(m_proxy->motion.point.x - m_proxy->motion.startPoint.x,
            m_proxy->motion.point.y - m_proxy->motion.startPoint.y);
        OnZoomed();
    }
    else if (m_proxy->motion.dragging)
    {
        if (!m_moved && mgHypot(m_proxy->motion.point.x - m_proxy->motion.startPoint.x,
            m_proxy->motion.point.y - m_proxy->motion.startPoint.y) > 5)
        {
            m_moved = true;
            if (cmd) cmd->touchBegan(&m_proxy->motion);
        }
        else if (m_moved)
        {
            if (cmd) cmd->touchMoved(&m_proxy->motion);
        }

        m_proxy->motion.lastPoint = m_proxy->motion.point;
        m_proxy->motion.lastPointM = m_proxy->motion.pointM;
    }
    else if (cmd && !(nFlags & MK_LBUTTON))
    {
        cmd->mouseHover(&m_proxy->motion);
    }
}

void GiGraphViewMfc::OnLButtonDown(UINT nFlags, CPoint point)
{
    CWnd::OnLButtonDown(nFlags, point);

    SetFocus();
    SetCapture();

    if (s_clickParams.hThread) {
        CloseHandle(s_clickParams.hThread);
        s_clickParams.hThread = NULL;
        OnDelayLButtonUp(s_clickParams.downTick, s_clickParams.downFlags);
    }

    m_proxy->setPoint(point);
    m_proxy->motion.startPoint = m_proxy->motion.point;
    m_proxy->motion.startPointM = m_proxy->motion.pointM;
    m_proxy->motion.lastPoint = m_proxy->motion.point;
    m_proxy->motion.lastPointM = m_proxy->motion.pointM;
    m_moved = false;
    m_delayUp = false;
    m_downTime = GetTickCount();
    m_downFlags = nFlags;

    if (GetAsyncKeyState(VK_SPACE) < 0)     // �ո�+����϶�: ƽ����ʾ
    {
        m_downFlags |= MK_MBUTTON;
        m_proxy->motion.startPointM = m_graph.xf.getCenterW();
    }
}

void GiGraphViewMfc::OnLButtonUp(UINT nFlags, CPoint point)
{
    CWnd::OnLButtonUp(nFlags, point);
    ReleaseCapture();

    if (m_delayUp)
    {
        m_delayUp = false;
    }
    else if (m_moved)
    {
        MgCommand* cmd = mgGetCommandManager()->getCommand();
        if (cmd) cmd->touchEnded(&m_proxy->motion);
    }
    else if (Point2d((float)point.x, (float)point.y) == m_proxy->motion.startPoint
        && s_clickParams.hThread == NULL)
    {
        s_clickParams.hWnd = GetSafeHwnd();
        s_clickParams.downTick = m_downTime;
        s_clickParams.downFlags = m_downFlags;

        DWORD idThread;
        s_clickParams.hThread = ::CreateThread(NULL, 0, ClickThread, 0, 0, &idThread);
        m_delayUp = true;
    }
    m_downFlags &= ~MK_MBUTTON;
}

DWORD WINAPI ClickThread(LPVOID)
{
    Sleep(10);
    ::PostMessage(s_clickParams.hWnd, WM_DELAY_LBUTTONUP,
        s_clickParams.downTick, s_clickParams.downFlags);
    return 0;
}

LRESULT GiGraphViewMfc::OnDelayLButtonUp(WPARAM wp, LPARAM)
{
    long downTime = (long)wp;

    if (downTime == m_downTime && m_delayUp)
    {
        MgCommand* cmd = mgGetCommandManager()->getCommand();
        if (cmd) cmd->click(&m_proxy->motion);
    }
    m_delayUp = false;
    m_downFlags = 0;

    return 0;
}

void GiGraphViewMfc::Cancel()
{
    MgCommand* cmd = mgGetCommandManager()->getCommand();
    if (cmd)
        cmd->cancel(&m_proxy->motion);

    if (m_downFlags) {
        m_proxy->motion.dragging = false;
        m_downFlags = 0;
        ReleaseCapture();
    }
}

void GiGraphViewMfc::OnLButtonDblClk(UINT nFlags, CPoint point)
{
    CWnd::OnLButtonDblClk(nFlags, point);

    m_delayUp = false;
    m_downFlags = 0;
    m_downTime = 0;

    MgCommand* cmd = mgGetCommandManager()->getCommand();
    if (cmd) cmd->doubleClick(&m_proxy->motion);
}

void GiGraphViewMfc::OnKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags)
{
    int n;

    if (nChar == VK_ESCAPE)     // Esc:ȡ������
    {
        Cancel();
    }
    else if (nChar == VK_DELETE || nChar == VK_BACK)    // Del:ɾ��ͼ��
    {
        MgSelection* sel = mgGetCommandManager()->getSelection(m_proxy);
        if (!sel || !sel->deleteSelection(m_proxy)) {
            bool enableRecall;
            MgCommand* cmd = mgGetCommandManager()->getCommand();
            if (cmd && nChar == VK_BACK) {              // Backspace: ����
                cmd->undo(enableRecall, &m_proxy->motion);
            }
        }
    }
    else if ((VK_LEFT == nChar || VK_RIGHT == nChar
        || VK_UP == nChar || VK_DOWN == nChar)      // �����:ƽ����ʾ���ƶ�ͼ��
        && (n = mgGetCommandManager()->getSelection(m_proxy, 0, NULL)) > 0
        && nFlags != 0xFF)                          // ���ǹ��ֹ���
    {
        MgShape* sp[20];
        MgShapesLock locker(m_doc, MgShapesLock::Edit);
        n = mgGetCommandManager()->getSelection(m_proxy, mgMin(20, n), sp);

        Vector2d vec((VK_LEFT == nChar) ? -1.f : (VK_RIGHT == nChar) ? 1.f : 0.f,
            (VK_UP == nChar) ? -1.f : (VK_DOWN == nChar) ? 1.f : 0.f);

        if (GetAsyncKeyState(VK_SHIFT) < 0) {       // Shift+�����: �ı���
            int index = mgIsZero(vec.y) ? 5 : 4;
            for (int i = 0; i < n; i++) {
                sp[i]->shape()->setHandlePoint(index, 
                    sp[i]->shape()->getHandlePoint(index) + vec, 0);
                sp[i]->shape()->update();
            }
        }
        else {                                      // �����: �ƶ�ͼ��
            for (int i = 0; i < n; i++) {
                sp[i]->shape()->offset(vec, -1);
                m_proxy->shapeMoved(sp[i], -1);
                sp[i]->shape()->update();
            }
        }
        m_proxy->regen();
    }
    else if (!OnZoomKeyDown(nChar)) {
        CWnd::OnKeyDown(nChar, nRepCnt, nFlags);
    }
}

UINT GiGraphViewMfc::GetDefaultContextMenuID(int& subMenuIndex) const
{
    subMenuIndex = -1;
    return 0;
}

void GiGraphViewMfc::OnContextMenu(CWnd*, CPoint point)
{
    MgCommand* cmd = mgGetCommandManager()->getCommand();

    if (point.x > 0 && point.y > 0)
    {
        ScreenToClient(&point);
        m_proxy->setPoint(point);
    }

    if (cmd)
    {
        cmd->longPress(&m_proxy->motion);
    }
    else
    {
        int actions[] = { 0 };
        showContextActions(actions);
    }
}

bool GiGraphViewMfc::showContextActions(const int* actions)
{
    CMenu menu;
    CMenu* popupMenu = NULL;

    if (actions && actions[0])
    {
        menu.LoadMenu(GetContextActionMenuID());
        popupMenu = menu.GetSubMenu(0);

        int i, n = popupMenu ? popupMenu->GetMenuItemCount() : 0;
        for (i = 0; i < n && actions[i] > 0; i++) {
            m_actions[i] = actions[i];
        }
        while (--n >= i) {
            m_actions[i] = 0;
            popupMenu->RemoveMenu(GetContextActionFirstID() + n, MF_BYCOMMAND);
        }
    }
    else
    {
        int subMenuIndex;
        UINT nID = GetDefaultContextMenuID(subMenuIndex);
        
        if (nID != 0) {
            menu.LoadMenu(nID);
            popupMenu = menu.GetSubMenu(subMenuIndex);
        }
    }

    CPoint point(mgRound(m_proxy->motion.point.x), mgRound(m_proxy->motion.point.y));
    if (m_proxy->motion.point == Point2d::kOrigin())
        point.x = m_graph.xf.getWidth() / 2 - 20;
    ClientToScreen(&point);

    return popupMenu && popupMenu->TrackPopupMenu(TPM_RIGHTBUTTON | TPM_LEFTALIGN,
        point.x, point.y, GetParentFrame());
}

void GiGraphViewMfc::OnUpdateContextItems(CCmdUI* pCmdUI)
{
    int index = pCmdUI->m_nID - GetContextActionFirstID();
	int action = 0;

    if (index >= 0 && index < sizeof(m_actions)/sizeof(m_actions[0])) {
        action = m_actions[index];
    }

    bool enabled = action > 0 && action < sizeof(ACTION_NAMES)/sizeof(ACTION_NAMES[0]);
    pCmdUI->Enable(enabled);
    pCmdUI->SetText(enabled ? ACTION_NAMES[action] : _T("?"));
}

void GiGraphViewMfc::OnContextItems(UINT nID)
{
    int index = nID - GetContextActionFirstID();

    if (index >= 0 && index < sizeof(m_actions)/sizeof(m_actions[0])) {
        int action = m_actions[index];
        mgGetCommandManager()->doContextAction(&m_proxy->motion, action);
    }
}

void GiGraphViewMfc::OnUpdateModified(CCmdUI* pCmdUI)
{
    pCmdUI->SetText(IsModified() ? _T("�Ķ�") : _T(""));
}

void GiGraphViewMfc::OnUpdateSelectAll(CCmdUI* pCmdUI)
{
	pCmdUI->Enable(m_doc->getShapeCount() > 0
        && mgGetCommandManager()->getSelection(m_proxy) != NULL);
}

void GiGraphViewMfc::OnSelectAll()
{
	MgSelection* sel = mgGetCommandManager()->getSelection(m_proxy);
	if (sel)
		sel->selectAll(m_proxy);
}

void GiGraphViewMfc::OnUpdateClearAll(CCmdUI* pCmdUI)
{
	pCmdUI->Enable(m_doc->getShapeCount() > 0);
}

void GiGraphViewMfc::OnClearAll()
{
    CString msg;
    msg.Format(_T("Ҫȫ��ɾ���� %d ��ͼ����"), m_doc->getShapeCount());
    if (AfxMessageBox(msg, MB_YESNO) != IDYES)
        return;

	MgSelection* sel = mgGetCommandManager()->getSelection(m_proxy);
    if (sel) {
		sel->selectAll(m_proxy);
        sel->deleteSelection(m_proxy);
    }
}

void GiGraphViewMfc::OnInitialUpdate()
{
    if (!m_filename.IsEmpty()) {
        m_graph.xf.setModelTransform(m_doc->modelTransform());
        m_graph.xf.zoomTo(m_doc->getPageRectW());
        m_graph.xf.zoomScale(m_doc->getViewScale());
        OnZoomed();
    }
}

bool GiGraphViewMfc::IsModified() const
{
    return m_doc->getChangeCount() != m_lastChanges;
}

void GiGraphViewMfc::SetModified(bool modified)
{
    m_lastChanges = modified ? 0 : m_doc->getChangeCount();
}

bool GiGraphViewMfc::LoadContent(LPCTSTR content)
{
    m_doc->clear();
    m_doc->setPageRectW(Box2d(), 0);

    USES_CONVERSION;
    MgJsonStorage s;
    bool ret = m_doc->load(s.storageForRead(T2A((LPTSTR)(LPCTSTR)content)));
    Box2d rectW(m_doc->getPageRectW());

    if (ret) {
        if (m_doc->getShapeCount() > 0) {
            setCommand("select");
        }
    }
    else if (content && *content) {
        CString str;
        str.Format(_T("��ȡ�ļ����ݳ���\n%s"), A2T((LPSTR)s.getParseError()));
        AfxMessageBox(str);
    }

    m_graph.xf.setModelTransform(m_doc->modelTransform());
    m_graph.xf.setWorldLimits(rectW);
    if (rectW.isEmpty()) {
        m_graph.xf.zoomTo(m_doc->getExtent() * m_doc->modelTransform());
    }
    else {
        m_graph.xf.zoomTo(rectW);
    }

    m_lastChanges = m_doc->getChangeCount();
    OnZoomed();

    return ret;
}

bool GiGraphViewMfc::LoadShapeFile(LPCTSTR filename)
{
    m_filename = filename;

    std::string content;
    CFile file;
    USES_CONVERSION;

    if (file.Open(filename, CFile::modeRead) && file.GetLength() > 0) {
        content.resize((UINT)file.GetLength(), 0);
        file.Read(&content[0], (UINT)content.size());
    }

    bool ret = LoadContent(A2T(&content[0]));

    CFrameWnd* pFrameWnd = GetParentFrame();
    if (pFrameWnd) {
        pFrameWnd->UpdateFrameTitleForDocument(
            m_filename.IsEmpty() ? _T("Untitled") : m_filename);
    }
    
    return ret;
}

void GiGraphViewMfc::OnUpdateFileSave(CCmdUI* pCmdUI)
{
    pCmdUI->Enable(IsModified());
}

CString GiGraphViewMfc::GetContent() const
{
    MgJsonStorage s;
    USES_CONVERSION;

    if (m_doc->save(s.storageForWrite())) {
        return A2T((LPSTR)s.stringify(true));
    }
    else {
        AfxMessageBox(_T("�õ��ļ����ݳ���"));
        return _T("");
    }
}

void GiGraphViewMfc::OnFileSave()
{
    if (m_filename.IsEmpty())
    {
        CFileDialog dlg(FALSE, _T(".vg"), NULL,
            OFN_HIDEREADONLY | OFN_OVERWRITEPROMPT | OFN_PATHMUSTEXIST,
            _T("ʸ��ͼ���ļ� (*.vg)|*.vg||"), this);
        if (dlg.DoModal() != IDOK)
            return;
        m_filename = dlg.GetPathName();
    }

    MgJsonStorage s;

    if (m_doc->save(s.storageForWrite()))
    {
        const char* content = s.stringify(true);
        CFile file;
        CFileException e;
        if (file.Open(m_filename, CFile::modeWrite | CFile::modeCreate, &e)) {
            file.Write(content, (UINT)strlen(content));
            m_lastChanges = m_doc->getChangeCount();
            OnSaved();

            CFrameWnd* pFrameWnd = GetParentFrame();
            if (pFrameWnd) {
                pFrameWnd->UpdateFrameTitleForDocument(m_filename);
            }
        }
        else {
            e.ReportError();
        }
    }
    else {
        AfxMessageBox(_T("�õ��ļ����ݳ���"));
    }
}

void GiGraphViewMfc::OnFileSaveAs()
{
    CFileDialog dlg(FALSE, _T(".vg"), m_filename,
        OFN_HIDEREADONLY | OFN_OVERWRITEPROMPT | OFN_PATHMUSTEXIST,
        _T("ʸ��ͼ���ļ� (*.vg)|*.vg||"), this);
    if (dlg.DoModal() == IDOK) {
        m_filename = dlg.GetPathName();
        OnFileSave();
    }
}

Box2d GiGraphViewMfc::getPageRectW() const
{
    return m_doc->getPageRectW();
}

void GiGraphViewMfc::setPageRectW(const Box2d& rectW)
{
    m_doc->setPageRectW(rectW, m_doc->getViewScale());
    m_graph.xf.setWorldLimits(rectW);
}

bool GiGraphViewMfc::HasBackground() const
{
    return m_image && m_image->getHeight() > 0;
}

void GiGraphViewMfc::DrawBackground(GiCanvasWin *cv)
{
    m_image->draw(*cv, getPageRectW());
}

void GiGraphViewMfc::regen()
{
    m_graph.canvas->clearCachedBitmap(true);
    Invalidate();
}

bool GiGraphViewMfc::LoadImage(LPCTSTR filename)
{
    delete m_image;
    m_image = new GiGdipImage();

    if (!m_tmpPicFile.IsEmpty()) {
        ::DeleteFile(m_tmpPicFile);
    }

    regen();

    USES_CONVERSION;
    TCHAR path[MAX_PATH], tmpname[MAX_PATH];
    
    GetTempPath(MAX_PATH, path);
    GetTempFileName(path, _T("vg"), 0, tmpname);
    m_tmpPicFile = tmpname;

    if (filename && *filename
        && !CopyFile(filename, m_tmpPicFile, FALSE))
    {
        CString str;
        str.Format(_T("�޷���ͼƬ�ļ�: %s"), filename);
        AfxMessageBox(str);
    }
    m_lastTime = GetModifyTime(filename);
    if (m_picFile != filename)
        m_picFile = filename;

    return m_image->open(T2W((LPTSTR)(LPCTSTR)m_tmpPicFile));
}

void GiGraphViewMfc::CheckNewBitmap()
{
    CString nowTime (GetModifyTime(m_picFile));

    if (!nowTime.IsEmpty() && nowTime != m_lastTime)
    {
        LoadImage(m_picFile);
    }
}

CString GiGraphViewMfc::GetModifyTime(LPCTSTR filename)
{
    TCHAR szTime[30] = { 0 };
    FILETIME ftCreate, ftAccess, ftWrite;
    SYSTEMTIME stUTC, stLocal;

    HANDLE hfile = CreateFile(filename, GENERIC_READ, FILE_SHARE_READ, 
        NULL, OPEN_EXISTING, 0, NULL);

    if (hfile != INVALID_HANDLE_VALUE)
    {
        if (GetFileTime(hfile, &ftCreate, &ftAccess, &ftWrite))
        {
            FileTimeToSystemTime(&ftWrite, &stUTC);
            SystemTimeToTzSpecificLocalTime(NULL, &stUTC, &stLocal);

#ifndef _stprintf_s
			_stprintf(szTime,
#else
            _stprintf_s(szTime, sizeof(szTime)/sizeof(szTime[0]),
#endif
				_T("%04d-%02d-%02d %02d:%02d:%02d.%03d"),
                stLocal.wYear, stLocal.wMonth, stLocal.wDay,
                stLocal.wHour, stLocal.wMinute, stLocal.wSecond, stLocal.wMilliseconds);
        }
        CloseHandle(hfile);
    }

    return szTime;
}

void GiGraphViewMfc::OnUpdateFileReload(CCmdUI* pCmdUI)
{
    pCmdUI->Enable(IsModified());
}

void GiGraphViewMfc::OnFileReload()
{
    LoadShapeFile(GetFileName());
}

void GiGraphViewMfc::OnUpdatePenMode(CCmdUI* pCmdUI)
{
    pCmdUI->SetCheck(m_proxy->penMode ? 1 : 0);
}

void GiGraphViewMfc::OnPenMode()
{
    m_proxy->penMode = !m_proxy->penMode;
}

GiContext& GiGraphViewMfc::context()
{
    MgShape* shape = NULL;
    mgGetCommandManager()->getSelection(m_proxy, 1, &shape, false);
    return shape ? *shape->context() : *m_proxy->context();
}

void GiGraphViewMfc::applyContext(const GiContext& ctx, int mask, int apply)
{
    if (mask != 0) {
        int n = mgGetCommandManager()->getSelection(m_proxy, 0, NULL, true);
        std::vector<MgShape*> shapes(n, NULL);

        if (n > 0 && mgGetCommandManager()->getSelection(m_proxy, n, 
                (MgShape**)&shapes.front(), true) > 0) {
            for (int i = 0; i < n; i++) {
                if (shapes[i]) {
                    shapes[i]->context()->copy(ctx, mask);
                }
            }
            m_proxy->redraw(false);
        }
        else {
            m_proxy->context()->copy(ctx, mask);
        }
    }

    if (apply != 0) {
        mgGetCommandManager()->dynamicChangeEnded(m_proxy, apply > 0);
    }
}

void GiGraphViewMfc::OnLineColor()
{
    GiContext& ctx = context();
    GiColor c(ctx.getLineColor());
    COLORREF color = RGB(c.r, c.g, c.b);
    CColorDialog dlg (color);

    if (IDOK == dlg.DoModal())
    {
        color = dlg.GetColor();
        c.set(GetRValue(color), GetGValue(color), GetBValue(color));

        if (ctx.getLineColor() != c) {
            ctx.setLineColor(c);
            applyContext(ctx, kContextLineRGB);
        }
    }
}

void GiGraphViewMfc::OnLineBold()
{
    GiContext& ctx = context();
    float w = ctx.getLineWidth();

    if (w < 0) {
        if (w > -50)
            w--;
    }
    else {
        if (w < 1000)
            w += 10;
    }

    if (!mgEquals(w ,ctx.getLineWidth())) {
        ctx.setLineWidth(w, true);
        applyContext(ctx, kContextLineWidth);
    }
}

void GiGraphViewMfc::OnLineThick()
{
    GiContext& ctx = context();
    float w = ctx.getLineWidth();

    if (w < 0) {
        w++;
    }
    else {
        w -= 10;
        if (w < 0)
            w = -1;
    }

    if (!mgEquals(w ,ctx.getLineWidth())) {
        ctx.setLineWidth(w, true);
        applyContext(ctx, kContextLineWidth);
    }
}

void GiGraphViewMfc::OnLineStyle()
{
    GiContext& ctx = context();
    int t = ctx.getLineStyle();

    t = (t + 1) % kGiLineNull;
    ctx.setLineStyle(t);
    applyContext(ctx, kContextLineStyle);
}

void GiGraphViewMfc::OnLineTransparent()
{
    GiContext& ctx = context();
    int a = ctx.getLineAlpha();

    if (a > 5) {
        a -= 5;
        ctx.setLineAlpha(a);
        applyContext(ctx, kContextLineAlpha);
    }
}

void GiGraphViewMfc::OnLineOpaque()
{
    GiContext& ctx = context();
    int a = ctx.getLineAlpha();

    if (a < 250) {
        a += 5;
        ctx.setLineAlpha(a);
        applyContext(ctx, kContextLineAlpha);
    }
}

void GiGraphViewMfc::OnFillColor()
{
    GiContext& ctx = context();
    GiColor c(ctx.getFillColor());
    COLORREF color = RGB(c.r, c.g, c.b);
    CColorDialog dlg (color);

    if (IDOK == dlg.DoModal())
    {
        color = dlg.GetColor();
        c.set(GetRValue(color), GetGValue(color), GetBValue(color));

        if (ctx.getFillColor() != c) {
            ctx.setFillColor(c);
            applyContext(ctx, kContextFillRGB);
        }
    }
}

void GiGraphViewMfc::OnFillTransparent()
{
    GiContext& ctx = context();
    int a = ctx.getFillAlpha();

    if (a > 5) {
        a -= 5;
        ctx.setFillAlpha(a);
        applyContext(ctx, kContextFillAlpha);
    }
}

void GiGraphViewMfc::OnFillOpaque()
{
    GiContext& ctx = context();
    int a = ctx.getFillAlpha();

    if (a < 250) {
        a += 5;
        ctx.setFillAlpha(a);
        applyContext(ctx, kContextFillAlpha);
    }
}

void GiGraphViewMfc::OnUpdateLineWidth(CCmdUI* pCmdUI)
{
    float w = context().getLineWidth();
    CString text;

    if (w > 0) {
        text.Format(_T("L %.2f mm"), w / 100.f);
    }
    else {
        text.Format(_T("L %d px"), mgRound(-w));
    }
    pCmdUI->SetText(text);
}

bool GiGraphViewMfc::ExportImage(LPCTSTR filename, int w, int h)
{
    bool ret = false;

    if (filename && w > 0 && h > 0) {
        GiTransform xf(m_graph.xf);
        GiGraphics gs(&xf);
        GiCanvasGdip cv(&gs);

        xf.setWndSize(w, h);
        xf.zoomTo(m_doc->getPageRectW());

        if (cv.beginPaintBuffered()) {
            cv.clearWindow();
            m_doc->draw(gs);

            GiGdipImage bitmap;
            USES_CONVERSION;

            bitmap.setBitmap(cv.GetBufferedBitmap());
            ret = bitmap.save(T2W((LPTSTR)(LPCTSTR)filename));
            bitmap.setBitmap(NULL);

            cv.endPaint(false);
        }
    }
    
    return ret;
}
