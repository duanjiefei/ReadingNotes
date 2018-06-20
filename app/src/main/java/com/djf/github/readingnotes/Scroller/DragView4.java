package com.djf.github.readingnotes.Scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.djf.github.readingnotes.Utils.SimpleLogUtils;

/**
 * Created by Sky000 on 2018/6/17.
 */

public class DragView4 extends View {

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;
    View viewGroup ;

    public DragView4(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        SimpleLogUtils.d("initView == ");
        setBackgroundColor(Color.BLACK);
        mScroller = new Scroller(context);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        SimpleLogUtils.d("viewGroup.getScrollX() == "+((View) getParent()).getScrollX());
        SimpleLogUtils.d("viewGroup.getScrollY() "+((View) getParent()).getScrollX());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                ((View) getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                SimpleLogUtils.d("MotionEvent.ACTION_UP");
                View viewGroup = (View) getParent();
                mScroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),-viewGroup.getScrollX(),-viewGroup.getScrollY());
                invalidate();
                break;
        }
        return true;
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        SimpleLogUtils.d("mScroller.computeScrollOffset() == "+mScroller.computeScrollOffset());
        SimpleLogUtils.d("mScroller.getCurrX() == "+mScroller.getCurrX());//((View)getParent()).scrollBy(-offsetX,-offsetY)动作完成之前，偏移量为零，动作结束后才有相应的值
        SimpleLogUtils.d("mScroller.getCurrY() == "+mScroller.getCurrY());
        //判断 ((View)getParent()).scrollBy(-offsetX,-offsetY);的动作是否完成
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();//invalidate > ondraw >computeScroll
        }
    }
}
