/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * This file is not intended to be easily readable and contains a number of
 * coding conventions designed to improve portability and efficiency. Do not make
 * changes to this file unless you know what you are doing--modify the SWIG
 * interface file instead.
 * ----------------------------------------------------------------------------- */

#ifndef SWIG_touchvg_WRAP_H_
#define SWIG_touchvg_WRAP_H_

class SwigDirector_GiCanvas : public GiCanvas, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_GiCanvas(JNIEnv *jenv);
    virtual ~SwigDirector_GiCanvas();
    virtual void setPen(int argb, float width, int style, float phase);
    virtual void setBrush(int argb, int style);
    virtual void clearRect(float x, float y, float w, float h);
    virtual void drawRect(float x, float y, float w, float h, bool stroke, bool fill);
    virtual void drawLine(float x1, float y1, float x2, float y2);
    virtual void drawEllipse(float x, float y, float w, float h, bool stroke, bool fill);
    virtual void beginPath();
    virtual void moveTo(float x, float y);
    virtual void lineTo(float x, float y);
    virtual void bezierTo(float c1x, float c1y, float c2x, float c2y, float x, float y);
    virtual void quadTo(float cpx, float cpy, float x, float y);
    virtual void closePath();
    virtual void drawPath(bool stroke, bool fill);
    virtual void saveClip();
    virtual void restoreClip();
    virtual bool clipRect(float x, float y, float w, float h);
    virtual bool clipPath();
    virtual void drawHandle(float x, float y, int type);
    virtual void drawBitmap(char const *name, float xc, float yc, float w, float h, float angle);
    virtual float drawTextAt(char const *text, float x, float y, float h, int align);
public:
    bool swig_overrides(int n) {
      return (n < 20 ? swig_override[n] : false);
    }
protected:
    bool swig_override[20];
};

class SwigDirector_MgStorageBase : public MgStorageBase, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgStorageBase(JNIEnv *jenv);
    virtual bool readNode(char const *name, int index, bool ended);
    virtual bool writeNode(char const *name, int index, bool ended);
    virtual bool readBool(char const *name, bool defvalue);
    virtual float readFloat(char const *name, float defvalue);
    virtual void writeBool(char const *name, bool value);
    virtual void writeFloat(char const *name, float value);
    virtual void writeString(char const *name, char const *value);
    virtual int readInt(char const *name, int defvalue);
    virtual void writeInt(char const *name, int value);
    virtual void writeUInt(char const *name, int value);
    virtual bool setError(char const *errdesc);
    virtual ~SwigDirector_MgStorageBase();
    virtual int readFloatArray(char const *name, mgvector< float > &values);
    virtual void writeFloatArray(char const *name, mgvector< float > const &values);
    virtual int readString(char const *name, mgvector< char > &value);
public:
    bool swig_overrides(int n) {
      return (n < 14 ? swig_override[n] : false);
    }
protected:
    bool swig_override[14];
};

class SwigDirector_MgBaseShape : public MgBaseShape, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgBaseShape(JNIEnv *jenv);
    virtual MgObject *clone() const;
    virtual void copy(MgObject const &src);
    virtual void release();
    virtual bool equals(MgObject const &src) const;
    virtual int getType() const;
    virtual bool isKindOf(int type) const;
    virtual ~SwigDirector_MgBaseShape();
    virtual void setOwner(MgShape *owner);
    virtual Box2d getExtent() const;
    virtual void update();
    virtual void transform(Matrix2d const &mat);
    virtual void clear();
    virtual void clearCachedData();
    virtual int getPointCount() const;
    virtual Point2d getPoint(int index) const;
    virtual void setPoint(int index, Point2d const &pt);
    virtual bool isClosed() const;
    virtual bool isCurve() const;
    virtual float hitTest(Point2d const &pt, float tol, MgHitResult &res) const;
    virtual bool hitTestBox(Box2d const &rect) const;
    virtual bool draw(int mode, GiGraphics &gs, GiContext const &ctx, int segment = -1) const;
    virtual bool save(MgStorage *s) const;
    virtual bool load(MgShapeFactory *factory, MgStorage *s);
    virtual int getHandleCount() const;
    virtual Point2d getHandlePoint(int index) const;
    virtual bool setHandlePoint(int index, Point2d const &pt, float tol);
    virtual bool isHandleFixed(int index) const;
    virtual int getHandleType(int index) const;
    virtual bool offset(Vector2d const &vec, int segment);
    virtual void setFlag(MgShapeBit bit, bool on);
    virtual char const *getTypeName() const;
