//! \file GiSkiaView.h
//! \brief ����֧��Androidƽ̨��ͼ����ͼ�� GiSkiaView
// Copyright (c) 2012, Zhang Yungui
// License: LGPL, https://github.com/rhcad/touchvg

#ifndef __TOUCHVG_SKIAVIEW_H_
#define __TOUCHVG_SKIAVIEW_H_

#include "GiCanvasBase.h"

class GiCmdController;
class MgStorageBase;
struct MgShapes;

//! ֧��Androidƽ̨��ͼ����ͼ��
/*! \ingroup GRAPH_SKIA
*/
class GiSkiaView
{
public:
    GiSkiaView(GiCanvasBase* canvas);
    virtual ~GiSkiaView();
    
    //! ����ͼ���б�
    bool saveShapes(MgStorageBase* s);

    //! ����ͼ���б�sΪNULL�����
    bool loadShapes(MgStorageBase* s);

    //! ��Ӳ���ͼ��
    int addTestingShapes();

    //! ������ͼ��ȣ�����
    int getWidth() const;

    //! ������ͼ�߶ȣ�����
    int getHeight() const;

    //! ������ͼ��ߣ�����
    void onSize(int width, int height);

    //! ��ʾ��ʽͼ��
    bool onDraw(GiCanvasBase& canvas);

    //! ��ʾ��ʱ��̬ͼ��
    bool onDynDraw(GiCanvasBase& canvas);

private:
    GiCanvasBase* 		_canvas;
    MgShapes*           _shapes;
    GiCmdController*    _cmdc;
};

#endif // __TOUCHVG_SKIAVIEW_H_
