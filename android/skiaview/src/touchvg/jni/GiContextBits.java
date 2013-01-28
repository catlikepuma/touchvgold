/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public final class GiContextBits {
  public final static GiContextBits kContextLineRGB = new GiContextBits("kContextLineRGB", skiaviewJNI.kContextLineRGB_get());
  public final static GiContextBits kContextLineAlpha = new GiContextBits("kContextLineAlpha", skiaviewJNI.kContextLineAlpha_get());
  public final static GiContextBits kContextLineColor = new GiContextBits("kContextLineColor", skiaviewJNI.kContextLineColor_get());
  public final static GiContextBits kContextLineWidth = new GiContextBits("kContextLineWidth", skiaviewJNI.kContextLineWidth_get());
  public final static GiContextBits kContextLineStyle = new GiContextBits("kContextLineStyle", skiaviewJNI.kContextLineStyle_get());
  public final static GiContextBits kContextFillRGB = new GiContextBits("kContextFillRGB", skiaviewJNI.kContextFillRGB_get());
  public final static GiContextBits kContextFillAlpha = new GiContextBits("kContextFillAlpha", skiaviewJNI.kContextFillAlpha_get());
  public final static GiContextBits kContextFillColor = new GiContextBits("kContextFillColor", skiaviewJNI.kContextFillColor_get());
  public final static GiContextBits kContextCopyAll = new GiContextBits("kContextCopyAll", skiaviewJNI.kContextCopyAll_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static GiContextBits swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + GiContextBits.class + " with value " + swigValue);
  }

  private GiContextBits(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private GiContextBits(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private GiContextBits(String swigName, GiContextBits swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static GiContextBits[] swigValues = { kContextLineRGB, kContextLineAlpha, kContextLineColor, kContextLineWidth, kContextLineStyle, kContextFillRGB, kContextFillAlpha, kContextFillColor, kContextCopyAll };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

