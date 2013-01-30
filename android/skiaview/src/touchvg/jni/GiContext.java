/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class GiContext {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected GiContext(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GiContext obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_GiContext(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GiContext() {
    this(skiaviewJNI.new_GiContext__SWIG_0(), true);
  }

  public GiContext(float width, GiColor color, int style, GiColor fillcr, boolean autoScale) {
    this(skiaviewJNI.new_GiContext__SWIG_1(width, GiColor.getCPtr(color), color, style, GiColor.getCPtr(fillcr), fillcr, autoScale), true);
  }

  public GiContext(float width, GiColor color, int style, GiColor fillcr) {
    this(skiaviewJNI.new_GiContext__SWIG_2(width, GiColor.getCPtr(color), color, style, GiColor.getCPtr(fillcr), fillcr), true);
  }

  public GiContext(float width, GiColor color, int style) {
    this(skiaviewJNI.new_GiContext__SWIG_3(width, GiColor.getCPtr(color), color, style), true);
  }

  public GiContext(float width, GiColor color) {
    this(skiaviewJNI.new_GiContext__SWIG_4(width, GiColor.getCPtr(color), color), true);
  }

  public GiContext(float width) {
    this(skiaviewJNI.new_GiContext__SWIG_5(width), true);
  }

  public GiContext(GiContext src) {
    this(skiaviewJNI.new_GiContext__SWIG_6(GiContext.getCPtr(src), src), true);
  }

  public GiContext copy(GiContext src, int mask) {
    return new GiContext(skiaviewJNI.GiContext_copy__SWIG_0(swigCPtr, this, GiContext.getCPtr(src), src, mask), false);
  }

  public GiContext copy(GiContext src) {
    return new GiContext(skiaviewJNI.GiContext_copy__SWIG_1(swigCPtr, this, GiContext.getCPtr(src), src), false);
  }

  public boolean equals(GiContext src) {
    return skiaviewJNI.GiContext_equals(swigCPtr, this, GiContext.getCPtr(src), src);
  }

  public int getLineStyle() {
    return skiaviewJNI.GiContext_getLineStyle(swigCPtr, this);
  }

  public void setLineStyle(int style) {
    skiaviewJNI.GiContext_setLineStyle(swigCPtr, this, style);
  }

  public float getLineWidth() {
    return skiaviewJNI.GiContext_getLineWidth(swigCPtr, this);
  }

  public boolean isAutoScale() {
    return skiaviewJNI.GiContext_isAutoScale(swigCPtr, this);
  }

  public void setLineWidth(float width, boolean autoScale) {
    skiaviewJNI.GiContext_setLineWidth(swigCPtr, this, width, autoScale);
  }

  public boolean isNullLine() {
    return skiaviewJNI.GiContext_isNullLine(swigCPtr, this);
  }

  public void setNullLine() {
    skiaviewJNI.GiContext_setNullLine(swigCPtr, this);
  }

  public GiColor getLineColor() {
    return new GiColor(skiaviewJNI.GiContext_getLineColor(swigCPtr, this), true);
  }

  public void setLineColor(GiColor color) {
    skiaviewJNI.GiContext_setLineColor__SWIG_0(swigCPtr, this, GiColor.getCPtr(color), color);
  }

  public void setLineColor(int r, int g, int b) {
    skiaviewJNI.GiContext_setLineColor__SWIG_1(swigCPtr, this, r, g, b);
  }

  public int getLineARGB() {
    return skiaviewJNI.GiContext_getLineARGB(swigCPtr, this);
  }

  public void setLineARGB(int argb) {
    skiaviewJNI.GiContext_setLineARGB(swigCPtr, this, argb);
  }

  public int getLineAlpha() {
    return skiaviewJNI.GiContext_getLineAlpha(swigCPtr, this);
  }

  public void setLineAlpha(int alpha) {
    skiaviewJNI.GiContext_setLineAlpha(swigCPtr, this, alpha);
  }

  public boolean hasFillColor() {
    return skiaviewJNI.GiContext_hasFillColor(swigCPtr, this);
  }

  public void setNoFillColor() {
    skiaviewJNI.GiContext_setNoFillColor(swigCPtr, this);
  }

  public GiColor getFillColor() {
    return new GiColor(skiaviewJNI.GiContext_getFillColor(swigCPtr, this), true);
  }

  public void setFillColor(GiColor color) {
    skiaviewJNI.GiContext_setFillColor__SWIG_0(swigCPtr, this, GiColor.getCPtr(color), color);
  }

  public void setFillColor(int r, int g, int b) {
    skiaviewJNI.GiContext_setFillColor__SWIG_1(swigCPtr, this, r, g, b);
  }

  public int getFillARGB() {
    return skiaviewJNI.GiContext_getFillARGB(swigCPtr, this);
  }

  public void setFillARGB(int argb) {
    skiaviewJNI.GiContext_setFillARGB(swigCPtr, this, argb);
  }

  public int getFillAlpha() {
    return skiaviewJNI.GiContext_getFillAlpha(swigCPtr, this);
  }

  public void setFillAlpha(int alpha) {
    skiaviewJNI.GiContext_setFillAlpha(swigCPtr, this, alpha);
  }

  public boolean isAutoFillColor() {
    return skiaviewJNI.GiContext_isAutoFillColor(swigCPtr, this);
  }

  public void setAutoFillColor(boolean value) {
    skiaviewJNI.GiContext_setAutoFillColor(swigCPtr, this, value);
  }

  public int getType() {
    return skiaviewJNI.GiContext_getType(swigCPtr, this);
  }

}
