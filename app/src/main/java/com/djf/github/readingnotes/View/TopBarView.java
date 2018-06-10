package com.djf.github.readingnotes.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/8.
 *
 * 第二种，利用已有控件，创建复合控件
 */

public class TopBarView  extends RelativeLayout{

    private String tittle;
    private float tittleSize;
    private int tittleColor;

    private String leftTittle;
    private Drawable leftBackGround;
    private int leftTittleColor;

    private String rightTittle;
    private Drawable rightBackGround;
    private int rightTittleColor;

    private Button leftButton;
    private Button rightButton;
    private TextView topTittle;

    // 布局属性，用来控制组件元素在ViewGroup中的位置
    private LayoutParams mLeftParams, mTitlepParams, mRightParams;

    private TopBarListener mTopBarListener;


    public TopBarView(Context context) {
        super(context);
    }

    public TopBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xFFF59563);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TopBarView);
        tittle =  ta.getString(R.styleable.TopBarView_tittle);
        tittleColor = ta.getColor(R.styleable.TopBarView_tittleColor,0);
        tittleSize = ta.getDimension(R.styleable.TopBarView_tittleSize,10);

        leftTittle = ta.getString(R.styleable.TopBarView_leftTittle);
        leftBackGround = ta.getDrawable(R.styleable.TopBarView_leftBackGround);
        leftTittleColor = ta.getColor(R.styleable.TopBarView_leftTittleColor,0);

        rightTittle = ta.getString(R.styleable.TopBarView_rightTittle);
        rightBackGround = ta.getDrawable(R.styleable.TopBarView_rightBackGround);
        rightTittleColor = ta.getColor(R.styleable.TopBarView_rightTittleColor,0);
        //获取完TypedArray的值之后，需要调用recycle方法，避免重新创建的时候导致的错误
        ta.recycle();

        leftButton =  new Button(context);
        rightButton = new Button(context);
        topTittle = new TextView(context);

        // 为创建的组件元素赋值
        // 值就来源于我们在引用的xml文件中给对应属性的赋值
        leftButton.setTextColor(leftTittleColor);
        leftButton.setBackground(leftBackGround);
        leftButton.setText(leftTittle);

        rightButton.setTextColor(rightTittleColor);
        rightButton.setBackground(rightBackGround);
        rightButton.setText(rightTittle);

        topTittle.setText(tittle);
        topTittle.setTextColor(tittleColor);
        topTittle.setTextSize(tittleSize);
        topTittle.setGravity(Gravity.CENTER);

        // 为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // 添加到ViewGroup
        addView(leftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, mRightParams);

        mTitlepParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(topTittle, mTitlepParams);


        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopBarListener.leftOnclick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopBarListener.rightOnclick();
            }
        });

    }

    public void setTopBarListener(TopBarListener listener){
        this.mTopBarListener = listener;
    }

    public TopBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public interface  TopBarListener{
        void leftOnclick();
        void rightOnclick();
    }
}
