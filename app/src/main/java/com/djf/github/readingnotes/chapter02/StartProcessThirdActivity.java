package com.djf.github.readingnotes.chapter02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.djf.github.readingnotes.R;
import com.djf.github.readingnotes.Utils.SimpleLogUtils;

/**
 * Created by Sky000 on 2018/6/3.
 */

public class StartProcessThirdActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity_layout);
        SimpleLogUtils.d("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        SimpleLogUtils.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SimpleLogUtils.d("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SimpleLogUtils.d("onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        SimpleLogUtils.d("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SimpleLogUtils.d("onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SimpleLogUtils.d("onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SimpleLogUtils.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SimpleLogUtils.d("onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
        }
    }
}
