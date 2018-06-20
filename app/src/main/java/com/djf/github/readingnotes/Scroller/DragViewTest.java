package com.djf.github.readingnotes.Scroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/15.
 */

public class DragViewTest  extends Activity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dragview_test);
        button = findViewById(R.id.dragViewGroup);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent  = new Intent();
        switch (v.getId()){
            case R.id.dragViewGroup:
                intent.setClassName("com.djf.github.readingnotes","com.djf.github.readingnotes.Scroller.DragViewGroupTest");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
