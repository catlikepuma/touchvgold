/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class MgLockRW {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MgLockRW(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgLockRW obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_MgLockRW(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public MgLockRW() {
    this(skiaviewJNI.new_MgLockRW(), true);
  }

  public boolean lock(boolean forWrite, int timeout) {
    return skiaviewJNI.MgLockRW_lock__SWIG_0(swigCPtr, this, forWrite, timeout);
  }

  public boolean lock(boolean forWrite) {
    return skiaviewJNI.MgLockRW_lock__SWIG_1(swigCPtr, this, forWrite);
  }

  public int unlock(boolean forWrite) {
    return skiaviewJNI.MgLockRW_unlock(swigCPtr, this, forWrite);
  }

  public boolean firstLocked() {
    return skiaviewJNI.MgLockRW_firstLocked(swigCPtr, this);
  }

  public boolean lockedForRead() {
    return skiaviewJNI.MgLockRW_lockedForRead(swigCPtr, this);
  }

  public boolean lockedForWrite() {
    return skiaviewJNI.MgLockRW_lockedForWrite(swigCPtr, this);
  }

  public int getEditFlags() {
    return skiaviewJNI.MgLockRW_getEditFlags(swigCPtr, this);
  }

  public void setEditFlags(int flags) {
    skiaviewJNI.MgLockRW_setEditFlags(swigCPtr, this, flags);
  }

}
