/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class Tol {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Tol(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Tol obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_Tol(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static Tol gTol() {
    return new Tol(skiaviewJNI.Tol_gTol(), false);
  }

  public static Tol minTol() {
    return new Tol(skiaviewJNI.Tol_minTol(), false);
  }

  public Tol() {
    this(skiaviewJNI.new_Tol__SWIG_0(), true);
  }

  public Tol(float tolPoint, float tolVector) {
    this(skiaviewJNI.new_Tol__SWIG_1(tolPoint, tolVector), true);
  }

  public float equalPoint() {
    return skiaviewJNI.Tol_equalPoint(swigCPtr, this);
  }

  public float equalVector() {
    return skiaviewJNI.Tol_equalVector(swigCPtr, this);
  }

  public void setEqualPoint(float tol) {
    skiaviewJNI.Tol_setEqualPoint(swigCPtr, this, tol);
  }

  public void setEqualVector(float tol) {
    skiaviewJNI.Tol_setEqualVector(swigCPtr, this, tol);
  }

}