/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class MgRect extends MgBaseRect {
  private long swigCPtr;

  protected MgRect(long cPtr, boolean cMemoryOwn) {
    super(graph2dJNI.MgRect_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgRect obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        graph2dJNI.delete_MgRect(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public MgRect() {
    this(graph2dJNI.new_MgRect(), true);
  }

  public static MgRect create() {
    long cPtr = graph2dJNI.MgRect_create();
    return (cPtr == 0) ? null : new MgRect(cPtr, false);
  }

  public static int Type() {
    return graph2dJNI.MgRect_Type();
  }

}