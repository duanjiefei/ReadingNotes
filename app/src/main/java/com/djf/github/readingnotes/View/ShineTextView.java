package com.djf.github.readingnotes.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Sky000 on 2018/6/8.
 */

public class ShineTextView extends TextView {
    private Paint mPaint;
    private int mWidth = 0;
    private int mTranslate = 0;

    private LinearGradient mLinearGradient;
    private Matrix matrix;
    public ShineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (matrix!=null){
            mTranslate += mWidth/5;
            if (mTranslate > 2*mWidth){
                mTranslate =-mWidth;
            }
            matrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(200);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mWidth == 0){
            mWidth = getMeasuredWidth();
            if (mWidth>0){
                mPaint=getPaint();
                mLinearGradient = new LinearGradient(0,0,mWidth,0,new int[]{Color.BLUE,0xfffffff,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                matrix = new Matrix();
            }
        }
    }
}
