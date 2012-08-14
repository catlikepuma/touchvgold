//! \file GiSkiaView.h
//! \brief ����֧��Androidƽ̨��ͼ����ͼ�� GiSkiaView
// Copyright (c) 2012, Zhang Yungui
// License: LGPL, https://github.com/rhcad/touchvg

#ifndef __TOUCHVG_SKIAVIEW_H_
#define __TOUCHVG_SKIAVIEW_H_

#include "GiCanvasBase.h"

class MgStorageBase;
struct MgShapes;
class MgViewProxy;
class GiContext;

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

    //! ���ص�ǰ��������
    const char* getCommandName() const;

    //! ����ָ�����Ƶ�����
    bool setCommandName(const char* name);

    //! ���ݴ���������Ϣ
    /**
     * \param gestureType �������ͣ�1-��ָ������2-��ָ������3-��ָ˫����4-������5-˫ָ�ƶ���6-˫ָ˫��
     * \param gestureState ����״̬��1-��ʼ��2-�ı䣬3-������0-ȡ����gestureTypeΪ1��5ʱ��Ч
     * \param fingerCount �������
     * \param x1 ��һ�������X���꣬fingerCountС��1ʱ����
     * \param y1 ��һ�������Y���꣬fingerCountС��1ʱ����
     * \param x2 �ڶ��������X���꣬fingerCountС��2ʱ����
     * \param y2 �ڶ��������Y���꣬fingerCountС��2ʱ����
     * \return �ڲ��Ƿ���Ӧ�˴�����
     */
    bool onGesture(int gestureType, int gestureState, int fingerCount,
    		float x1, float y1, float x2, float y2);

    //! ���ص�ǰ��ͼ����
    /**
     * \param forChange �Ƿ����ڸĶ���ͼ����
     * \return ��ǰ��ͼ���ԣ����ѡ����ͼ����Ϊ��ѡͼ�ε�����
     */
    GiContext& getCurrentContext(bool forChange);

    //! ��ͼ���Ըı���ύ����
    /** �� getCurrentContext(true) ����ñ�������
     * \param ctx ��ͼ����
     * \param mask ��ҪӦ����Щ���ԣ�-1��ʾȫ�����ԣ�0���޸ģ���λ���ֵ�� GiContext �� kContextBits
     * \param apply 0��ʾ��Ҫ������̬�޸����ԣ�1��ʾ������̬�޸Ĳ��ύ��-1��ʾ������̬�޸Ĳ������Ķ�
     */
    void applyContext(const GiContext& ctx, int mask, int apply);

private:
    MgViewProxy*		_view;
};

#endif // __TOUCHVG_SKIAVIEW_H_
