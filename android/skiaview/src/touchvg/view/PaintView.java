package touchvg.view;

import touchvg.skiaview.GiSkiaView;
import touchvg.skiaview.GiSkiaView.kGestureState;
import touchvg.skiaview.GiSkiaView.kGestureType;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View {
    private GiSkiaView mCore;
    private GiCanvasEx mCanvas;
    private Context mContext;
    private GestureDetector mDetector;
    private kGestureState gestureState;
    private kGestureType gestureType;
    private int fingerCount;
    private float lastX = 1;
    private float lastY = 1;
    private float lastX1 = 1;
    private float lastY1 = 1;
    private boolean isMoving = false;
    private boolean mGestureEnable = true;
    private int mBkColor = Color.TRANSPARENT;
    private final PaintView mView = this;
    
    static {
        System.loadLibrary("skiaview");
    }
    
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }
    
    public PaintView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }
    
    private void init()
    {
        DisplayMetrics dm = mContext.getApplicationContext().getResources().getDisplayMetrics(); 
        GiCanvasEx.setScreenDpi(dm.densityDpi);
        
        mCanvas = new GiCanvasEx(this);
        mCore = new GiSkiaView(mCanvas);
        mDetector = new GestureDetector(mContext, new PaintGestureDetector());
        
        this.setOnTouchListener(new OnTouchListener() {
            
            public boolean onTouch(View v, MotionEvent event) {
                if (!mGestureEnable) {
                    return false;
                }
                mView.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction())
                {
                case MotionEvent.ACTION_MOVE:
                    if (event.getPointerCount() == 2 && fingerCount == 1) {
                        fingerCount = event.getPointerCount();
                        lastX = event.getX(0);
                        lastY = event.getY(0);
                        lastX1 = event.getX(1);
                        lastY1 = event.getY(1);
                        gestureState = kGestureState.kGestureBegan;
                    }
                    if (gestureState == kGestureState.kGestureBegan) {
                        gestureType = fingerCount > 1 ? kGestureType.kZoomRotatePan : kGestureType.kSinglePan;
                        mCore.onGesture(gestureType, gestureState, fingerCount, lastX, lastY, lastX1, lastY1);
                    }
                    gestureState = kGestureState.kGestureMoved;
                    isMoving = true;
                    lastX = event.getX(0);
                    lastY = event.getY(0);
                    if (event.getPointerCount() > 1)
                    {
                        lastX1 = event.getX(1);
                        lastY1 = event.getY(1);
                    }
                    if (event.getPointerCount() >= fingerCount) {
                        mCore.onGesture(gestureType, gestureState, fingerCount, lastX, lastY, lastX1, lastY1);
                    }
                    break;
                    
                case MotionEvent.ACTION_UP:
                    if (isMoving)
                    {
                        isMoving = false;
                        gestureState = kGestureState.kGestureEnded;
                        mCore.onGesture(gestureType, gestureState, fingerCount, lastX, lastY, lastX1, lastY1);
                        gestureType = kGestureType.kGestureUnknown;
                        fingerCount = 0;
                    }
                    break;
                }
                return mDetector.onTouchEvent(event);
            }
        });
    }
    
    public GiSkiaView getCoreView() {
        return mCore;
    }
    
    public void setBkColor(int argb) {
        mBkColor = argb;
    }
    
    protected void onDraw(Canvas canvas) {
        mCore.onSize(canvas.getWidth(), canvas.getHeight());
        
        if (mCanvas.beginPaint(canvas)) {
            canvas.drawColor(mBkColor);
            mCore.onDraw(mCanvas);
            mCore.onDynDraw(mCanvas);
            mCanvas.endPaint();
        }
    }
    
    public void setGestureEnable(boolean enable) {
        mGestureEnable = enable;
        
        if (!enable && gestureState == kGestureState.kGestureMoved) {
            gestureState = kGestureState.kGestureCancel;
            mCore.onGesture(gestureType, gestureState, 0, 0, 0, 0, 0);
        }
    }
    
    private class PaintGestureDetector extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            mCore.onGesture(kGestureType.kSingleTap, kGestureState.kGestureBegan, 1, e.getX(), e.getY(), 0, 0);
            return false;
        }
        
        @Override
        public void onLongPress(MotionEvent e) {
            mCore.onGesture(kGestureType.kLongPress, kGestureState.kGestureBegan, 1, e.getX(), e.getY(), 0, 0);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            gestureState = kGestureState.kGestureBegan;
            fingerCount = e.getPointerCount();
            lastX = e.getX(0);
            lastY = e.getY(0);
            if (fingerCount > 1) {
                lastX1 = e.getX(1);
                lastY1 = e.getY(1);
            }   // call mCore.onGesture in onTouch() after later.
            return true;
        }
        
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            mCore.onGesture(kGestureType.kDoubleTap, kGestureState.kGestureBegan, 1, e.getX(), e.getY(), 0, 0);
            return false;
        }
        
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float dx, float dy) {
            if (e2.getAction() == MotionEvent.ACTION_CANCEL) {
                gestureState = kGestureState.kGestureCancel;
                mCore.onGesture(gestureType, gestureState, 0, 0, 0, 0, 0);
            }
            return false;
        }
    }
    
}