package com.djf.github.readingnotes.Draw;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/20.
 */

public class DrawActivity extends Activity {
    private TextView density;
    private TextView scaledDensity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_layout);
        density = findViewById(R.id.density);
        scaledDensity = findViewById(R.id.scaledDensity);
        initView();
    }

    private void initView() {
       final float scale1 =  getResources().getDisplayMetrics().density;
        final float scale2 = getResources().getDisplayMetrics().scaledDensity;
        density.setText(getResources().getDisplayMetrics().toString());
        //scaledDensity.setText(String.valueOf(scale2));
    }
}