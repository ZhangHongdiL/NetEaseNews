package com.zhang.neteasenews.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.fragment.LiveFragment;
import com.zhang.neteasenews.ui.fragment.MeFragment;
import com.zhang.neteasenews.ui.fragment.NewsFragment;
import com.zhang.neteasenews.ui.fragment.TopicFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsBaseActivity {

    private RadioGroup mainRg;

    private List<Fragment> fragments;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainRg = byView(R.id.main_rg);
        fragments = new ArrayList<>();
    }

    @Override
    protected void initDatas() {
        // 添加Fragment
        fragments.add(new NewsFragment());
        fragments.add(new LiveFragment());
        fragments.add(new TopicFragment());
        fragments.add(new MeFragment());
        // 为RadioGroup添加监听
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (checkedId) {
                    case R.id.main_news_rb:
                        ft.replace(R.id.main_fl, new NewsFragment());
                        break;
                    case R.id.main_live_rb:
                        ft.replace(R.id.main_fl, new LiveFragment());
                        break;
                    case R.id.main_topic_rb:
                        ft.replace(R.id.main_fl, new TopicFragment());
                        break;
                    case R.id.main_me_rb:
                        ft.replace(R.id.main_fl, new MeFragment());
                        break;
                }
                ft.commit();
            }
        });
    }


}
