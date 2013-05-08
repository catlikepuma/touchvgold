/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class GiCanvasDrawing {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected GiCanvasDrawing(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GiCanvasDrawing obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        graph2dJNI.delete_GiCanvasDrawing(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void clearCachedBitmap(boolean clearAll) {
    graph2dJNI.GiCanvasDrawing_clearCachedBitmap__SWIG_0(swigCPtr, this, clearAll);
  }

  public void clearCachedBitmap() {
    graph2dJNI.GiCanvasDrawing_clearCachedBitmap__SWIG_1(swigCPtr, this);
  }

  public float getScreenDpi() {
    return graph2dJNI.GiCanvasDrawing_getScreenDpi(swigCPtr, this);
  }

  public GiColor getBkColor() {
    return new GiColor(graph2dJNI.GiCanvasDrawing_getBkColor(swigCPtr, this), true);
  }

  public GiColor setBkColor(GiColor color) {
    return new GiColor(graph2dJNI.GiCanvasDrawing_setBkColor(swigCPtr, this, GiColor.getCPtr(color), color), true);
  }

  public boolean rawLine(GiContext ctx, float x1, float y1, float x2, float y2) {
    return graph2dJNI.GiCanvasDrawing_rawLine(swigCPtr, this, GiContext.getCPtr(ctx), ctx, x1, y1, x2, y2);
  }

  public boolean rawLines(GiContext ctx, Point2d pxs, int count) {
    return graph2dJNI.GiCanvasDrawing_rawLines(swigCPtr, this, GiContext.getCPtr(ctx), ctx, Point2d.getCPtr(pxs), pxs, count);
  }

  public boolean rawBeziers(GiContext ctx, Point2d pxs, int count) {
    return graph2dJNI.GiCanvasDrawing_rawBeziers(swigCPtr, this, GiContext.getCPtr(ctx), ctx, Point2d.getCPtr(pxs), pxs, count);
  }

  public boolean rawPolygon(GiContext ctx, Point2d pxs, int count) {
    return graph2dJNI.GiCanvasDrawing_rawPolygon(swigCPtr, this, GiContext.getCPtr(ctx), ctx, Point2d.getCPtr(pxs), pxs, count);
  }

  public boolean rawRect(GiContext ctx, float x, float y, float w, float h) {
    return graph2dJNI.GiCanvasDrawing_rawRect(swigCPtr, this, GiContext.getCPtr(ctx), ctx, x, y, w, h);
  }

  public boolean rawEllipse(GiContext ctx, float x, float y, float w, float h) {
    return graph2dJNI.GiCanvasDrawing_rawEllipse(swigCPtr, this, GiContext.getCPtr(ctx), ctx, x, y, w, h);
  }

  public boolean rawBeginPath() {
    return graph2dJNI.GiCanvasDrawing_rawBeginPath(swigCPtr, this);
  }

  public boolean rawEndPath(GiContext ctx, boolean fill) {
    return graph2dJNI.GiCanvasDrawing_rawEndPath(swigCPtr, this, GiContext.getCPtr(ctx), ctx, fill);
  }

  public boolean rawMoveTo(float x, float y) {
    return graph2dJNI.GiCanvasDrawing_rawMoveTo(swigCPtr, this, x, y);
  }

  public boolean rawLineTo(float x, float y) {
    return graph2dJNI.GiCanvasDrawing_rawLineTo(swigCPtr, this, x, y);
  }

  public boolean rawBezierTo(float c1x, float c1y, float c2x, float c2y, float x, float y) {
    return graph2dJNI.GiCanvasDrawing_rawBezierTo(swigCPtr, this, c1x, c1y, c2x, c2y, x, y);
  }

  public boolean rawClosePath() {
    return graph2dJNI.GiCanvasDrawing_rawClosePath(swigCPtr, this);
  }

  public void rawTextCenter(String text, float x, float y, float h) {
    graph2dJNI.GiCanvasDrawing_rawTextCenter(swigCPtr, this, text, x, y, h);
  }

  public boolean drawImage(String name, float xc, float yc, float w, float h, float angle) {
    return graph2dJNI.GiCanvasDrawing_drawImage(swigCPtr, this, name, xc, yc, w, h, angle);
  }

}