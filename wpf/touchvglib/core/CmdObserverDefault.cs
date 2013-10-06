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

public class CmdObserverDefault : CmdObserver {
  private HandleRef swigCPtr;

  internal CmdObserverDefault(IntPtr cPtr, bool cMemoryOwn) : base(touchvgPINVOKE.CmdObserverDefault_SWIGUpcast(cPtr), cMemoryOwn) {
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(CmdObserverDefault obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~CmdObserverDefault() {
    Dispose();
  }

  public override void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          touchvgPINVOKE.delete_CmdObserverDefault(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
      base.Dispose();
    }
  }

  public CmdObserverDefault() : this(touchvgPINVOKE.new_CmdObserverDefault(), true) {
    SwigDirectorConnect();
  }

  public override void onDocLoaded(MgMotion sender) {
    if (SwigDerivedClassHasMethod("onDocLoaded", swigMethodTypes0)) touchvgPINVOKE.CmdObserverDefault_onDocLoadedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender)); else touchvgPINVOKE.CmdObserverDefault_onDocLoaded(swigCPtr, MgMotion.getCPtr(sender));
  }

  public override void onEnterSelectCommand(MgMotion sender) {
    if (SwigDerivedClassHasMethod("onEnterSelectCommand", swigMethodTypes1)) touchvgPINVOKE.CmdObserverDefault_onEnterSelectCommandSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender)); else touchvgPINVOKE.CmdObserverDefault_onEnterSelectCommand(swigCPtr, MgMotion.getCPtr(sender));
  }

  public override void onUnloadCommands(MgCmdManager sender) {
    if (SwigDerivedClassHasMethod("onUnloadCommands", swigMethodTypes2)) touchvgPINVOKE.CmdObserverDefault_onUnloadCommandsSwigExplicitCmdObserverDefault(swigCPtr, MgCmdManager.getCPtr(sender)); else touchvgPINVOKE.CmdObserverDefault_onUnloadCommands(swigCPtr, MgCmdManager.getCPtr(sender));
  }

  public override bool selectActionsNeedHided(MgMotion sender) {
    bool ret = (SwigDerivedClassHasMethod("selectActionsNeedHided", swigMethodTypes3) ? touchvgPINVOKE.CmdObserverDefault_selectActionsNeedHidedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender)) : touchvgPINVOKE.CmdObserverDefault_selectActionsNeedHided(swigCPtr, MgMotion.getCPtr(sender)));
    return ret;
  }

  public override bool doAction(MgMotion sender, int action) {
    bool ret = (SwigDerivedClassHasMethod("doAction", swigMethodTypes4) ? touchvgPINVOKE.CmdObserverDefault_doActionSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), action) : touchvgPINVOKE.CmdObserverDefault_doAction(swigCPtr, MgMotion.getCPtr(sender), action));
    return ret;
  }

  public override bool doEndAction(MgMotion sender, int action) {
    bool ret = (SwigDerivedClassHasMethod("doEndAction", swigMethodTypes5) ? touchvgPINVOKE.CmdObserverDefault_doEndActionSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), action) : touchvgPINVOKE.CmdObserverDefault_doEndAction(swigCPtr, MgMotion.getCPtr(sender), action));
    return ret;
  }

  public override void drawInShapeCommand(MgMotion sender, MgCommand cmd, GiGraphics gs) {
    if (SwigDerivedClassHasMethod("drawInShapeCommand", swigMethodTypes6)) touchvgPINVOKE.CmdObserverDefault_drawInShapeCommandSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgCommand.getCPtr(cmd), GiGraphics.getCPtr(gs)); else touchvgPINVOKE.CmdObserverDefault_drawInShapeCommand(swigCPtr, MgMotion.getCPtr(sender), MgCommand.getCPtr(cmd), GiGraphics.getCPtr(gs));
  }

  public override void drawInSelectCommand(MgMotion sender, MgShape sp, int handleIndex, GiGraphics gs) {
    if (SwigDerivedClassHasMethod("drawInSelectCommand", swigMethodTypes7)) touchvgPINVOKE.CmdObserverDefault_drawInSelectCommandSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp), handleIndex, GiGraphics.getCPtr(gs)); else touchvgPINVOKE.CmdObserverDefault_drawInSelectCommand(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp), handleIndex, GiGraphics.getCPtr(gs));
  }

  public override bool onShapeWillAdded(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeWillAdded", swigMethodTypes8) ? touchvgPINVOKE.CmdObserverDefault_onShapeWillAddedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeWillAdded(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override void onShapeAdded(MgMotion sender, MgShape sp) {
    if (SwigDerivedClassHasMethod("onShapeAdded", swigMethodTypes9)) touchvgPINVOKE.CmdObserverDefault_onShapeAddedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)); else touchvgPINVOKE.CmdObserverDefault_onShapeAdded(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp));
  }

  public override bool onShapeWillDeleted(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeWillDeleted", swigMethodTypes10) ? touchvgPINVOKE.CmdObserverDefault_onShapeWillDeletedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeWillDeleted(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override void onShapeDeleted(MgMotion sender, MgShape sp) {
    if (SwigDerivedClassHasMethod("onShapeDeleted", swigMethodTypes11)) touchvgPINVOKE.CmdObserverDefault_onShapeDeletedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)); else touchvgPINVOKE.CmdObserverDefault_onShapeDeleted(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp));
  }

  public override bool onShapeCanRotated(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeCanRotated", swigMethodTypes12) ? touchvgPINVOKE.CmdObserverDefault_onShapeCanRotatedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeCanRotated(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override bool onShapeCanTransform(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeCanTransform", swigMethodTypes13) ? touchvgPINVOKE.CmdObserverDefault_onShapeCanTransformSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeCanTransform(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override bool onShapeCanUnlock(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeCanUnlock", swigMethodTypes14) ? touchvgPINVOKE.CmdObserverDefault_onShapeCanUnlockSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeCanUnlock(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override bool onShapeCanUngroup(MgMotion sender, MgShape sp) {
    bool ret = (SwigDerivedClassHasMethod("onShapeCanUngroup", swigMethodTypes15) ? touchvgPINVOKE.CmdObserverDefault_onShapeCanUngroupSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)) : touchvgPINVOKE.CmdObserverDefault_onShapeCanUngroup(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp)));
    return ret;
  }

  public override void onShapeMoved(MgMotion sender, MgShape sp, int segment) {
    if (SwigDerivedClassHasMethod("onShapeMoved", swigMethodTypes16)) touchvgPINVOKE.CmdObserverDefault_onShapeMovedSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp), segment); else touchvgPINVOKE.CmdObserverDefault_onShapeMoved(swigCPtr, MgMotion.getCPtr(sender), MgShape.getCPtr(sp), segment);
  }

  public override MgBaseShape createShape(MgMotion sender, int type) {
    IntPtr cPtr = (SwigDerivedClassHasMethod("createShape", swigMethodTypes17) ? touchvgPINVOKE.CmdObserverDefault_createShapeSwigExplicitCmdObserverDefault(swigCPtr, MgMotion.getCPtr(sender), type) : touchvgPINVOKE.CmdObserverDefault_createShape(swigCPtr, MgMotion.getCPtr(sender), type));
    MgBaseShape ret = (cPtr == IntPtr.Zero) ? null : new MgBaseShape(cPtr, false);
    return ret;
  }

  private void SwigDirectorConnect() {
    if (SwigDerivedClassHasMethod("onDocLoaded", swigMethodTypes0))
      swigDelegate0 = new SwigDelegateCmdObserverDefault_0(SwigDirectoronDocLoaded);
    if (SwigDerivedClassHasMethod("onEnterSelectCommand", swigMethodTypes1))
      swigDelegate1 = new SwigDelegateCmdObserverDefault_1(SwigDirectoronEnterSelectCommand);
    if (SwigDerivedClassHasMethod("onUnloadCommands", swigMethodTypes2))
      swigDelegate2 = new SwigDelegateCmdObserverDefault_2(SwigDirectoronUnloadCommands);
    if (SwigDerivedClassHasMethod("selectActionsNeedHided", swigMethodTypes3))
      swigDelegate3 = new SwigDelegateCmdObserverDefault_3(SwigDirectorselectActionsNeedHided);
    if (SwigDerivedClassHasMethod("doAction", swigMethodTypes4))
      swigDelegate4 = new SwigDelegateCmdObserverDefault_4(SwigDirectordoAction);
    if (SwigDerivedClassHasMethod("doEndAction", swigMethodTypes5))
      swigDelegate5 = new SwigDelegateCmdObserverDefault_5(SwigDirectordoEndAction);
    if (SwigDerivedClassHasMethod("drawInShapeCommand", swigMethodTypes6))
      swigDelegate6 = new SwigDelegateCmdObserverDefault_6(SwigDirectordrawInShapeCommand);
    if (SwigDerivedClassHasMethod("drawInSelectCommand", swigMethodTypes7))
      swigDelegate7 = new SwigDelegateCmdObserverDefault_7(SwigDirectordrawInSelectCommand);
    if (SwigDerivedClassHasMethod("onShapeWillAdded", swigMethodTypes8))
      swigDelegate8 = new SwigDelegateCmdObserverDefault_8(SwigDirectoronShapeWillAdded);
    if (SwigDerivedClassHasMethod("onShapeAdded", swigMethodTypes9))
      swigDelegate9 = new SwigDelegateCmdObserverDefault_9(SwigDirectoronShapeAdded);
    if (SwigDerivedClassHasMethod("onShapeWillDeleted", swigMethodTypes10))
      swigDelegate10 = new SwigDelegateCmdObserverDefault_10(SwigDirectoronShapeWillDeleted);
    if (SwigDerivedClassHasMethod("onShapeDeleted", swigMethodTypes11))
      swigDelegate11 = new SwigDelegateCmdObserverDefault_11(SwigDirectoronShapeDeleted);
    if (SwigDerivedClassHasMethod("onShapeCanRotated", swigMethodTypes12))
      swigDelegate12 = new SwigDelegateCmdObserverDefault_12(SwigDirectoronShapeCanRotated);
    if (SwigDerivedClassHasMethod("onShapeCanTransform", swigMethodTypes13))
      swigDelegate13 = new SwigDelegateCmdObserverDefault_13(SwigDirectoronShapeCanTransform);
    if (SwigDerivedClassHasMethod("onShapeCanUnlock", swigMethodTypes14))
      swigDelegate14 = new SwigDelegateCmdObserverDefault_14(SwigDirectoronShapeCanUnlock);
    if (SwigDerivedClassHasMethod("onShapeCanUngroup", swigMethodTypes15))
      swigDelegate15 = new SwigDelegateCmdObserverDefault_15(SwigDirectoronShapeCanUngroup);
    if (SwigDerivedClassHasMethod("onShapeMoved", swigMethodTypes16))
      swigDelegate16 = new SwigDelegateCmdObserverDefault_16(SwigDirectoronShapeMoved);
    if (SwigDerivedClassHasMethod("createShape", swigMethodTypes17))
      swigDelegate17 = new SwigDelegateCmdObserverDefault_17(SwigDirectorcreateShape);
    touchvgPINVOKE.CmdObserverDefault_director_connect(swigCPtr, swigDelegate0, swigDelegate1, swigDelegate2, swigDelegate3, swigDelegate4, swigDelegate5, swigDelegate6, swigDelegate7, swigDelegate8, swigDelegate9, swigDelegate10, swigDelegate11, swigDelegate12, swigDelegate13, swigDelegate14, swigDelegate15, swigDelegate16, swigDelegate17);
  }

  private bool SwigDerivedClassHasMethod(string methodName, Type[] methodTypes) {
    System.Reflection.MethodInfo methodInfo = this.GetType().GetMethod(methodName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance, null, methodTypes, null);
    bool hasDerivedMethod = methodInfo.DeclaringType.IsSubclassOf(typeof(CmdObserverDefault));
    return hasDerivedMethod;
  }

  private void SwigDirectoronDocLoaded(IntPtr sender) {
    onDocLoaded((sender == IntPtr.Zero) ? null : new MgMotion(sender, false));
  }

  private void SwigDirectoronEnterSelectCommand(IntPtr sender) {
    onEnterSelectCommand((sender == IntPtr.Zero) ? null : new MgMotion(sender, false));
  }

  private void SwigDirectoronUnloadCommands(IntPtr sender) {
    onUnloadCommands((sender == IntPtr.Zero) ? null : new MgCmdManager(sender, false));
  }

  private bool SwigDirectorselectActionsNeedHided(IntPtr sender) {
    return selectActionsNeedHided((sender == IntPtr.Zero) ? null : new MgMotion(sender, false));
  }

  private bool SwigDirectordoAction(IntPtr sender, int action) {
    return doAction((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), action);
  }

  private bool SwigDirectordoEndAction(IntPtr sender, int action) {
    return doEndAction((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), action);
  }

  private void SwigDirectordrawInShapeCommand(IntPtr sender, IntPtr cmd, IntPtr gs) {
    drawInShapeCommand((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (cmd == IntPtr.Zero) ? null : new MgCommand(cmd, false), (gs == IntPtr.Zero) ? null : new GiGraphics(gs, false));
  }

  private void SwigDirectordrawInSelectCommand(IntPtr sender, IntPtr sp, int handleIndex, IntPtr gs) {
    drawInSelectCommand((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false), handleIndex, (gs == IntPtr.Zero) ? null : new GiGraphics(gs, false));
  }

  private bool SwigDirectoronShapeWillAdded(IntPtr sender, IntPtr sp) {
    return onShapeWillAdded((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private void SwigDirectoronShapeAdded(IntPtr sender, IntPtr sp) {
    onShapeAdded((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private bool SwigDirectoronShapeWillDeleted(IntPtr sender, IntPtr sp) {
    return onShapeWillDeleted((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private void SwigDirectoronShapeDeleted(IntPtr sender, IntPtr sp) {
    onShapeDeleted((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private bool SwigDirectoronShapeCanRotated(IntPtr sender, IntPtr sp) {
    return onShapeCanRotated((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private bool SwigDirectoronShapeCanTransform(IntPtr sender, IntPtr sp) {
    return onShapeCanTransform((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private bool SwigDirectoronShapeCanUnlock(IntPtr sender, IntPtr sp) {
    return onShapeCanUnlock((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private bool SwigDirectoronShapeCanUngroup(IntPtr sender, IntPtr sp) {
    return onShapeCanUngroup((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false));
  }

  private void SwigDirectoronShapeMoved(IntPtr sender, IntPtr sp, int segment) {
    onShapeMoved((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), (sp == IntPtr.Zero) ? null : new MgShape(sp, false), segment);
  }

  private IntPtr SwigDirectorcreateShape(IntPtr sender, int type) {
    return MgBaseShape.getCPtr(createShape((sender == IntPtr.Zero) ? null : new MgMotion(sender, false), type)).Handle;
  }

  public delegate void SwigDelegateCmdObserverDefault_0(IntPtr sender);
  public delegate void SwigDelegateCmdObserverDefault_1(IntPtr sender);
  public delegate void SwigDelegateCmdObserverDefault_2(IntPtr sender);
  public delegate bool SwigDelegateCmdObserverDefault_3(IntPtr sender);
  public delegate bool SwigDelegateCmdObserverDefault_4(IntPtr sender, int action);
  public delegate bool SwigDelegateCmdObserverDefault_5(IntPtr sender, int action);
  public delegate void SwigDelegateCmdObserverDefault_6(IntPtr sender, IntPtr cmd, IntPtr gs);
  public delegate void SwigDelegateCmdObserverDefault_7(IntPtr sender, IntPtr sp, int handleIndex, IntPtr gs);
  public delegate bool SwigDelegateCmdObserverDefault_8(IntPtr sender, IntPtr sp);
  public delegate void SwigDelegateCmdObserverDefault_9(IntPtr sender, IntPtr sp);
  public delegate bool SwigDelegateCmdObserverDefault_10(IntPtr sender, IntPtr sp);
  public delegate void SwigDelegateCmdObserverDefault_11(IntPtr sender, IntPtr sp);
  public delegate bool SwigDelegateCmdObserverDefault_12(IntPtr sender, IntPtr sp);
  public delegate bool SwigDelegateCmdObserverDefault_13(IntPtr sender, IntPtr sp);
  public delegate bool SwigDelegateCmdObserverDefault_14(IntPtr sender, IntPtr sp);
  public delegate bool SwigDelegateCmdObserverDefault_15(IntPtr sender, IntPtr sp);
  public delegate void SwigDelegateCmdObserverDefault_16(IntPtr sender, IntPtr sp, int segment);
  public delegate IntPtr SwigDelegateCmdObserverDefault_17(IntPtr sender, int type);

  private SwigDelegateCmdObserverDefault_0 swigDelegate0;
  private SwigDelegateCmdObserverDefault_1 swigDelegate1;
  private SwigDelegateCmdObserverDefault_2 swigDelegate2;
  private SwigDelegateCmdObserverDefault_3 swigDelegate3;
  private SwigDelegateCmdObserverDefault_4 swigDelegate4;
  private SwigDelegateCmdObserverDefault_5 swigDelegate5;
  private SwigDelegateCmdObserverDefault_6 swigDelegate6;
  private SwigDelegateCmdObserverDefault_7 swigDelegate7;
  private SwigDelegateCmdObserverDefault_8 swigDelegate8;
  private SwigDelegateCmdObserverDefault_9 swigDelegate9;
  private SwigDelegateCmdObserverDefault_10 swigDelegate10;
  private SwigDelegateCmdObserverDefault_11 swigDelegate11;
  private SwigDelegateCmdObserverDefault_12 swigDelegate12;
  private SwigDelegateCmdObserverDefault_13 swigDelegate13;
  private SwigDelegateCmdObserverDefault_14 swigDelegate14;
  private SwigDelegateCmdObserverDefault_15 swigDelegate15;
  private SwigDelegateCmdObserverDefault_16 swigDelegate16;
  private SwigDelegateCmdObserverDefault_17 swigDelegate17;

  private static Type[] swigMethodTypes0 = new Type[] { typeof(MgMotion) };
  private static Type[] swigMethodTypes1 = new Type[] { typeof(MgMotion) };
  private static Type[] swigMethodTypes2 = new Type[] { typeof(MgCmdManager) };
  private static Type[] swigMethodTypes3 = new Type[] { typeof(MgMotion) };
  private static Type[] swigMethodTypes4 = new Type[] { typeof(MgMotion), typeof(int) };
  private static Type[] swigMethodTypes5 = new Type[] { typeof(MgMotion), typeof(int) };
  private static Type[] swigMethodTypes6 = new Type[] { typeof(MgMotion), typeof(MgCommand), typeof(GiGraphics) };
  private static Type[] swigMethodTypes7 = new Type[] { typeof(MgMotion), typeof(MgShape), typeof(int), typeof(GiGraphics) };
  private static Type[] swigMethodTypes8 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes9 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes10 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes11 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes12 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes13 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes14 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes15 = new Type[] { typeof(MgMotion), typeof(MgShape) };
  private static Type[] swigMethodTypes16 = new Type[] { typeof(MgMotion), typeof(MgShape), typeof(int) };
  private static Type[] swigMethodTypes17 = new Type[] { typeof(MgMotion), typeof(int) };
}

}
