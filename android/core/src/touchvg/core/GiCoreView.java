/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class GiCoreView {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected GiCoreView(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GiCoreView obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_GiCoreView(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GiCoreView(GiCoreView mainView) {
    this(touchvgJNI.new_GiCoreView__SWIG_0(GiCoreView.getCPtr(mainView), mainView), true);
  }

  public GiCoreView() {
    this(touchvgJNI.new_GiCoreView__SWIG_1(), true);
  }

  public void createView(GiView view, int type) {
    touchvgJNI.GiCoreView_createView__SWIG_0(swigCPtr, this, GiView.getCPtr(view), view, type);
  }

  public void createView(GiView view) {
    touchvgJNI.GiCoreView_createView__SWIG_1(swigCPtr, this, GiView.getCPtr(view), view);
  }

  public void createMagnifierView(GiView newview, GiView mainView) {
    touchvgJNI.GiCoreView_createMagnifierView(swigCPtr, this, GiView.getCPtr(newview), newview, GiView.getCPtr(mainView), mainView);
  }

  public void destoryView(GiView view) {
    touchvgJNI.GiCoreView_destoryView(swigCPtr, this, GiView.getCPtr(view), view);
  }

  public int drawAll(GiView view, GiCanvas canvas) {
    return touchvgJNI.GiCoreView_drawAll(swigCPtr, this, GiView.getCPtr(view), view, GiCanvas.getCPtr(canvas), canvas);
  }

  public boolean drawAppend(GiView view, GiCanvas canvas) {
    return touchvgJNI.GiCoreView_drawAppend(swigCPtr, this, GiView.getCPtr(view), view, GiCanvas.getCPtr(canvas), canvas);
  }

  public void dynDraw(GiView view, GiCanvas canvas) {
    touchvgJNI.GiCoreView_dynDraw(swigCPtr, this, GiView.getCPtr(view), view, GiCanvas.getCPtr(canvas), canvas);
  }

  public int setBkColor(GiView view, int argb) {
    return touchvgJNI.GiCoreView_setBkColor(swigCPtr, this, GiView.getCPtr(view), view, argb);
  }

  public static void setScreenDpi(int dpi) {
    touchvgJNI.GiCoreView_setScreenDpi(dpi);
  }

  public void onSize(GiView view, int w, int h) {
    touchvgJNI.GiCoreView_onSize(swigCPtr, this, GiView.getCPtr(view), view, w, h);
  }

  public boolean onGesture(GiView view, GiGestureType type, GiGestureState state, float x, float y, boolean switchGesture) {
    return touchvgJNI.GiCoreView_onGesture__SWIG_0(swigCPtr, this, GiView.getCPtr(view), view, type.swigValue(), state.swigValue(), x, y, switchGesture);
  }

  public boolean onGesture(GiView view, GiGestureType type, GiGestureState state, float x, float y) {
    return touchvgJNI.GiCoreView_onGesture__SWIG_1(swigCPtr, this, GiView.getCPtr(view), view, type.swigValue(), state.swigValue(), x, y);
  }

  public boolean twoFingersMove(GiView view, GiGestureState state, float x1, float y1, float x2, float y2, boolean switchGesture) {
    return touchvgJNI.GiCoreView_twoFingersMove__SWIG_0(swigCPtr, this, GiView.getCPtr(view), view, state.swigValue(), x1, y1, x2, y2, switchGesture);
  }

  public boolean twoFingersMove(GiView view, GiGestureState state, float x1, float y1, float x2, float y2) {
    return touchvgJNI.GiCoreView_twoFingersMove__SWIG_1(swigCPtr, this, GiView.getCPtr(view), view, state.swigValue(), x1, y1, x2, y2);
  }

  public boolean isPressDragging() {
    return touchvgJNI.GiCoreView_isPressDragging(swigCPtr, this);
  }

  public GiGestureType getGestureType() {
    return GiGestureType.swigToEnum(touchvgJNI.GiCoreView_getGestureType(swigCPtr, this));
  }

  public GiGestureState getGestureState() {
    return GiGestureState.swigToEnum(touchvgJNI.GiCoreView_getGestureState(swigCPtr, this));
  }

  public String getCommand() {
    return touchvgJNI.GiCoreView_getCommand(swigCPtr, this);
  }

  public boolean setCommand(GiView view, String name, String params) {
    return touchvgJNI.GiCoreView_setCommand__SWIG_0(swigCPtr, this, GiView.getCPtr(view), view, name, params);
  }

  public boolean setCommand(GiView view, String name) {
    return touchvgJNI.GiCoreView_setCommand__SWIG_1(swigCPtr, this, GiView.getCPtr(view), view, name);
  }

  public boolean doContextAction(int action) {
    return touchvgJNI.GiCoreView_doContextAction(swigCPtr, this, action);
  }

  public void clearCachedData() {
    touchvgJNI.GiCoreView_clearCachedData(swigCPtr, this);
  }

  public int addShapesForTest() {
    return touchvgJNI.GiCoreView_addShapesForTest(swigCPtr, this);
  }

  public int getShapeCount() {
    return touchvgJNI.GiCoreView_getShapeCount(swigCPtr, this);
  }

  public int getChangeCount() {
    return touchvgJNI.GiCoreView_getChangeCount(swigCPtr, this);
  }

  public int getSelectedShapeCount() {
    return touchvgJNI.GiCoreView_getSelectedShapeCount(swigCPtr, this);
  }

  public int getSelectedShapeType() {
    return touchvgJNI.GiCoreView_getSelectedShapeType(swigCPtr, this);
  }

  public void clear() {
    touchvgJNI.GiCoreView_clear(swigCPtr, this);
  }

  public boolean loadFromFile(String vgfile) {
    return touchvgJNI.GiCoreView_loadFromFile(swigCPtr, this, vgfile);
  }

  public boolean saveToFile(String vgfile, boolean pretty) {
    return touchvgJNI.GiCoreView_saveToFile__SWIG_0(swigCPtr, this, vgfile, pretty);
  }

  public boolean saveToFile(String vgfile) {
    return touchvgJNI.GiCoreView_saveToFile__SWIG_1(swigCPtr, this, vgfile);
  }

  public String getContent() {
    return touchvgJNI.GiCoreView_getContent(swigCPtr, this);
  }

  public void freeContent() {
    touchvgJNI.GiCoreView_freeContent(swigCPtr, this);
  }

  public boolean setContent(String content) {
    return touchvgJNI.GiCoreView_setContent(swigCPtr, this, content);
  }

  public boolean zoomToExtent() {
    return touchvgJNI.GiCoreView_zoomToExtent(swigCPtr, this);
  }

  public boolean zoomToModel(float x, float y, float w, float h) {
    return touchvgJNI.GiCoreView_zoomToModel(swigCPtr, this, x, y, w, h);
  }

  public float calcPenWidth(float lineWidth) {
    return touchvgJNI.GiCoreView_calcPenWidth(swigCPtr, this, lineWidth);
  }

  public GiContext getContext(boolean forChange) {
    return new GiContext(touchvgJNI.GiCoreView_getContext(swigCPtr, this, forChange), false);
  }

  public void setContext(GiContext ctx, int mask, int apply) {
    touchvgJNI.GiCoreView_setContext__SWIG_0(swigCPtr, this, GiContext.getCPtr(ctx), ctx, mask, apply);
  }

  public void setContext(int mask) {
    touchvgJNI.GiCoreView_setContext__SWIG_1(swigCPtr, this, mask);
  }

  public void setContextEditing(boolean editing) {
    touchvgJNI.GiCoreView_setContextEditing(swigCPtr, this, editing);
  }

  public boolean addImageShape(String name, float width, float height) {
    return touchvgJNI.GiCoreView_addImageShape(swigCPtr, this, name, width, height);
  }

  public boolean getBoundingBox(Floats box) {
    return touchvgJNI.GiCoreView_getBoundingBox(swigCPtr, this, Floats.getCPtr(box), box);
  }

  public int viewAdapterHandle() {
    return touchvgJNI.GiCoreView_viewAdapterHandle(swigCPtr, this);
  }

  public MgView viewAdapter() {
    long cPtr = touchvgJNI.GiCoreView_viewAdapter(swigCPtr, this);
    return (cPtr == 0) ? null : new MgView(cPtr, false);
  }

}
