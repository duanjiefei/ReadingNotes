package com.djf.github.readingnotes.Scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sky000 on 2018/6/17.
 */

public class DragView3 extends View {
    private int mLastX;
    private int mLastY;


    public DragView3(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.YELLOW);
    }

    public DragView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
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
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    /*      @Override
          public boolean onTouchEvent(MotionEvent event) {
              int x = (int) event.getRawX();
              int y = (int) event.getRawY();
              switch (event.getAction()){
                  case MotionEvent.ACTION_DOWN:
                      mLastX = x;
                      mLastY = y;
                      break;
                  case MotionEvent.ACTION_MOVE:
                      int offsetX = x - mLastX;
                      int offsetY = y - mLastY;
                 *//*     mLastX = x;
                      mLastY = y;*//*
                      ((View)getParent()).scrollTo(-offsetX,-offsetY);
                      break;
                  case MotionEvent.ACTION_UP:
                      break;
              }
              return true;
          }*/
}
