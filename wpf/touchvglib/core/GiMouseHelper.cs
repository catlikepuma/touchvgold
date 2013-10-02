/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace touchvg.core {

using System;
using System.Runtime.InteropServices;

public class GiMouseHelper : IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GiMouseHelper(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GiMouseHelper obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GiMouseHelper() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          touchvgPINVOKE.delete_GiMouseHelper(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

  public GiMouseHelper(GiView view, GiCoreView coreView) : this(touchvgPINVOKE.new_GiMouseHelper(GiView.getCPtr(view), GiCoreView.getCPtr(coreView)), true) {
  }

  public bool onLButtonDown(float x, float y, bool ctrl, bool shift) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onLButtonDown(swigCPtr, x, y, ctrl, shift);
    return ret;
  }

  public bool onRButtonDown(float x, float y) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onRButtonDown(swigCPtr, x, y);
    return ret;
  }

  public bool onMouseUp(float x, float y) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onMouseUp(swigCPtr, x, y);
    return ret;
  }

  public bool onMouseMove(float x, float y, bool ldown, bool rdown) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onMouseMove(swigCPtr, x, y, ldown, rdown);
    return ret;
  }

  public bool onLButtonDblClk(float x, float y) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onLButtonDblClk(swigCPtr, x, y);
    return ret;
  }

  public bool onKeyDown(int code) {
    bool ret = touchvgPINVOKE.GiMouseHelper_onKeyDown(swigCPtr, code);
    return ret;
  }

}

}