public:
    bool swig_overrides(int n) {
      return (n < 31 ? swig_override[n] : false);
    }
protected:
    bool swig_override[31];
};

class SwigDirector_MgBaseRect : public MgBaseRect, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgBaseRect(JNIEnv *jenv);
    virtual MgObject *clone() const;
    virtual void copy(MgObject const &src);
    virtual void release();
    virtual bool equals(MgObject const &src) const;
    virtual int getType() const;
    virtual bool isKindOf(int type) const;
    virtual ~SwigDirector_MgBaseRect();
    virtual void setOwner(MgShape *owner);
    virtual Box2d getExtent() const;
    virtual void update();
    virtual void transform(Matrix2d const &mat);
    virtual void clear();
    virtual void clearCachedData();
    virtual int getPointCount() const;
    virtual Point2d getPoint(int index) const;
    virtual void setPoint(int index, Point2d const &pt);
    virtual bool isClosed() const;
    virtual bool isCurve() const;
    virtual float hitTest(Point2d const &pt, float tol, MgHitResult &res) const;
    virtual bool hitTestBox(Box2d const &rect) const;
    virtual bool draw(int mode, GiGraphics &gs, GiContext const &ctx, int segment = -1) const;
    virtual bool save(MgStorage *s) const;
    virtual bool load(MgShapeFactory *factory, MgStorage *s);
    virtual int getHandleCount() const;
    virtual Point2d getHandlePoint(int index) const;
    virtual bool setHandlePoint(int index, Point2d const &pt, float tol);
    virtual bool isHandleFixed(int index) const;
    virtual int getHandleType(int index) const;
    virtual bool offset(Vector2d const &vec, int segment);
    virtual void setFlag(MgShapeBit bit, bool on);
    virtual char const *getTypeName() const;
public:
    bool swig_overrides(int n) {
      return (n < 31 ? swig_override[n] : false);
    }
protected:
    bool swig_override[31];
};

class SwigDirector_MgBaseLines : public MgBaseLines, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgBaseLines(JNIEnv *jenv);
    virtual MgObject *clone() const;
    virtual void copy(MgObject const &src);
    virtual void release();
    virtual bool equals(MgObject const &src) const;
    virtual int getType() const;
    virtual bool isKindOf(int type) const;
    virtual ~SwigDirector_MgBaseLines();
    virtual void setOwner(MgShape *owner);
    virtual Box2d getExtent() const;
    virtual void update();
    virtual void transform(Matrix2d const &mat);
    virtual void clear();
    virtual void clearCachedData();
    virtual int getPointCount() const;
    virtual Point2d getPoint(int index) const;
    virtual void setPoint(int index, Point2d const &pt);
    virtual bool isClosed() const;
    virtual bool isCurve() const;
    virtual float hitTest(Point2d const &pt, float tol, MgHitResult &res) const;
    virtual bool hitTestBox(Box2d const &rect) const;
    virtual bool draw(int mode, GiGraphics &gs, GiContext const &ctx, int segment = -1) const;
    virtual bool save(MgStorage *s) const;
    virtual bool load(MgShapeFactory *factory, MgStorage *s);
    virtual int getHandleCount() const;
    virtual Point2d getHandlePoint(int index) const;
    virtual bool setHandlePoint(int index, Point2d const &pt, float tol);
    virtual bool isHandleFixed(int index) const;
    virtual int getHandleType(int index) const;
    virtual bool offset(Vector2d const &vec, int segment);
    virtual void setFlag(MgShapeBit bit, bool on);
    virtual char const *getTypeName() const;
public:
    bool swig_overrides(int n) {
      return (n < 31 ? swig_override[n] : false);
    }
protected:
    bool swig_override[31];
};

