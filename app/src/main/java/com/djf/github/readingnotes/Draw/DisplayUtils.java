package com.djf.github.readingnotes.Draw;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Sky000 on 2018/6/20.
 * 开发中经常会遇到尺寸之间的转换，比如设计图中尺寸单位基本都是像素(px)，
 * 但是对于Android设备来说直接使用像素作为单位肯定是不行的。同样的10px，
 * 在分辨率很低的手机和分辨率很高的手机上显示的实际长度肯定是不一样的，
 * 所以Android团队才会采用dp作为Android开发尺寸单位，dp是一种相对单位
 * （根据屏幕的像素密度，也就是每英寸像素数的不同而调整），能够尽量保
 * 证相同数值的dp长度在不同的设备上显示的实际尺寸大致一样。同样的，sp
 * 是针对于文字的一种相对尺寸单位，其也会根据屏幕的像素密度的不同而调整，
 * 并考虑了字体不同的影响
 */

public class DisplayUtils {

    public static int px2dp(int px, Context context){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,context.getResources().getDisplayMetrics());
    }

    public static int px2sp(int px,Context context){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,px,context.getResources().getDisplayMetrics());
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
