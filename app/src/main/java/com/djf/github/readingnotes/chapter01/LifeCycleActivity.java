package com.djf.github.readingnotes.chapter01;

import android.app.Activity;
import android.os.Bundle;

import com.djf.github.readingnotes.Bean.LogUtil;
import com.djf.github.readingnotes.R;

public class LifeCycleActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d3("");
        setContentView(R.layout.activity_life_cycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d3("");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d3("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d3("");
    }

    /**
     * 只有当activity 异常销毁被重新创建时才会被调用
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.d3("");
    }

    /**
     * 只有当activity 异常销毁时，才会被调用
     *
     * 异常销毁常见分两种情况 1 ：资源相关的系统配置发生改变导致Activity被杀死，并重新创建，例如：屏幕方向发生改变
     *                        2 ：系统内存不足，导致低优先级的Activity被杀死
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.d3("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d3("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d3("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d3("");
    }
}
