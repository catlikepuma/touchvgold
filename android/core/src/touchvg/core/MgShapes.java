/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class MgShapes extends MgObject {
  private long swigCPtr;

  protected MgShapes(long cPtr, boolean cMemoryOwn) {
    super(touchvgJNI.MgShapes_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgShapes obj) {
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
    return touchvgJNI.MgShapes_Type();
  }

  public MgShapes cloneShapes() {
    long cPtr = touchvgJNI.MgShapes_cloneShapes(swigCPtr, this);
    return (cPtr == 0) ? null : new MgShapes(cPtr, false);
  }

  public static MgShapes create(MgObject owner, int index) {
    long cPtr = touchvgJNI.MgShapes_create__SWIG_0(MgObject.getCPtr(owner), owner, index);
    return (cPtr == 0) ? null : new MgShapes(cPtr, false);
  }

  public static MgShapes create(MgObject owner) {
    long cPtr = touchvgJNI.MgShapes_create__SWIG_1(MgObject.getCPtr(owner), owner);
    return (cPtr == 0) ? null : new MgShapes(cPtr, false);
  }

  public static MgShapes create() {
    long cPtr = touchvgJNI.MgShapes_create__SWIG_2();
    return (cPtr == 0) ? null : new MgShapes(cPtr, false);
  }

  public MgShape addShapeByType(MgShapeFactory factory, int type) {
    long cPtr = touchvgJNI.MgShapes_addShapeByType(swigCPtr, this, MgShapeFactory.getCPtr(factory), factory, type);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public int getShapeCount() {
    return touchvgJNI.MgShapes_getShapeCount(swigCPtr, this);
  }

  public MgShape getHeadShape() {
    long cPtr = touchvgJNI.MgShapes_getHeadShape(swigCPtr, this);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape getLastShape() {
    long cPtr = touchvgJNI.MgShapes_getLastShape(swigCPtr, this);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShape(int sid) {
    long cPtr = touchvgJNI.MgShapes_findShape(swigCPtr, this, sid);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShapeByTag(int tag) {
    long cPtr = touchvgJNI.MgShapes_findShapeByTag(swigCPtr, this, tag);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape findShapeByType(int type) {
    long cPtr = touchvgJNI.MgShapes_findShapeByType(swigCPtr, this, type);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public Box2d getExtent() {
    return new Box2d(touchvgJNI.MgShapes_getExtent(swigCPtr, this), true);
  }

  public MgShape hitTest(Box2d limits, MgHitResult res) {
    long cPtr = touchvgJNI.MgShapes_hitTest(swigCPtr, this, Box2d.getCPtr(limits), limits, MgHitResult.getCPtr(res), res);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public int draw(GiGraphics gs, GiContext ctx) {
    return touchvgJNI.MgShapes_draw__SWIG_0(swigCPtr, this, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx);
  }

  public int draw(GiGraphics gs) {
    return touchvgJNI.MgShapes_draw__SWIG_1(swigCPtr, this, GiGraphics.getCPtr(gs), gs);
  }

  public int dyndraw(int mode, GiGraphics gs, GiContext ctx, int segment) {
    return touchvgJNI.MgShapes_dyndraw(swigCPtr, this, mode, GiGraphics.getCPtr(gs), gs, GiContext.getCPtr(ctx), ctx, segment);
  }

  public boolean save(MgStorage s, int startIndex) {
    return touchvgJNI.MgShapes_save__SWIG_0(swigCPtr, this, MgStorage.getCPtr(s), s, startIndex);
  }

  public boolean save(MgStorage s) {
    return touchvgJNI.MgShapes_save__SWIG_1(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public boolean load(MgShapeFactory factory, MgStorage s, boolean addOnly) {
    return touchvgJNI.MgShapes_load__SWIG_0(swigCPtr, this, MgShapeFactory.getCPtr(factory), factory, MgStorage.getCPtr(s), s, addOnly);
  }

  public boolean load(MgShapeFactory factory, MgStorage s) {
    return touchvgJNI.MgShapes_load__SWIG_1(swigCPtr, this, MgShapeFactory.getCPtr(factory), factory, MgStorage.getCPtr(s), s);
  }

  public void clear() {
    touchvgJNI.MgShapes_clear(swigCPtr, this);
  }

  public void clearCachedData() {
    touchvgJNI.MgShapes_clearCachedData(swigCPtr, this);
  }

  public void copyShapes(MgShapes src) {
    touchvgJNI.MgShapes_copyShapes(swigCPtr, this, MgShapes.getCPtr(src), src);
  }

  public MgShape addShape(MgShape src) {
    long cPtr = touchvgJNI.MgShapes_addShape(swigCPtr, this, MgShape.getCPtr(src), src);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape removeShape(int sid, boolean skipLockedShape) {
    long cPtr = touchvgJNI.MgShapes_removeShape__SWIG_0(swigCPtr, this, sid, skipLockedShape);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape removeShape(int sid) {
    long cPtr = touchvgJNI.MgShapes_removeShape__SWIG_1(swigCPtr, this, sid);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public MgShape moveTo(int sid, MgShapes dest) {
    long cPtr = touchvgJNI.MgShapes_moveTo(swigCPtr, this, sid, MgShapes.getCPtr(dest), dest);
    return (cPtr == 0) ? null : new MgShape(cPtr, false);
  }

  public void moveAllShapesTo(MgShapes dest) {
    touchvgJNI.MgShapes_moveAllShapesTo(swigCPtr, this, MgShapes.getCPtr(dest), dest);
  }

  public boolean bringToFront(int sid) {
    return touchvgJNI.MgShapes_bringToFront(swigCPtr, this, sid);
  }

  public MgObject getOwner() {
    long cPtr = touchvgJNI.MgShapes_getOwner(swigCPtr, this);
    return (cPtr == 0) ? null : new MgObject(cPtr, false);
  }

  public MgObject clone() {
    long cPtr = touchvgJNI.MgShapes_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new MgObject(cPtr, false);
  }

  public void copy(MgObject src) {
    touchvgJNI.MgShapes_copy(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public void release() {
    touchvgJNI.MgShapes_release(swigCPtr, this);
  }

  public boolean equals(MgObject src) {
    return touchvgJNI.MgShapes_equals(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public int getType() {
    return touchvgJNI.MgShapes_getType(swigCPtr, this);
  }

  public boolean isKindOf(int type) {
    return touchvgJNI.MgShapes_isKindOf(swigCPtr, this, type);
  }

}
