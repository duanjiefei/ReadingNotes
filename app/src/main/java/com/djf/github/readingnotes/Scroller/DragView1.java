package com.djf.github.readingnotes.Scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.djf.github.readingnotes.Utils.SimpleLogUtils;

/**
 * Created by Sky000 on 2018/6/15.
 */

public class DragView1  extends View{
    private int mLastX;
    private int mLastY;


    public DragView1(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.BLUE);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        SimpleLogUtils.d("getX() == "+x);
        SimpleLogUtils.d("getY() == "+y);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                SimpleLogUtils.d("MotionEvent.ACTION_DOWN");
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                SimpleLogUtils.d("MotionEvent.ACTION_MOVE");
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                //layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);//调用layout方法对
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
/*                mLastX = x;
                mLastY = y;*/
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        SimpleLogUtils.d("getRawX() == "+x);
        SimpleLogUtils.d("getRawY() == "+y);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                SimpleLogUtils.d("MotionEvent.ACTION_DOWN");
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                SimpleLogUtils.d("MotionEvent.ACTION_MOVE");
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                mLastX = x;
                mLastY = y;  使用绝对坐标，需要对初始位置进行重新初始化
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }*/
}
