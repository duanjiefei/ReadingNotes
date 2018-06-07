package com.djf.github.readingnotes.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Sky000 on 2018/6/7.
 */

public class CustomTextView01  extends  CustomTextView{
    private Paint mPaint1;
    private Paint mPaint2;

    public CustomTextView01(Context context) {
        super(context);
        init();
    }

    /**
     *@auther djf
     *create at 2018/6/7
     * 初始化画笔paint
     */
    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    public CustomTextView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomTextView01(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();

        super.onDraw(canvas);
        canvas.restore();
    }
}
