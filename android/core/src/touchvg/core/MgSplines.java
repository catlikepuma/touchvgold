/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class MgSplines extends MgBaseLines {
  private long swigCPtr;

  protected MgSplines(long cPtr, boolean cMemoryOwn) {
    super(touchvgJNI.MgSplines_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgSplines obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_MgSplines(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public MgSplines() {
    this(touchvgJNI.new_MgSplines(), true);
  }

  public static MgSplines create() {
    long cPtr = touchvgJNI.MgSplines_create();
    return (cPtr == 0) ? null : new MgSplines(cPtr, false);
  }

  public static int Type() {
    return touchvgJNI.MgSplines_Type();
  }

  public String getTypeName() {
    return touchvgJNI.MgSplines_getTypeName(swigCPtr, this);
  }

  public MgObject clone() {
    long cPtr = touchvgJNI.MgSplines_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new MgObject(cPtr, false);
  }

  public void copy(MgObject src) {
    touchvgJNI.MgSplines_copy(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public void release() {
    touchvgJNI.MgSplines_release(swigCPtr, this);
  }

  public boolean equals(MgObject src) {
    return touchvgJNI.MgSplines_equals(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public int getType() {
    return touchvgJNI.MgSplines_getType(swigCPtr, this);
  }

  public boolean isKindOf(int type) {
    return touchvgJNI.MgSplines_isKindOf(swigCPtr, this, type);
  }

  public Box2d getExtent() {
    return new Box2d(touchvgJNI.MgSplines_getExtent(swigCPtr, this), true);
  }

  public void update() {
    touchvgJNI.MgSplines_update(swigCPtr, this);
  }

  public void transform(Matrix2d mat) {
    touchvgJNI.MgSplines_transform(swigCPtr, this, Matrix2d.getCPtr(mat), mat);
  }

  public void clear() {
    touchvgJNI.MgSplines_clear(swigCPtr, this);
  }

  public void clearCachedData() {
    touchvgJNI.MgSplines_clearCachedData(swigCPtr, this);
  }

  public int getPointCount() {
    return touchvgJNI.MgSplines_getPointCount(swigCPtr, this);
  }

  public Point2d getPoint(int index) {
    return new Point2d(touchvgJNI.MgSplines_getPoint(swigCPtr, this, index), true);
  }

  public void setPoint(int index, Point2d pt) {
    touchvgJNI.MgSplines_setPoint(swigCPtr, this, index, Point2d.getCPtr(pt), pt);
  }

  public boolean isClosed() {
    return touchvgJNI.MgSplines_isClosed(swigCPtr, this);
  }

  public boolean hitTestBox(Box2d rect) {
    return touchvgJNI.MgSplines_hitTestBox(swigCPtr, this, Box2d.getCPtr(rect), rect);
  }

  public boolean draw(int mode, GiGraphics gs, GiContext ctx, int segment) {
    return touchvgJNI.MgSplines_draw__SWIG_0(swigCPtr, this, mode, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx, segment);
  }

  public boolean draw(int mode, GiGraphics gs, GiContext ctx) {
    return touchvgJNI.MgSplines_draw__SWIG_1(swigCPtr, this, mode, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx);
  }

  public boolean save(MgStorage s) {
    return touchvgJNI.MgSplines_save(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public boolean load(MgShapeFactory factory, MgStorage s) {
    return touchvgJNI.MgSplines_load(swigCPtr, this, MgShapeFactory.getCPtr(factory), factory, MgStorage.getCPtr(s), s);
  }

  public int getHandleCount() {
    return touchvgJNI.MgSplines_getHandleCount(swigCPtr, this);
  }

  public Point2d getHandlePoint(int index) {
    return new Point2d(touchvgJNI.MgSplines_getHandlePoint(swigCPtr, this, index), true);
  }

  public boolean setHandlePoint(int index, Point2d pt, float tol) {
    return touchvgJNI.MgSplines_setHandlePoint(swigCPtr, this, index, Point2d.getCPtr(pt), pt, tol);
  }

  public boolean isHandleFixed(int index) {
    return touchvgJNI.MgSplines_isHandleFixed(swigCPtr, this, index);
  }

  public int getHandleType(int index) {
    return touchvgJNI.MgSplines_getHandleType(swigCPtr, this, index);
  }

  public boolean offset(Vector2d vec, int segment) {
    return touchvgJNI.MgSplines_offset(swigCPtr, this, Vector2d.getCPtr(vec), vec, segment);
  }

  public void smooth(float tol) {
    touchvgJNI.MgSplines_smooth(swigCPtr, this, tol);
  }

}
