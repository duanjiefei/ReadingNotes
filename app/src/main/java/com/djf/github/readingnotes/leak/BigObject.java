package com.djf.github.readingnotes.leak;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Sky000 on 2018/6/28.
 */

public class BigObject {
    private ArrayList<Bitmap> bitmaps = new ArrayList<>();
    private String[] strings = new String[10000];
    public BigObject() {
        for(int i = 0;i<200;i++){
            bitmaps.add(Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888));
        }

        for (int i = 0;i<10000;i++){
            strings[i] = "string"+i;
        }
    }
}
