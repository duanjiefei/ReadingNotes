package com.djf.github.readingnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button chapter01;
    private Button chapter02;
    private Button customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chapter01 = findViewById(R.id.chapter1);
        chapter02 = findViewById(R.id.chapter2);
        customView = findViewById(R.id.customView);
        chapter01.setOnClickListener(this);
        chapter02.setOnClickListener(this);
        customView.setOnClickListener(this);
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
            default:
                break;
        }
    }
}

