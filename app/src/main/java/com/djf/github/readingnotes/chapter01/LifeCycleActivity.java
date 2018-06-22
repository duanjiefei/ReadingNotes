package com.djf.github.readingnotes.chapter01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import com.djf.github.readingnotes.R;
import com.djf.github.readingnotes.Utils.SimpleLogUtils;

public class LifeCycleActivity extends Activity {

    /**
     * 创建基本的UI元素
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LogUtil.d3("");
        SimpleLogUtils.d("onCreate");
        setContentView(R.layout.activity_life_cycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //LogUtil.d3("");
        SimpleLogUtils.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //LogUtil.d3("");
        SimpleLogUtils.d("onRestart");
    }

    /**
     * 重新创建在onpause中释放的资源
     */
    @Override
    protected void onResume() {
        super.onResume();
        //LogUtil.d3("");
        SimpleLogUtils.d("onResume");
    }

    /**
     * 只有当activity 异常销毁被重新创建时才会被调用
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //LogUtil.d3("");
        SimpleLogUtils.d("onRestoreInstanceState");
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
        //LogUtil.d3("");
        SimpleLogUtils.d("onSaveInstanceState");
    }

    /**
     * 1 当Activity 的启动模式属于singletop时，且该activity位于栈顶时，此方法会被调用
     * 2 当Actvity 的启动模式属于singletask时，且该activity已经在栈内创建，此方法会被调用
     * 3 当Activity 的启动模式属于singleinstance时，当activity已经在应用内创建，此方法会被创建
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /**
     * 释放系统资源
     */
    @Override
    protected void onPause() {
        super.onPause();
        //LogUtil.d3("");
        SimpleLogUtils.d("onPause");
    }

    /**
     * 清除资源，避免浪费
     */
    @Override
    protected void onStop() {
        super.onStop();
        //LogUtil.d3("");
        SimpleLogUtils.d("onStop");
    }

    /**
     * 引用会在ondestory时销毁，线程不会，在此处需要销毁开启的线程
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //LogUtil.d3("");
        SimpleLogUtils.d("onDestroy");
    }


    /**
     * 隐式启动Activity的匹配规则
     *
     * 1 隐式启动activity 主要通过action category date来进行隐式activity的启动，只有三者都通过了匹配才可以匹配成功
     *
     *
     * a action 的匹配规则
     *   1  一组intenfilter中可以包含多个action ,那么只要intent可以和intentfilter的一条action 完全匹配，action就可以完成匹配
     *
     * b category的匹配规则
     *  为了使Activity可以响应隐式匹配，必须在category中添加默认的 DEFAULT category,同样只要其中一条的category完成了匹配，就算匹配成功
     *
     * c data 的匹配规则
     *  1 data的组成部分：mimetype 和 URI  默认的mimetype为file或者content
     *
     *  2 必须和过滤规则中的一条进行匹配
     *
     *
     * 在真实的开发中，为了避免隐式启动的错误，可以通过intent的resolveActivity方法进行判断
     *
     *
     */


    public ComponentName resolveActivity(PackageManager pm,Intent intent) {

        ResolveInfo info = pm.resolveActivity(
                intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (info != null) {
            return new ComponentName(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name);
        }

        return null;
    }
}
