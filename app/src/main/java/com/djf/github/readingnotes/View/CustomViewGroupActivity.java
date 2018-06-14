package com.djf.github.readingnotes.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/14.
 */

public class CustomViewGroupActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_groupview);
    }
}
