package com.djf.github.readingnotes.View;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.djf.github.readingnotes.Utils.SimpleLogUtils;

/**
 *@auther djf
 *create at
 */

public class CustomView  extends View{


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);  //如果直接调用父类的onMeasure方法，则wrapcontent 与matchpartent的效果一样
        //setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }


    /**
     *@auther djf
     *create at 2018/6/7
     *
     * Android系统给我们提供了一个牛逼的类—-MeasureSpec类，我们可通过它来测量View。MeasureSpec是一个32位的值，
     * 其中高两位为测量的模式，低30位为测量的大小，在计算中使用位运算当然是提高运行速率了。

    测量模式为以下三种。
    EXACTLY
    　　即精确模式，当我们将控件的layout_width或layout_height属性设定为具体值时，
        比如android:layout_width=”100dp”，或者指定为match_parent属性时（占据父View的大小），系统使用的是EXACTLY模式。

    AT_MOST
    　　即最大模式，当控件的layout_width或layout_height属性设定为wrap_content时，
        控件大小一般随着控件的子控件或内容的变化而变化，此时控件的尺寸只要不超过父控件允许的最大尺寸即可。

    UNSPECIFIED
    　　这个属性比较奇怪—-它不指定其大小测量模式，View想多大就多大，通常在自定义View时才会使用。

    　　View类默认的onMeasure()方法只支持EXACTLY模式，所以如果在自定义控件的时候不重写onMeasure()方法的话，
        就只能使用EXACTLY模式。控件可以响应你指定的具体宽高值或者是match_parent属性。而如果要让自定义View支持wrap_content属性，
        那就必须重写onMeasure()方法来指定wrap_content时的大小。
     */
    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specHeight  = MeasureSpec.getSize(heightMeasureSpec);//当android:layout_width="wrap_content"  android:layout_height="wrap_content"测量出来的就是屏幕的宽高
        SimpleLogUtils.d("specHeight"+specHeight);
        if (specMode == MeasureSpec.EXACTLY){
            result = specHeight;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specHeight);
            }
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidth  = MeasureSpec.getSize(widthMeasureSpec);
        SimpleLogUtils.d("specWidth"+specWidth);
        if (specMode == MeasureSpec.EXACTLY){
            result = specWidth;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specWidth);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
