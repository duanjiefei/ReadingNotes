package com.djf.github.readingnotes.Draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/22.
 */

public class PixelsEffectActivity extends Activity{
    private ImageView imageView01,imageView02,imageView03,imageView04;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pixels_effect);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        imageView01 = (ImageView) findViewById(R.id.imageview1);
        imageView02 = (ImageView) findViewById(R.id.imageview2);
        imageView03 = (ImageView) findViewById(R.id.imageview3);
        imageView04 = (ImageView) findViewById(R.id.imageview4);

        imageView01.setImageBitmap(bitmap);
        imageView02.setImageBitmap(ImageHelper.handleImageNegative(bitmap));
        imageView03.setImageBitmap(ImageHelper.handleImagePixelsOldPhoto(bitmap));
        imageView04.setImageBitmap(ImageHelper.handleImagePixelsRelief(bitmap));
    }
}
