package com.zhang.neteasenews.ui.app;

import android.app.Application;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by dllo on 16/9/10.
 * 应用程序类
 */
public class NetEaseNewsApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ShareSDK.initSDK(context);
    }

    public static Context getContext(){
        return context;
    }


}
