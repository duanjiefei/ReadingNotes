package com.djf.github.readingnotes.View;

import android.os.Bundle;
import android.widget.Toast;

import com.djf.github.readingnotes.BaseActivity;
import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/7.
 */

public class CustomTextViewActivity extends BaseActivity {

    private TopBarView topBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customtextview_layout);
        topBarView = findViewById(R.id.topview);
        topBarView.setTopBarListener(new TopBarView.TopBarListener() {
            @Override
            public void leftOnclick() {
                Toast.makeText(CustomTextViewActivity.this,
                        "left", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void rightOnclick() {
                Toast.makeText(CustomTextViewActivity.this,
                        "right", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