class SwigDirector_MgComposite : public MgComposite, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgComposite(JNIEnv *jenv);
    virtual MgObject *clone() const;
    virtual void copy(MgObject const &src);
    virtual void release();
    virtual bool equals(MgObject const &src) const;
    virtual int getType() const;
    virtual bool isKindOf(int type) const;
    virtual ~SwigDirector_MgComposite();
    virtual void setOwner(MgShape *owner);
    virtual Box2d getExtent() const;
    virtual void update();
    virtual void transform(Matrix2d const &mat);
    virtual void clear();
    virtual void clearCachedData();
    virtual int getPointCount() const;
    virtual Point2d getPoint(int index) const;
    virtual void setPoint(int index, Point2d const &pt);
    virtual bool isClosed() const;
    virtual bool isCurve() const;
    virtual float hitTest(Point2d const &pt, float tol, MgHitResult &res) const;
    virtual bool hitTestBox(Box2d const &rect) const;
    virtual bool draw(int mode, GiGraphics &gs, GiContext const &ctx, int segment = -1) const;
    virtual bool save(MgStorage *s) const;
    virtual bool load(MgShapeFactory *factory, MgStorage *s);
    virtual int getHandleCount() const;
    virtual Point2d getHandlePoint(int index) const;
    virtual bool setHandlePoint(int index, Point2d const &pt, float tol);
    virtual bool isHandleFixed(int index) const;
    virtual int getHandleType(int index) const;
    virtual bool offset(Vector2d const &vec, int segment);
    virtual void setFlag(MgShapeBit bit, bool on);
    virtual char const *getTypeName() const;
    virtual bool canOffsetShapeAlone(MgShape *shape);
public:
    bool swig_overrides(int n) {
      return (n < 32 ? swig_override[n] : false);
    }
protected:
    bool swig_override[32];
};

struct SwigDirector_MgCommand : public MgCommand, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgCommand(JNIEnv *jenv);
    virtual ~SwigDirector_MgCommand();
    virtual char const *getName() const;
    virtual void release();
    virtual bool cancel(MgMotion const *sender);
    virtual bool initialize(MgMotion const *sender, MgStorage *s);
    virtual bool backStep(MgMotion const *sender);
    virtual bool draw(MgMotion const *sender, GiGraphics *gs);
    virtual int gatherShapes(MgMotion const *sender, MgShapes *shapes);
    virtual bool click(MgMotion const *sender);
    virtual bool doubleClick(MgMotion const *sender);
    virtual bool longPress(MgMotion const *sender);
    virtual bool touchBegan(MgMotion const *sender);
    virtual bool touchMoved(MgMotion const *sender);
    virtual bool touchEnded(MgMotion const *sender);
    virtual bool mouseHover(MgMotion const *sender);
    virtual bool twoFingersMove(MgMotion const *sender);
    virtual bool isDrawingCommand();
    virtual bool isFloatingCommand();
    virtual bool doContextAction(MgMotion const *sender, int action);
public:
    bool swig_overrides(int n) {
      return (n < 18 ? swig_override[n] : false);
    }
protected:
    bool swig_override[18];
};

class SwigDirector_CmdObserverDefault : public CmdObserverDefault, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_CmdObserverDefault(JNIEnv *jenv);
    virtual void onDocLoaded(MgMotion const *sender);
    virtual void onEnterSelectCommand(MgMotion const *sender);
    virtual void onUnloadCommands(MgCmdManager *sender);
    virtual bool selectActionsNeedHided(MgMotion const *sender);
    virtual bool doAction(MgMotion const *sender, int action);
    virtual bool doEndAction(MgMotion const *sender, int action);
    virtual void drawInShapeCommand(MgMotion const *sender, MgCommand *cmd, GiGraphics *gs);
    virtual void drawInSelectCommand(MgMotion const *sender, MgShape const *sp, int handleIndex, GiGraphics *gs);
    virtual bool onShapeWillAdded(MgMotion const *sender, MgShape *sp);
    virtual void onShapeAdded(MgMotion const *sender, MgShape *sp);
    virtual bool onShapeWillDeleted(MgMotion const *sender, MgShape *sp);
    virtual void onShapeDeleted(MgMotion const *sender, MgShape *sp);
    virtual bool onShapeCanRotated(MgMotion const *sender, MgShape const *sp);
    virtual bool onShapeCanTransform(MgMotion const *sender, MgShape const *sp);
    virtual bool onShapeCanUnlock(MgMotion const *sender, MgShape const *sp);
    virtual bool onShapeCanUngroup(MgMotion const *sender, MgShape const *sp);
    virtual void onShapeMoved(MgMotion const *sender, MgShape *sp, int segment);
    virtual MgBaseShape *createShape(MgMotion const *sender, int type);
    virtual ~SwigDirector_CmdObserverDefault();
