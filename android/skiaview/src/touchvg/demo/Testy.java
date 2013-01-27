﻿package touchvg.demo;

import touchvg.view.MyPaintView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Testy extends Activity {
    private MyPaintView mView;      //组件类
    private Button buttonSelect;    //选择图形按钮
    private Button buttonClear;     //清除图形按钮
    private Button buttonRed;       //红色画笔按钮
    private Button buttonBlue;      //蓝色画笔按钮
    private Button buttonThickPen;  //画笔变细按钮
    private Button buttonBoldPen;   //画笔变粗按钮
    private Button buttonYellow;    //黄色画笔按钮
    private Button buttonEraser;    //橡皮按钮
    private Button buttonStyle;     //线型按钮
    private Button buttonSave;      //保存按钮
    private Button buttonShape;     //形状按钮
    private Button buttonPicture;   //插图按钮
    public String mFilePath = "mnt/sdcard/TouchVG/";

    /// Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.initComponent();
        this.bindButtonsEvent();
        mView.loadFromFile(mFilePath + "demo.vg");
    }

    private OnClickListener onClickListener = new OnClickListener() {
        public void onClick(View v) {
            switch (v.getId())
            {
            case R.id.selectshapes_button:
                mView.onSelect();
                break;
            case R.id.eraser_button:
                mView.onEraser();
                break;
            case R.id.clearshapes_button:
                mView.clearShapes();
                mView.clearAllImageFiles();
                break;
            case R.id.redPen_button:
                mView.setShapeType("");
                mView.setRedPen();
                break;
            case R.id.yellowPen_button:
            	mView.setShapeType("");
                mView.setYellowPen();
                break;
            case R.id.bluePen_button:
            	mView.setShapeType("");
                mView.setBluePen();
                break;
            case R.id.thickPen_button:
                mView.setPenThick();
                break;
            case R.id.boldPen_button:
                mView.setPenBold();
                break;
            case R.id.stylePen_button:
                mView.switchPenStyle();
                break;
            case R.id.save_button:
                mView.saveAsFile(mFilePath + "demo.vg");
                mView.clearAllUnusedFiles();
                break;
            case R.id.shapeType_button:
                mView.switchShapeType();
                break;
            case R.id.picture_button:
                mView.addImage(R.drawable.ic_launcher);
                break;
            }
            buttonShape.setText(mView.getCommandName());
        }
    };
    
    private void bindButtonsEvent()
    {
        buttonSelect.setOnClickListener(onClickListener);
        buttonClear.setOnClickListener(onClickListener);
        buttonShape.setOnClickListener(onClickListener);
        buttonRed.setOnClickListener(onClickListener);
        buttonBlue.setOnClickListener(onClickListener);
        buttonYellow.setOnClickListener(onClickListener);
        buttonBoldPen.setOnClickListener(onClickListener);
        buttonThickPen.setOnClickListener(onClickListener);
        buttonEraser.setOnClickListener(onClickListener);
        buttonStyle.setOnClickListener(onClickListener);
        buttonSave.setOnClickListener(onClickListener);
        buttonPicture.setOnClickListener(onClickListener);
    }

    private void initComponent()
    {
        mView = new MyPaintView(this.findViewById(R.id.paintView),this);
        mView.setBkColor(Color.GRAY);
        mView.setBitmapIDs(R.drawable.vgdot1, R.drawable.vgdot2);
        
        buttonSelect    = (Button) this.findViewById(R.id.selectshapes_button);
        buttonClear     = (Button) this.findViewById(R.id.clearshapes_button);
        buttonShape     = (Button) this.findViewById(R.id.shapeType_button);
        buttonRed       = (Button) this.findViewById(R.id.redPen_button);
        buttonBlue      = (Button) this.findViewById(R.id.bluePen_button);
        buttonYellow    = (Button) this.findViewById(R.id.yellowPen_button);
        buttonBoldPen   = (Button) this.findViewById(R.id.boldPen_button);
        buttonThickPen  = (Button) this.findViewById(R.id.thickPen_button);
        buttonEraser    = (Button) this.findViewById(R.id.eraser_button);
        buttonStyle     = (Button) this.findViewById(R.id.stylePen_button);
        buttonSave      = (Button) this.findViewById(R.id.save_button);
        buttonPicture   = (Button) this.findViewById(R.id.picture_button);
    }
}
