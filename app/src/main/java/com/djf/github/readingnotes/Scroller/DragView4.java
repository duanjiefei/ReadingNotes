package com.djf.github.readingnotes.Scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by Sky000 on 2018/6/17.
 */

public class DragView4 extends View {

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;

    public DragView4(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.BLACK);
        mScroller = new Scroller(context);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){

        }
    }
}
