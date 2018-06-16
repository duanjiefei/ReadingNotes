package com.djf.github.readingnotes.Scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/**
 * Created by Sky000 on 2018/6/15.
 */

public class DragView2 extends View{

    private int mLastX;
    private int mLastY;

    public DragView2(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.GREEN);
    }

    public DragView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                MarginLayoutParams la = (MarginLayoutParams) getLayoutParams();
                la.leftMargin = getLeft()+offsetX;
                la.topMargin = getTop()+offsetY;
                setLayoutParams(la);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
