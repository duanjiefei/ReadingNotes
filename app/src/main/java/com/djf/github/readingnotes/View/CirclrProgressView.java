package com.djf.github.readingnotes.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/10.
 * 第三种重新自定义view
 */

public class CirclrProgressView extends View {

    private int mMeasureWidth;
    private int mMeasureHight;

    private float mCircleXY; //圆心的坐标
    private  float mRadius; //圆的半径
    private Paint mCirclePaint;

    private RectF mArcRectF;
    private Paint mArcPaint;
    private float mArcPercent = 75;//度数所占的比例
    private float mArcAngle; //需要画多少度
    private int arcColor = Color.GREEN;


    private Paint mTextPaint;
    private String Text;
    private float textSize;

    private int textColor = Color.BLACK;



    public CirclrProgressView(Context context) {
        super(context);
    }

    public CirclrProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        Text = ta.getString(R.styleable.CircleProgressView_CircleText);
        textSize = ta.getDimension(R.styleable.CircleProgressView_CircleTextSize,20);
        textColor = ta.getColor(R.styleable.CircleProgressView_CircleTextColor,Color.BLACK);
        arcColor = ta.getColor(R.styleable.CircleProgressView_ArcColor,Color.BLUE);
        mArcPercent = ta.getInt(R.styleable.CircleProgressView_ArcPrecent,25);
        ta.recycle();
    }

    public CirclrProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMeasureHight = MeasureSpec.getSize(heightMeasureSpec);
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(mMeasureWidth,mMeasureHight);
        initView();
    }

    private void initView() {
        float length = 0;
        if (mMeasureWidth>= mMeasureHight){
            length = mMeasureHight;
        }else{
            length = mMeasureWidth;
        }
        mCircleXY = length /2;
        mRadius = (float) (length*0.5) / 2;
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.BLUE);
        mCirclePaint.setAntiAlias(true);

        mArcRectF = new RectF((float)0.1*length,
                                (float)0.1*length,
                                (float)0.9*length,
                                (float)0.9*length);
        mArcAngle = (mArcPercent/100)*360;
        mArcPaint = new Paint();
        mArcPaint.setColor(arcColor);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStrokeWidth((float)0.1*length);
        mArcPaint.setStyle(Paint.Style.STROKE);


        //Text = setShowText();
        //textSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setColor(textColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(textSize);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCirclePaint);

        //绘制圆弧
        canvas.drawArc(mArcRectF,-90,mArcAngle,false,mArcPaint);  //从-90度或者270度开始，顺时针画mArcAngle度

        canvas.drawText(Text,0,Text.length(),mCircleXY,mCircleXY+textSize/4,mTextPaint);//绘制文字
    }


    private int setShowTextSize() {
        this.invalidate();
        return 20;
    }
    private String setShowText() {
        this.invalidate();
        return "Android Skill";
    }

    public void forceInvalidate() {
        this.invalidate();
    }

    public void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mArcPercent = sweepValue;
        } else {
            mArcPercent = 25;
        }
        this.invalidate();
    }
}
