/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class MgObject {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MgObject(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgObject obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_MgObject(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public MgObject clone() {
    long cPtr = skiaviewJNI.MgObject_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new MgObject(cPtr, false);
  }

  public void copy(MgObject src) {
    skiaviewJNI.MgObject_copy(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public void release() {
    skiaviewJNI.MgObject_release(swigCPtr, this);
  }

  public boolean equals(MgObject src) {
    return skiaviewJNI.MgObject_equals(swigCPtr, this, MgObject.getCPtr(src), src);
  }

  public int getType() {
    return skiaviewJNI.MgObject_getType(swigCPtr, this);
  }

  public boolean isKindOf(int type) {
    return skiaviewJNI.MgObject_isKindOf(swigCPtr, this, type);
  }

}