package com.zhang.neteasenews.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dllo on 16/9/13.
 */
public class ScreenSizeUtils {

    public enum ScreenState {
        WIDTH, HEIGHT;
    }

    public static int getScreenSize(Context context, ScreenState state) {
        // 获取窗口管理类
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将窗口(屏幕)的尺寸设置给 显示尺寸的类
        manager.getDefaultDisplay().getMetrics(metrics);
        switch (state) {
            case WIDTH:
                return metrics.widthPixels;
            case HEIGHT:
                return metrics.heightPixels;
            default:
                return metrics.heightPixels;
        }
    }
}
