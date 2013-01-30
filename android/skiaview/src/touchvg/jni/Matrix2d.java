/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package touchvg.jni;

public class Matrix2d extends MATRIX_2D {
  private long swigCPtr;

  protected Matrix2d(long cPtr, boolean cMemoryOwn) {
    super(skiaviewJNI.Matrix2d_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Matrix2d obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        skiaviewJNI.delete_Matrix2d(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static Matrix2d kIdentity() {
    return new Matrix2d(skiaviewJNI.Matrix2d_kIdentity(), false);
  }

  public Matrix2d() {
    this(skiaviewJNI.new_Matrix2d__SWIG_0(), true);
  }

  public Matrix2d(MATRIX_2D src) {
    this(skiaviewJNI.new_Matrix2d__SWIG_1(MATRIX_2D.getCPtr(src), src), true);
  }

  public Matrix2d(float _m11, float _m12, float _m21, float _m22, float _dx, float _dy) {
    this(skiaviewJNI.new_Matrix2d__SWIG_2(_m11, _m12, _m21, _m22, _dx, _dy), true);
  }

  public Matrix2d(Vector2d e0, Vector2d e1, Point2d origin) {
    this(skiaviewJNI.new_Matrix2d__SWIG_3(Vector2d.getCPtr(e0), e0, Vector2d.getCPtr(e1), e1, Point2d.getCPtr(origin), origin), true);
  }

  public Matrix2d preMultBy(Matrix2d leftSide) {
    return new Matrix2d(skiaviewJNI.Matrix2d_preMultBy(swigCPtr, this, Matrix2d.getCPtr(leftSide), leftSide), false);
  }

  public Matrix2d postMultBy(Matrix2d rightSide) {
    return new Matrix2d(skiaviewJNI.Matrix2d_postMultBy(swigCPtr, this, Matrix2d.getCPtr(rightSide), rightSide), false);
  }

  public Matrix2d setToProduct(Matrix2d m1, Matrix2d m2) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToProduct(swigCPtr, this, Matrix2d.getCPtr(m1), m1, Matrix2d.getCPtr(m2), m2), false);
  }

  public void TransformPoints(int count, Point2d points) {
    skiaviewJNI.Matrix2d_TransformPoints(swigCPtr, this, count, Point2d.getCPtr(points), points);
  }

  public void TransformVectors(int count, Vector2d vectors) {
    skiaviewJNI.Matrix2d_TransformVectors(swigCPtr, this, count, Vector2d.getCPtr(vectors), vectors);
  }

  public float det() {
    return skiaviewJNI.Matrix2d_det(swigCPtr, this);
  }

  public boolean invert() {
    return skiaviewJNI.Matrix2d_invert(swigCPtr, this);
  }

  public Matrix2d inverse() {
    return new Matrix2d(skiaviewJNI.Matrix2d_inverse(swigCPtr, this), true);
  }

  public boolean isInvertible() {
    return skiaviewJNI.Matrix2d_isInvertible(swigCPtr, this);
  }

  public float scale() {
    return skiaviewJNI.Matrix2d_scale(swigCPtr, this);
  }

  public float scaleX() {
    return skiaviewJNI.Matrix2d_scaleX(swigCPtr, this);
  }

  public float scaleY() {
    return skiaviewJNI.Matrix2d_scaleY(swigCPtr, this);
  }

  public float angle() {
    return skiaviewJNI.Matrix2d_angle(swigCPtr, this);
  }

  public boolean isEqualTo(Matrix2d mat, Tol tol) {
    return skiaviewJNI.Matrix2d_isEqualTo__SWIG_0(swigCPtr, this, Matrix2d.getCPtr(mat), mat, Tol.getCPtr(tol), tol);
  }

  public boolean isEqualTo(Matrix2d mat) {
    return skiaviewJNI.Matrix2d_isEqualTo__SWIG_1(swigCPtr, this, Matrix2d.getCPtr(mat), mat);
  }

  public boolean isIdentity() {
    return skiaviewJNI.Matrix2d_isIdentity(swigCPtr, this);
  }

  public boolean isOrtho() {
    return skiaviewJNI.Matrix2d_isOrtho(swigCPtr, this);
  }

  public boolean hasMirror(Vector2d reflex) {
    return skiaviewJNI.Matrix2d_hasMirror(swigCPtr, this, Vector2d.getCPtr(reflex), reflex);
  }

  public Matrix2d setCoordSystem(Vector2d e0, Vector2d e1, Point2d origin) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setCoordSystem(swigCPtr, this, Vector2d.getCPtr(e0), e0, Vector2d.getCPtr(e1), e1, Point2d.getCPtr(origin), origin), false);
  }

  public void getCoordSystem(Vector2d e0, Vector2d e1, Point2d origin) {
    skiaviewJNI.Matrix2d_getCoordSystem(swigCPtr, this, Vector2d.getCPtr(e0), e0, Vector2d.getCPtr(e1), e1, Point2d.getCPtr(origin), origin);
  }

  public static Matrix2d coordSystem(Vector2d e0, Vector2d e1, Point2d origin) {
    return new Matrix2d(skiaviewJNI.Matrix2d_coordSystem__SWIG_0(Vector2d.getCPtr(e0), e0, Vector2d.getCPtr(e1), e1, Point2d.getCPtr(origin), origin), true);
  }

  public static Matrix2d coordSystem(Point2d origin, float scaleX, float scaleY, float angle) {
    return new Matrix2d(skiaviewJNI.Matrix2d_coordSystem__SWIG_1(Point2d.getCPtr(origin), origin, scaleX, scaleY, angle), true);
  }

  public static Matrix2d coordSystem(Point2d origin, float scaleX, float scaleY) {
    return new Matrix2d(skiaviewJNI.Matrix2d_coordSystem__SWIG_2(Point2d.getCPtr(origin), origin, scaleX, scaleY), true);
  }

  public static Matrix2d coordSystem(Point2d origin, float scaleX) {
    return new Matrix2d(skiaviewJNI.Matrix2d_coordSystem__SWIG_3(Point2d.getCPtr(origin), origin, scaleX), true);
  }

  public Matrix2d setToIdentity() {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToIdentity(swigCPtr, this), false);
  }

  public Matrix2d set(float _m11, float _m12, float _m21, float _m22, float _dx, float _dy) {
    return new Matrix2d(skiaviewJNI.Matrix2d_set(swigCPtr, this, _m11, _m12, _m21, _m22, _dx, _dy), false);
  }

  public Matrix2d setToTranslation(Vector2d vec) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToTranslation(swigCPtr, this, Vector2d.getCPtr(vec), vec), false);
  }

  public Matrix2d setToRotation(float angle, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToRotation__SWIG_0(swigCPtr, this, angle, Point2d.getCPtr(center), center), false);
  }

  public Matrix2d setToRotation(float angle) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToRotation__SWIG_1(swigCPtr, this, angle), false);
  }

  public Matrix2d setToScaling(float scale, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToScaling__SWIG_0(swigCPtr, this, scale, Point2d.getCPtr(center), center), false);
  }

  public Matrix2d setToScaling(float scale) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToScaling__SWIG_1(swigCPtr, this, scale), false);
  }

  public Matrix2d setToScaling(float scaleX, float scaleY, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToScaling__SWIG_2(swigCPtr, this, scaleX, scaleY, Point2d.getCPtr(center), center), false);
  }

  public Matrix2d setToScaling(float scaleX, float scaleY) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToScaling__SWIG_3(swigCPtr, this, scaleX, scaleY), false);
  }

  public Matrix2d setToMirroring(Point2d pnt) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToMirroring__SWIG_0(swigCPtr, this, Point2d.getCPtr(pnt), pnt), false);
  }

  public Matrix2d setToMirroring() {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToMirroring__SWIG_1(swigCPtr, this), false);
  }

  public Matrix2d setToMirroring(Point2d pnt, Vector2d dir) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToMirroring__SWIG_2(swigCPtr, this, Point2d.getCPtr(pnt), pnt, Vector2d.getCPtr(dir), dir), false);
  }

  public Matrix2d setToShearing(float sx, float sy, Point2d pnt) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToShearing__SWIG_0(swigCPtr, this, sx, sy, Point2d.getCPtr(pnt), pnt), false);
  }

  public Matrix2d setToShearing(float sx, float sy) {
    return new Matrix2d(skiaviewJNI.Matrix2d_setToShearing__SWIG_1(swigCPtr, this, sx, sy), false);
  }

  public static Matrix2d translation(Vector2d vec) {
    return new Matrix2d(skiaviewJNI.Matrix2d_translation(Vector2d.getCPtr(vec), vec), true);
  }

  public static Matrix2d rotation(float angle, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_rotation__SWIG_0(angle, Point2d.getCPtr(center), center), true);
  }

  public static Matrix2d rotation(float angle) {
    return new Matrix2d(skiaviewJNI.Matrix2d_rotation__SWIG_1(angle), true);
  }

  public static Matrix2d scaling(float scale, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_scaling__SWIG_0(scale, Point2d.getCPtr(center), center), true);
  }

  public static Matrix2d scaling(float scale) {
    return new Matrix2d(skiaviewJNI.Matrix2d_scaling__SWIG_1(scale), true);
  }

  public static Matrix2d scaling(float scaleX, float scaleY, Point2d center) {
    return new Matrix2d(skiaviewJNI.Matrix2d_scaling__SWIG_2(scaleX, scaleY, Point2d.getCPtr(center), center), true);
  }

  public static Matrix2d scaling(float scaleX, float scaleY) {
    return new Matrix2d(skiaviewJNI.Matrix2d_scaling__SWIG_3(scaleX, scaleY), true);
  }

  public static Matrix2d mirroring(Point2d pnt) {
    return new Matrix2d(skiaviewJNI.Matrix2d_mirroring__SWIG_0(Point2d.getCPtr(pnt), pnt), true);
  }

  public static Matrix2d mirroring() {
    return new Matrix2d(skiaviewJNI.Matrix2d_mirroring__SWIG_1(), true);
  }

  public static Matrix2d mirroring(Point2d pnt, Vector2d dir) {
    return new Matrix2d(skiaviewJNI.Matrix2d_mirroring__SWIG_2(Point2d.getCPtr(pnt), pnt, Vector2d.getCPtr(dir), dir), true);
  }

  public static Matrix2d shearing(float sx, float sy, Point2d pnt) {
    return new Matrix2d(skiaviewJNI.Matrix2d_shearing__SWIG_0(sx, sy, Point2d.getCPtr(pnt), pnt), true);
  }

  public static Matrix2d shearing(float sx, float sy) {
    return new Matrix2d(skiaviewJNI.Matrix2d_shearing__SWIG_1(sx, sy), true);
  }

}
