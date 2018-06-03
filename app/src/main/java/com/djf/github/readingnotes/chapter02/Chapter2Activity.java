package com.djf.github.readingnotes.chapter02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.djf.github.readingnotes.R;
import com.djf.github.readingnotes.Utils.SimpleLogUtils;

/**
 * Created by Sky000 on 2018/6/2.
 */

public class Chapter2Activity extends Activity implements View.OnClickListener{

    private Button start_process;
    private TextView thread;
    private TextView process;
    private TextView thread_process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter2layout);
        start_process =  findViewById(R.id.start_process);
        thread = findViewById(R.id.thread);
        process = findViewById(R.id.process);
        thread_process = findViewById(R.id.thread_process);
        findViewById(R.id.thread_process);
        start_process.setOnClickListener(this);
        initView();
    }

    private void initView() {
        thread.setText(R.string.thread);
        process.setText(R.string.process);
        thread_process.setText(R.string.thread_process);
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
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.start_process:
                intent.setClassName("com.djf.github.readingnotes","com.djf.github.readingnotes.chapter02.StartProcessActivity");
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
