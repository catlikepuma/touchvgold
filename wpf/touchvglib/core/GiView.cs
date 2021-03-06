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

public class GiView : IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GiView(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GiView obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GiView() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          touchvgPINVOKE.delete_GiView(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

  public virtual void regenAll() {
    touchvgPINVOKE.GiView_regenAll(swigCPtr);
  }

  public virtual void regenAppend() {
    touchvgPINVOKE.GiView_regenAppend(swigCPtr);
  }

  public virtual void redraw() {
    touchvgPINVOKE.GiView_redraw(swigCPtr);
  }

  public virtual bool useFinger() {
    bool ret = (SwigDerivedClassHasMethod("useFinger", swigMethodTypes3) ? touchvgPINVOKE.GiView_useFingerSwigExplicitGiView(swigCPtr) : touchvgPINVOKE.GiView_useFinger(swigCPtr));
    return ret;
  }

  public virtual bool isContextActionsVisible() {
    bool ret = (SwigDerivedClassHasMethod("isContextActionsVisible", swigMethodTypes4) ? touchvgPINVOKE.GiView_isContextActionsVisibleSwigExplicitGiView(swigCPtr) : touchvgPINVOKE.GiView_isContextActionsVisible(swigCPtr));
    return ret;
  }

  public virtual bool showContextActions(Ints actions, Floats buttonXY, float x, float y, float w, float h) {
    bool ret = (SwigDerivedClassHasMethod("showContextActions", swigMethodTypes5) ? touchvgPINVOKE.GiView_showContextActionsSwigExplicitGiView(swigCPtr, Ints.getCPtr(actions), Floats.getCPtr(buttonXY), x, y, w, h) : touchvgPINVOKE.GiView_showContextActions(swigCPtr, Ints.getCPtr(actions), Floats.getCPtr(buttonXY), x, y, w, h));
    if (touchvgPINVOKE.SWIGPendingException.Pending) throw touchvgPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public virtual void commandChanged() {
    if (SwigDerivedClassHasMethod("commandChanged", swigMethodTypes6)) touchvgPINVOKE.GiView_commandChangedSwigExplicitGiView(swigCPtr); else touchvgPINVOKE.GiView_commandChanged(swigCPtr);
  }

  public virtual void selectionChanged() {
    if (SwigDerivedClassHasMethod("selectionChanged", swigMethodTypes7)) touchvgPINVOKE.GiView_selectionChangedSwigExplicitGiView(swigCPtr); else touchvgPINVOKE.GiView_selectionChanged(swigCPtr);
  }

  public virtual void contentChanged() {
    if (SwigDerivedClassHasMethod("contentChanged", swigMethodTypes8)) touchvgPINVOKE.GiView_contentChangedSwigExplicitGiView(swigCPtr); else touchvgPINVOKE.GiView_contentChanged(swigCPtr);
  }

  public GiView() : this(touchvgPINVOKE.new_GiView(), true) {
    SwigDirectorConnect();
  }

  private void SwigDirectorConnect() {
    if (SwigDerivedClassHasMethod("regenAll", swigMethodTypes0))
      swigDelegate0 = new SwigDelegateGiView_0(SwigDirectorregenAll);
    if (SwigDerivedClassHasMethod("regenAppend", swigMethodTypes1))
      swigDelegate1 = new SwigDelegateGiView_1(SwigDirectorregenAppend);
    if (SwigDerivedClassHasMethod("redraw", swigMethodTypes2))
      swigDelegate2 = new SwigDelegateGiView_2(SwigDirectorredraw);
    if (SwigDerivedClassHasMethod("useFinger", swigMethodTypes3))
      swigDelegate3 = new SwigDelegateGiView_3(SwigDirectoruseFinger);
    if (SwigDerivedClassHasMethod("isContextActionsVisible", swigMethodTypes4))
      swigDelegate4 = new SwigDelegateGiView_4(SwigDirectorisContextActionsVisible);
    if (SwigDerivedClassHasMethod("showContextActions", swigMethodTypes5))
      swigDelegate5 = new SwigDelegateGiView_5(SwigDirectorshowContextActions);
    if (SwigDerivedClassHasMethod("commandChanged", swigMethodTypes6))
      swigDelegate6 = new SwigDelegateGiView_6(SwigDirectorcommandChanged);
    if (SwigDerivedClassHasMethod("selectionChanged", swigMethodTypes7))
      swigDelegate7 = new SwigDelegateGiView_7(SwigDirectorselectionChanged);
    if (SwigDerivedClassHasMethod("contentChanged", swigMethodTypes8))
      swigDelegate8 = new SwigDelegateGiView_8(SwigDirectorcontentChanged);
    touchvgPINVOKE.GiView_director_connect(swigCPtr, swigDelegate0, swigDelegate1, swigDelegate2, swigDelegate3, swigDelegate4, swigDelegate5, swigDelegate6, swigDelegate7, swigDelegate8);
  }

  private bool SwigDerivedClassHasMethod(string methodName, Type[] methodTypes) {
    System.Reflection.MethodInfo methodInfo = this.GetType().GetMethod(methodName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance, null, methodTypes, null);
    bool hasDerivedMethod = methodInfo.DeclaringType.IsSubclassOf(typeof(GiView));
    return hasDerivedMethod;
  }

  private void SwigDirectorregenAll() {
    regenAll();
  }

  private void SwigDirectorregenAppend() {
    regenAppend();
  }

  private void SwigDirectorredraw() {
    redraw();
  }

  private bool SwigDirectoruseFinger() {
    return useFinger();
  }

  private bool SwigDirectorisContextActionsVisible() {
    return isContextActionsVisible();
  }

  private bool SwigDirectorshowContextActions(IntPtr actions, IntPtr buttonXY, float x, float y, float w, float h) {
    return showContextActions(new Ints(actions, false), new Floats(buttonXY, false), x, y, w, h);
  }

  private void SwigDirectorcommandChanged() {
    commandChanged();
  }

  private void SwigDirectorselectionChanged() {
    selectionChanged();
  }

  private void SwigDirectorcontentChanged() {
    contentChanged();
  }

  public delegate void SwigDelegateGiView_0();
  public delegate void SwigDelegateGiView_1();
  public delegate void SwigDelegateGiView_2();
  public delegate bool SwigDelegateGiView_3();
  public delegate bool SwigDelegateGiView_4();
  public delegate bool SwigDelegateGiView_5(IntPtr actions, IntPtr buttonXY, float x, float y, float w, float h);
  public delegate void SwigDelegateGiView_6();
  public delegate void SwigDelegateGiView_7();
  public delegate void SwigDelegateGiView_8();

  private SwigDelegateGiView_0 swigDelegate0;
  private SwigDelegateGiView_1 swigDelegate1;
  private SwigDelegateGiView_2 swigDelegate2;
  private SwigDelegateGiView_3 swigDelegate3;
  private SwigDelegateGiView_4 swigDelegate4;
  private SwigDelegateGiView_5 swigDelegate5;
  private SwigDelegateGiView_6 swigDelegate6;
  private SwigDelegateGiView_7 swigDelegate7;
  private SwigDelegateGiView_8 swigDelegate8;

  private static Type[] swigMethodTypes0 = new Type[] {  };
  private static Type[] swigMethodTypes1 = new Type[] {  };
  private static Type[] swigMethodTypes2 = new Type[] {  };
  private static Type[] swigMethodTypes3 = new Type[] {  };
  private static Type[] swigMethodTypes4 = new Type[] {  };
  private static Type[] swigMethodTypes5 = new Type[] { typeof(Ints), typeof(Floats), typeof(float), typeof(float), typeof(float), typeof(float) };
  private static Type[] swigMethodTypes6 = new Type[] {  };
  private static Type[] swigMethodTypes7 = new Type[] {  };
  private static Type[] swigMethodTypes8 = new Type[] {  };
}

}
