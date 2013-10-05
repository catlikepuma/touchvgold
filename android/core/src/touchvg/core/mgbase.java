/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class mgbase {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected mgbase(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(mgbase obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_mgbase(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static float toRange(float value, float tmin, float tmax) {
    return touchvgJNI.mgbase_toRange(value, tmin, tmax);
  }

  public static float to0_2PI(float angle) {
    return touchvgJNI.mgbase_to0_2PI(angle);
  }

  public static float toPI(float angle) {
    return touchvgJNI.mgbase_toPI(angle);
  }

  public static float deg2Rad(float deg) {
    return touchvgJNI.mgbase_deg2Rad(deg);
  }

  public static float rad2Deg(float rad) {
    return touchvgJNI.mgbase_rad2Deg(rad);
  }

  public static float dms2Deg(float angle) {
    return touchvgJNI.mgbase_dms2Deg(angle);
  }

  public static float deg2Dms(float angle) {
    return touchvgJNI.mgbase_deg2Dms(angle);
  }

  public static float getMidAngle(float fromAngle, float toAngle) {
    return touchvgJNI.mgbase_getMidAngle(fromAngle, toAngle);
  }

  public static float getDiffAngle(float fromAngle, float toAngle) {
    return touchvgJNI.mgbase_getDiffAngle(fromAngle, toAngle);
  }

  public static int getGcd(int x, int y) {
    return touchvgJNI.mgbase_getGcd(x, y);
  }

  public static float roundReal(float value, int decimal) {
    return touchvgJNI.mgbase_roundReal(value, decimal);
  }

  public mgbase() {
    this(touchvgJNI.new_mgbase(), true);
  }

}
