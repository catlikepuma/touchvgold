/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class MgBaseShape extends MgObject {
  private long swigCPtr;

  protected MgBaseShape(long cPtr, boolean cMemoryOwn) {
    super(skiaviewJNI.MgBaseShape_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgBaseShape obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static int Type() {
    return skiaviewJNI.MgBaseShape_Type();
  }

  public MgBaseShape cloneShape() {
    long cPtr = skiaviewJNI.MgBaseShape_cloneShape(swigCPtr, this);
    return (cPtr == 0) ? null : new MgBaseShape(cPtr, false);
  }

  public void setOwner(MgShape arg0) {
    skiaviewJNI.MgBaseShape_setOwner(swigCPtr, this, MgShape.getCPtr(arg0), arg0);
  }

  public Box2d getExtent() {
    return new Box2d(skiaviewJNI.MgBaseShape_getExtent(swigCPtr, this), true);
  }

  public void update() {
    skiaviewJNI.MgBaseShape_update(swigCPtr, this);
  }

  public void transform(Matrix2d mat) {
    skiaviewJNI.MgBaseShape_transform(swigCPtr, this, Matrix2d.getCPtr(mat), mat);
  }

  public void clear() {
    skiaviewJNI.MgBaseShape_clear(swigCPtr, this);
  }

  public int getPointCount() {
    return skiaviewJNI.MgBaseShape_getPointCount(swigCPtr, this);
  }

  public Point2d getPoint(int index) {
    return new Point2d(skiaviewJNI.MgBaseShape_getPoint(swigCPtr, this, index), true);
  }

  public void setPoint(int index, Point2d pt) {
    skiaviewJNI.MgBaseShape_setPoint(swigCPtr, this, index, Point2d.getCPtr(pt), pt);
  }

  public boolean isClosed() {
    return skiaviewJNI.MgBaseShape_isClosed(swigCPtr, this);
  }

  public boolean isCurve() {
    return skiaviewJNI.MgBaseShape_isCurve(swigCPtr, this);
  }

  public float hitTest2(Point2d pt, float tol, Point2d nearpt) {
    return skiaviewJNI.MgBaseShape_hitTest2(swigCPtr, this, Point2d.getCPtr(pt), pt, tol, Point2d.getCPtr(nearpt), nearpt);
  }

  public boolean hitTestBox(Box2d rect) {
    return skiaviewJNI.MgBaseShape_hitTestBox(swigCPtr, this, Box2d.getCPtr(rect), rect);
  }

  public boolean draw(int mode, GiGraphics gs, GiContext ctx) {
    return skiaviewJNI.MgBaseShape_draw(swigCPtr, this, mode, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx);
  }

  public boolean save(MgStorage s) {
    return skiaviewJNI.MgBaseShape_save(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public boolean load(MgStorage s) {
    return skiaviewJNI.MgBaseShape_load(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public int getHandleCount() {
    return skiaviewJNI.MgBaseShape_getHandleCount(swigCPtr, this);
  }

  public Point2d getHandlePoint(int index) {
    return new Point2d(skiaviewJNI.MgBaseShape_getHandlePoint(swigCPtr, this, index), true);
  }

  public boolean setHandlePoint(int index, Point2d pt, float tol) {
    return skiaviewJNI.MgBaseShape_setHandlePoint(swigCPtr, this, index, Point2d.getCPtr(pt), pt, tol);
  }

  public boolean isHandleFixed(int index) {
    return skiaviewJNI.MgBaseShape_isHandleFixed(swigCPtr, this, index);
  }

  public boolean offset(Vector2d vec, int segment) {
    return skiaviewJNI.MgBaseShape_offset(swigCPtr, this, Vector2d.getCPtr(vec), vec, segment);
  }

  public boolean getFlag(MgShapeBit bit) {
    return skiaviewJNI.MgBaseShape_getFlag(swigCPtr, this, bit.swigValue());
  }

  public void setFlag(MgShapeBit bit, boolean on) {
    skiaviewJNI.MgBaseShape_setFlag(swigCPtr, this, bit.swigValue(), on);
  }

}
