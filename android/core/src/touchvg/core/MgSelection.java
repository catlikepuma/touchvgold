/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class MgSelection {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MgSelection(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgSelection obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_MgSelection(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public MgSelState getSelectState(MgView view) {
    return MgSelState.swigToEnum(touchvgJNI.MgSelection_getSelectState(swigCPtr, this, MgView.getCPtr(view), view));
  }

  public int getSelectType(MgView view) {
    return touchvgJNI.MgSelection_getSelectType(swigCPtr, this, MgView.getCPtr(view), view);
  }

  public boolean selectAll(MgMotion sender) {
    return touchvgJNI.MgSelection_selectAll(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean deleteSelection(MgMotion sender) {
    return touchvgJNI.MgSelection_deleteSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean cloneSelection(MgMotion sender) {
    return touchvgJNI.MgSelection_cloneSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean groupSelection(MgMotion sender) {
    return touchvgJNI.MgSelection_groupSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean ungroupSelection(MgMotion sender) {
    return touchvgJNI.MgSelection_ungroupSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public void resetSelection(MgMotion sender) {
    touchvgJNI.MgSelection_resetSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean addSelection(MgMotion sender, int shapeID) {
    return touchvgJNI.MgSelection_addSelection(swigCPtr, this, MgMotion.getCPtr(sender), sender, shapeID);
  }

  public boolean deleteVertext(MgMotion sender) {
    return touchvgJNI.MgSelection_deleteVertext(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean insertVertext(MgMotion sender) {
    return touchvgJNI.MgSelection_insertVertext(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean switchClosed(MgMotion sender) {
    return touchvgJNI.MgSelection_switchClosed(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean isFixedLength(MgView view) {
    return touchvgJNI.MgSelection_isFixedLength(swigCPtr, this, MgView.getCPtr(view), view);
  }

  public boolean setFixedLength(MgMotion sender, boolean fixed) {
    return touchvgJNI.MgSelection_setFixedLength(swigCPtr, this, MgMotion.getCPtr(sender), sender, fixed);
  }

  public boolean isLocked(MgView view) {
    return touchvgJNI.MgSelection_isLocked(swigCPtr, this, MgView.getCPtr(view), view);
  }

  public boolean setLocked(MgMotion sender, boolean locked) {
    return touchvgJNI.MgSelection_setLocked(swigCPtr, this, MgMotion.getCPtr(sender), sender, locked);
  }

  public boolean isEditMode(MgView view) {
    return touchvgJNI.MgSelection_isEditMode(swigCPtr, this, MgView.getCPtr(view), view);
  }

  public boolean setEditMode(MgMotion sender, boolean editMode) {
    return touchvgJNI.MgSelection_setEditMode(swigCPtr, this, MgMotion.getCPtr(sender), sender, editMode);
  }

  public boolean overturnPolygon(MgMotion sender) {
    return touchvgJNI.MgSelection_overturnPolygon(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public Box2d getBoundingBox(MgMotion sender) {
    return new Box2d(touchvgJNI.MgSelection_getBoundingBox(swigCPtr, this, MgMotion.getCPtr(sender), sender), true);
  }

  public boolean isSelectedByType(MgView view, int type) {
    return touchvgJNI.MgSelection_isSelectedByType(swigCPtr, this, MgView.getCPtr(view), view, type);
  }

}
