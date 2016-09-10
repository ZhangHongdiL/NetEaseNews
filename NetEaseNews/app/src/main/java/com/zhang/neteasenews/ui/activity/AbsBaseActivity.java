package com.zhang.neteasenews.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhang.neteasenews.R;

/**
 * Created by dllo on 16/9/10.
 */
public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 订制流程
        setContentView(setLayout());
        // 初始化组件
        initViews();
        // 初始化数据
        initDatas();
    }

    /**
     * 设置布局文件
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 简化findViewById
     */
    protected <T extends View> T byView(int resId) {
        return (T)findViewById(resId);
    }

    /**
     * 简单的界面跳转
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to) {
        startActivity(new Intent(from, to));
        overridePendingTransition(R.anim.act_fra_translate, 0);
    }

    /**
     * 带值跳转
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        startActivity(intent);
        overridePendingTransition(R.anim.act_fra_translate, 0);
    }
}
