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

public class MgShape : MgObject {
  private HandleRef swigCPtr;

  internal MgShape(IntPtr cPtr, bool cMemoryOwn) : base(touchvgPINVOKE.MgShape_SWIGUpcast(cPtr), cMemoryOwn) {
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(MgShape obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  public override void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          throw new MethodAccessException("C++ destructor does not have public access");
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
      base.Dispose();
    }
  }

  public static int Type() {
    int ret = touchvgPINVOKE.MgShape_Type();
    return ret;
  }

  public MgShape cloneShape() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_cloneShape(swigCPtr);
    MgShape ret = (cPtr == IntPtr.Zero) ? null : new MgShape(cPtr, false);
    return ret;
  }

  public virtual GiContext context() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_context(swigCPtr);
    GiContext ret = (cPtr == IntPtr.Zero) ? null : new GiContext(cPtr, false);
    return ret;
  }

  public virtual GiContext contextc() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_contextc(swigCPtr);
    GiContext ret = (cPtr == IntPtr.Zero) ? null : new GiContext(cPtr, false);
    return ret;
  }

  public virtual MgBaseShape shape() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_shape(swigCPtr);
    MgBaseShape ret = (cPtr == IntPtr.Zero) ? null : new MgBaseShape(cPtr, false);
    return ret;
  }

  public virtual MgBaseShape shapec() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_shapec(swigCPtr);
    MgBaseShape ret = (cPtr == IntPtr.Zero) ? null : new MgBaseShape(cPtr, false);
    return ret;
  }

  public virtual bool hasFillColor() {
    bool ret = touchvgPINVOKE.MgShape_hasFillColor(swigCPtr);
    return ret;
  }

  public virtual bool draw(int mode, GiGraphics gs, GiContext ctx, int segment) {
    bool ret = touchvgPINVOKE.MgShape_draw__SWIG_0(swigCPtr, mode, GiGraphics.getCPtr(gs), GiContext.getCPtr(ctx), segment);
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public virtual bool draw(int mode, GiGraphics gs, GiContext ctx) {
    bool ret = touchvgPINVOKE.MgShape_draw__SWIG_1(swigCPtr, mode, GiGraphics.getCPtr(gs), GiContext.getCPtr(ctx));
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public virtual bool draw(int mode, GiGraphics gs) {
    bool ret = touchvgPINVOKE.MgShape_draw__SWIG_2(swigCPtr, mode, GiGraphics.getCPtr(gs));
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public virtual bool save(MgStorage s) {
    bool ret = touchvgPINVOKE.MgShape_save(swigCPtr, MgStorage.getCPtr(s));
    return ret;
  }

  public virtual bool load(MgShapeFactory factory, MgStorage s) {
    bool ret = touchvgPINVOKE.MgShape_load(swigCPtr, MgShapeFactory.getCPtr(factory), MgStorage.getCPtr(s));
    return ret;
  }

  public virtual int getID() {
    int ret = touchvgPINVOKE.MgShape_getID(swigCPtr);
    return ret;
  }

  public virtual MgShapes getParent() {
    IntPtr cPtr = touchvgPINVOKE.MgShape_getParent(swigCPtr);
    MgShapes ret = (cPtr == IntPtr.Zero) ? null : new MgShapes(cPtr, false);
    return ret;
  }

  public virtual void setParent(MgShapes p, int sid) {
    touchvgPINVOKE.MgShape_setParent(swigCPtr, MgShapes.getCPtr(p), sid);
  }

  public virtual int getTag() {
    int ret = touchvgPINVOKE.MgShape_getTag(swigCPtr);
    return ret;
  }

  public virtual void setTag(int tag) {
    touchvgPINVOKE.MgShape_setTag(swigCPtr, tag);
  }

  public override void copy(MgObject src) {
    touchvgPINVOKE.MgShape_copy(swigCPtr, MgObject.getCPtr(src));
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
  }

  public override bool equals(MgObject src) {
    bool ret = touchvgPINVOKE.MgShape_equals(swigCPtr, MgObject.getCPtr(src));
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public override bool isKindOf(int type) {
    bool ret = touchvgPINVOKE.MgShape_isKindOf(swigCPtr, type);
    return ret;
  }

}

}
