package com.zhang.neteasenews.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/10.
 */
public class NetEaseNewsApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }


}
