/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class MgShapes extends MgObject {
  private long swigCPtr;

  protected MgShapes(long cPtr, boolean cMemoryOwn) {
    super(skiaviewJNI.MgShapes_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgShapes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_MgShapes(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static int Type() {
    return skiaviewJNI.MgShapes_Type();
  }

  public MgShapes cloneShapes() {
    long cPtr = skiaviewJNI.MgShapes_cloneShapes(swigCPtr, this);
    return (cPtr == 0) ? null : new MgShapes(cPtr, false);
  }

  public int getShapeCount() {
    return skiaviewJNI.MgShapes_getShapeCount(swigCPtr, this);
  }

  public MgShape getLastShape() {
    long cPtr = skiaviewJNI.MgShapes_getLastShape(swigCPtr, this);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShape(int sid) {
    long cPtr = skiaviewJNI.MgShapes_findShape(swigCPtr, this, sid);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShapeByTag(int tag) {
    long cPtr = skiaviewJNI.MgShapes_findShapeByTag(swigCPtr, this, tag);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShapeByType(int type) {
    long cPtr = skiaviewJNI.MgShapes_findShapeByType(swigCPtr, this, type);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public Box2d getExtent() {
    return new Box2d(skiaviewJNI.MgShapes_getExtent(swigCPtr, this), true);
  }

  public MgShape hitTest(Box2d limits, Point2d nearpt) {
    long cPtr = skiaviewJNI.MgShapes_hitTest(swigCPtr, this, Box2d.getCPtr(limits), limits, Point2d.getCPtr(nearpt), nearpt);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public int draw(GiGraphics gs, GiContext ctx) {
    return skiaviewJNI.MgShapes_draw__SWIG_0(swigCPtr, this, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx);
  }

  public int draw(GiGraphics gs) {
    return skiaviewJNI.MgShapes_draw__SWIG_1(swigCPtr, this, GiGraphics.getCPtr(gs), gs);
  }

  public int getChangeCount() {
    return skiaviewJNI.MgShapes_getChangeCount(swigCPtr, this);
  }

  public void afterChanged() {
    skiaviewJNI.MgShapes_afterChanged(swigCPtr, this);
  }

  public boolean save(MgStorage s, int startIndex) {
    return skiaviewJNI.MgShapes_save__SWIG_0(swigCPtr, this, MgStorage.getCPtr(s), s, startIndex);
  }

  public boolean save(MgStorage s) {
    return skiaviewJNI.MgShapes_save__SWIG_1(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public boolean load(MgStorage s, boolean addOnly) {
    return skiaviewJNI.MgShapes_load__SWIG_0(swigCPtr, this, MgStorage.getCPtr(s), s, addOnly);
  }

  public boolean load(MgStorage s) {
    return skiaviewJNI.MgShapes_load__SWIG_1(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public void clear() {
    skiaviewJNI.MgShapes_clear(swigCPtr, this);
  }

  public MgShape addShape(MgShape src) {
    long cPtr = skiaviewJNI.MgShapes_addShape(swigCPtr, this, MgShape.getCPtr(src), src);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape removeShape(int sid) {
    long cPtr = skiaviewJNI.MgShapes_removeShape(swigCPtr, this, sid);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public boolean bringToFront(int sid) {
    return skiaviewJNI.MgShapes_bringToFront(swigCPtr, this, sid);
  }

  public GiContext context() {
    long cPtr = skiaviewJNI.MgShapes_context(swigCPtr, this);
    return (cPtr == 0) ? null : new GiContext(cPtr, false);
  }

  public Matrix2d modelTransform() {
    return new Matrix2d(skiaviewJNI.MgShapes_modelTransform(swigCPtr, this), false);
  }

  public Box2d getZoomRectW() {
    return new Box2d(skiaviewJNI.MgShapes_getZoomRectW(swigCPtr, this), true);
  }

  public float getViewScale() {
    return skiaviewJNI.MgShapes_getViewScale(swigCPtr, this);
  }

  public void setZoomRectW(Box2d rectW, float viewScale) {
    skiaviewJNI.MgShapes_setZoomRectW(swigCPtr, this, Box2d.getCPtr(rectW), rectW, viewScale);
  }

  public MgLockRW getLockData() {
    long cPtr = skiaviewJNI.MgShapes_getLockData(swigCPtr, this);
    return (cPtr == 0) ? null : new MgLockRW(cPtr, false);
  }

}
