package com.djf.github.readingnotes.Draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.djf.github.readingnotes.R;

/**
 * Created by Sky000 on 2018/6/22.
 */

public class MatrixActivity extends Activity {

    private ImageView imageView;
    private GridLayout gridView;
    private EditText[] mEts = new EditText[20];
    private int mEtWidth,mEtHeight;
    private float[] mColorMatrix = new float[20];
    private Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_matrix);
        imageView = findViewById(R.id.imageview);
        gridView = findViewById(R.id.group);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test1);
        imageView.setImageBitmap(bitmap);
        gridView.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = gridView.getWidth()/5;
                mEtHeight = gridView.getHeight()/4;
                addEts();
                initMatrix();
            }
        });
    }

    private void addEts() {
        for (int i=0;i<20;i++){
            EditText editText = new EditText(MatrixActivity.this);
            mEts[i] = editText;
            gridView.addView(editText,mEtWidth,mEtHeight);
        }
    }

    // 获取矩阵值
    private void getMatrix() {
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.valueOf(
                    mEts[i].getText().toString());
        }
    }

    // 将矩阵值设置到图像
    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(
                bitmap.getWidth(),
                bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        android.graphics.ColorMatrix colorMatrix =
                new android.graphics.ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        imageView.setImageBitmap(bmp);
    }

    // 作用矩阵效果
    public void btnChange(View view) {
        getMatrix();
        setImageMatrix();
    }

    // 重置矩阵效果
    public void btnReset(View view) {
        initMatrix();
        getMatrix();
        setImageMatrix();
    }

    // 初始化颜色矩阵为初始状态
    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mEts[i].setText(String.valueOf(1));
            } else {
                mEts[i].setText(String.valueOf(0));
            }
        }
    }
}
