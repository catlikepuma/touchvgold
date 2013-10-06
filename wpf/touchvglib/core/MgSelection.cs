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

public class MgSelection : IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal MgSelection(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(MgSelection obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~MgSelection() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          touchvgPINVOKE.delete_MgSelection(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

  public virtual MgSelState getSelectState(MgView view) {
    MgSelState ret = (MgSelState)touchvgPINVOKE.MgSelection_getSelectState(swigCPtr, MgView.getCPtr(view));
    return ret;
  }

  public virtual int getSelectType(MgView view) {
    int ret = touchvgPINVOKE.MgSelection_getSelectType(swigCPtr, MgView.getCPtr(view));
    return ret;
  }

  public virtual bool selectAll(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_selectAll(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool deleteSelection(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_deleteSelection(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool cloneSelection(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_cloneSelection(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool groupSelection(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_groupSelection(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool ungroupSelection(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_ungroupSelection(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual void resetSelection(MgMotion sender) {
    touchvgPINVOKE.MgSelection_resetSelection(swigCPtr, MgMotion.getCPtr(sender));
  }

  public virtual bool addSelection(MgMotion sender, int shapeID) {
    bool ret = touchvgPINVOKE.MgSelection_addSelection(swigCPtr, MgMotion.getCPtr(sender), shapeID);
    return ret;
  }

  public virtual bool deleteVertext(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_deleteVertext(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool insertVertext(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_insertVertext(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool switchClosed(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_switchClosed(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual bool isFixedLength(MgView view) {
    bool ret = touchvgPINVOKE.MgSelection_isFixedLength(swigCPtr, MgView.getCPtr(view));
    return ret;
  }

  public virtual bool setFixedLength(MgMotion sender, bool arg1) {
    bool ret = touchvgPINVOKE.MgSelection_setFixedLength(swigCPtr, MgMotion.getCPtr(sender), arg1);
    return ret;
  }

  public virtual bool isLocked(MgView view) {
    bool ret = touchvgPINVOKE.MgSelection_isLocked(swigCPtr, MgView.getCPtr(view));
    return ret;
  }

  public virtual bool setLocked(MgMotion sender, bool locked) {
    bool ret = touchvgPINVOKE.MgSelection_setLocked(swigCPtr, MgMotion.getCPtr(sender), locked);
    return ret;
  }

  public virtual bool isEditMode(MgView view) {
    bool ret = touchvgPINVOKE.MgSelection_isEditMode(swigCPtr, MgView.getCPtr(view));
    return ret;
  }

  public virtual bool setEditMode(MgMotion sender, bool editMode) {
    bool ret = touchvgPINVOKE.MgSelection_setEditMode(swigCPtr, MgMotion.getCPtr(sender), editMode);
    return ret;
  }

  public virtual bool overturnPolygon(MgMotion sender) {
    bool ret = touchvgPINVOKE.MgSelection_overturnPolygon(swigCPtr, MgMotion.getCPtr(sender));
    return ret;
  }

  public virtual Box2d getBoundingBox(MgMotion sender) {
    Box2d ret = new Box2d(touchvgPINVOKE.MgSelection_getBoundingBox(swigCPtr, MgMotion.getCPtr(sender)), true);
    return ret;
  }

  public virtual bool isSelectedByType(MgView view, int type) {
    bool ret = touchvgPINVOKE.MgSelection_isSelectedByType(swigCPtr, MgView.getCPtr(view), type);
    return ret;
  }

}

}
