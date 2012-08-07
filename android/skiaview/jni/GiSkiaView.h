//! \file GiSkiaView.h
//! \brief ����֧��Androidƽ̨��ͼ����ͼ�� GiSkiaView
// Copyright (c) 2012, Zhang Yungui
// License: LGPL, https://github.com/rhcad/touchvg

#ifndef __TOUCHVG_SKIAVIEW_H_
#define __TOUCHVG_SKIAVIEW_H_

#include <gigraph.h>
#include <jni.h>

class GiSkiaCanvas;
class GiCmdController;
class MgStorageBase;
struct MgShapes;

//! ֧��Androidƽ̨��ͼ����ͼ��
/*! \ingroup GRAPH_SKIA
*/
class GiSkiaView
{
public:
    GiSkiaView();
    virtual ~GiSkiaView();
    
    //! ����ͼ���б�
    bool saveShapes(MgStorageBase* s);
    
    //! ����ͼ���б�
    bool loadShapes(MgStorageBase* s);

    int getWidth() const;
    int getHeight() const;

    void onSize(int width, int height);
    bool onDraw(jobject canvas);

private:
    GiTransform         m_xf;
    GiGraphics          m_gs;
    GiSkiaCanvas*       m_canvas;
    MgShapes*           m_shapes;
    GiCmdController*    m_cmdc;
};

#endif // __TOUCHVG_SKIAVIEW_H_
