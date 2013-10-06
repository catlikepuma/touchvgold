/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.core;

public class CmdObserver {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CmdObserver(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CmdObserver obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_CmdObserver(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void onDocLoaded(MgMotion sender) {
    touchvgJNI.CmdObserver_onDocLoaded(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public void onEnterSelectCommand(MgMotion sender) {
    touchvgJNI.CmdObserver_onEnterSelectCommand(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public void onUnloadCommands(MgCmdManager sender) {
    touchvgJNI.CmdObserver_onUnloadCommands(swigCPtr, this, MgCmdManager.getCPtr(sender), sender);
  }

  public boolean selectActionsNeedHided(MgMotion sender) {
    return touchvgJNI.CmdObserver_selectActionsNeedHided(swigCPtr, this, MgMotion.getCPtr(sender), sender);
  }

  public boolean doAction(MgMotion sender, int action) {
    return touchvgJNI.CmdObserver_doAction(swigCPtr, this, MgMotion.getCPtr(sender), sender, action);
  }

  public boolean doEndAction(MgMotion sender, int action) {
    return touchvgJNI.CmdObserver_doEndAction(swigCPtr, this, MgMotion.getCPtr(sender), sender, action);
  }

  public void drawInShapeCommand(MgMotion sender, MgCommand cmd, GiGraphics gs) {
    touchvgJNI.CmdObserver_drawInShapeCommand(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgCommand.getCPtr(cmd), cmd, GiGraphics.getCPtr(gs), gs);
  }

  public void drawInSelectCommand(MgMotion sender, MgShape sp, int handleIndex, GiGraphics gs) {
    touchvgJNI.CmdObserver_drawInSelectCommand(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp, handleIndex, GiGraphics.getCPtr(gs), gs);
  }

  public boolean onShapeWillAdded(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeWillAdded(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public void onShapeAdded(MgMotion sender, MgShape sp) {
    touchvgJNI.CmdObserver_onShapeAdded(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public boolean onShapeWillDeleted(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeWillDeleted(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public void onShapeDeleted(MgMotion sender, MgShape sp) {
    touchvgJNI.CmdObserver_onShapeDeleted(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public boolean onShapeCanRotated(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeCanRotated(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public boolean onShapeCanTransform(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeCanTransform(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public boolean onShapeCanUnlock(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeCanUnlock(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public boolean onShapeCanUngroup(MgMotion sender, MgShape sp) {
    return touchvgJNI.CmdObserver_onShapeCanUngroup(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp);
  }

  public void onShapeMoved(MgMotion sender, MgShape sp, int segment) {
    touchvgJNI.CmdObserver_onShapeMoved(swigCPtr, this, MgMotion.getCPtr(sender), sender, MgShape.getCPtr(sp), sp, segment);
  }

  public MgBaseShape createShape(MgMotion sender, int type) {
    long cPtr = touchvgJNI.CmdObserver_createShape(swigCPtr, this, MgMotion.getCPtr(sender), sender, type);
    return (cPtr == 0) ? null : new MgBaseShape(cPtr, false);
  }

}
