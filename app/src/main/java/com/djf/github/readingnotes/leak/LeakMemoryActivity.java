package com.djf.github.readingnotes.leak;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/28.
 */

public class LeakMemoryActivity extends Activity implements SampleListener{

    private BigObject object = new BigObject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);

        ListenerManager.getInstance().addListener(this);
        Log.d("MemoryLeakActivity","onCreat size:"+ListenerManager.getInstance().getListenerSize());
    }

    @Override
    public void doSomething() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int size = ListenerManager.getInstance().getListenerSize();
        Log.d("MemoryLeakActivity","size:"+size);
        //TODO 修复内存泄漏方法
        //ListenerManager.getInstance().removeListener(this);
    }
}