public:
    bool swig_overrides(int n) {
      return (n < 18 ? swig_override[n] : false);
    }
protected:
    bool swig_override[18];
};

class SwigDirector_MgCommandDraw : public MgCommandDraw, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgCommandDraw(JNIEnv *jenv);
    virtual ~SwigDirector_MgCommandDraw();
    virtual char const *getName() const;
    virtual void release();
    virtual bool cancel(MgMotion const *sender);
    virtual bool initialize(MgMotion const *sender, MgStorage *s);
    virtual bool backStep(MgMotion const *sender);
    virtual bool draw(MgMotion const *sender, GiGraphics *gs);
    virtual int gatherShapes(MgMotion const *sender, MgShapes *shapes);
    virtual bool click(MgMotion const *sender);
    virtual bool doubleClick(MgMotion const *sender);
    virtual bool longPress(MgMotion const *sender);
    virtual bool touchBegan(MgMotion const *sender);
    virtual bool touchMoved(MgMotion const *sender);
    virtual bool touchEnded(MgMotion const *sender);
    virtual bool mouseHover(MgMotion const *sender);
    virtual bool twoFingersMove(MgMotion const *sender);
    virtual bool isDrawingCommand();
    virtual bool isFloatingCommand();
    virtual bool doContextAction(MgMotion const *sender, int action);
    virtual int getMaxStep();
    virtual int getMaxStepSwigPublic() {
      return MgCommandDraw::getMaxStep();
    }
    virtual void setStepPoint(int step, Point2d const &pt);
    virtual void setStepPointSwigPublic(int step, Point2d const &pt) {
      MgCommandDraw::setStepPoint(step,pt);
    }
public:
    bool swig_overrides(int n) {
      return (n < 20 ? swig_override[n] : false);
    }
protected:
    bool swig_override[20];
};

class SwigDirector_MgCmdDrawRect : public MgCmdDrawRect, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_MgCmdDrawRect(JNIEnv *jenv);
    virtual ~SwigDirector_MgCmdDrawRect();
    virtual char const *getName() const;
    virtual void release();
    virtual bool cancel(MgMotion const *sender);
    virtual bool initialize(MgMotion const *sender, MgStorage *s);
    virtual bool backStep(MgMotion const *sender);
    virtual bool draw(MgMotion const *sender, GiGraphics *gs);
    virtual int gatherShapes(MgMotion const *sender, MgShapes *shapes);
    virtual bool click(MgMotion const *sender);
    virtual bool doubleClick(MgMotion const *sender);
    virtual bool longPress(MgMotion const *sender);
    virtual bool touchBegan(MgMotion const *sender);
    virtual bool touchMoved(MgMotion const *sender);
    virtual bool touchEnded(MgMotion const *sender);
    virtual bool mouseHover(MgMotion const *sender);
    virtual bool twoFingersMove(MgMotion const *sender);
    virtual bool isDrawingCommand();
    virtual bool isFloatingCommand();
    virtual bool doContextAction(MgMotion const *sender, int action);
    virtual int getMaxStep();
    virtual int getMaxStepSwigPublic() {
      return MgCommandDraw::getMaxStep();
    }
    virtual void setStepPoint(int step, Point2d const &pt);
    virtual void setStepPointSwigPublic(int step, Point2d const &pt) {
      MgCommandDraw::setStepPoint(step,pt);
    }
    virtual void addRectShape(MgMotion const *sender);
    virtual void addRectShapeSwigPublic(MgMotion const *sender) {
      MgCmdDrawRect::addRectShape(sender);
    }
public:
    bool swig_overrides(int n) {
      return (n < 21 ? swig_override[n] : false);
    }
protected:
    bool swig_override[21];
};

class SwigDirector_GiView : public GiView, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_GiView(JNIEnv *jenv);
    virtual ~SwigDirector_GiView();
    virtual void regenAll();
    virtual void regenAppend();
    virtual void redraw();
    virtual bool useFinger();
    virtual bool isContextActionsVisible();
    virtual bool showContextActions(mgvector< int > const &actions, mgvector< float > const &buttonXY, float x, float y, float w, float h);
    virtual void commandChanged();
    virtual void selectionChanged();
    virtual void contentChanged();
public:
    bool swig_overrides(int n) {
      return (n < 9 ? swig_override[n] : false);
    }
protected:
    bool swig_override[9];
};


#endif
