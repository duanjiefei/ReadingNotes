package com.djf.github.readingnotes.leak;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

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
    }

    @Override
    public void doSomething() {

    }
}
