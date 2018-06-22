package com.djf.github.readingnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button chapter01;
    private Button chapter02;
    private Button customView;
    private Button customTextView;
    private Button customViewGroup;
    private Button dragView;
    private Button drawButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chapter01 = findViewById(R.id.chapter1);
        chapter02 = findViewById(R.id.chapter2);
        customView = findViewById(R.id.customView);
        customTextView = findViewById(R.id.customTextView);
        customViewGroup = findViewById(R.id.customViewGroup);
        dragView = findViewById(R.id.dragViewTest);
        drawButton = findViewById(R.id.drawTest);
        chapter01.setOnClickListener(this);
        chapter02.setOnClickListener(this);
        customView.setOnClickListener(this);
        customTextView.setOnClickListener(this);
        customViewGroup.setOnClickListener(this);
        dragView.setOnClickListener(this);
        drawButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.chapter1:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.chapter01.LifeCycleActivity");
                startActivity(intent);
                break;
            case R.id.chapter2:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.chapter02.Chapter2Activity");
                startActivity(intent);
                break;

            case R.id.customView:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.View.CustomViewActivity");
                startActivity(intent);
                break;
            case R.id.customTextView:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.View.CustomTextViewActivity");
                startActivity(intent);
                break;
            case R.id.dragViewTest:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.Scroller.DragViewTest");
                startActivity(intent);
                break;
            case R.id.drawTest:
                intent.setClassName("com.djf.github.readingnotes", "com.djf.github.readingnotes.Draw.DrawActivity");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

