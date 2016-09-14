package com.zhang.neteasenews.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.fragment.LiveFragment;
import com.zhang.neteasenews.ui.fragment.MeFragment;
import com.zhang.neteasenews.ui.fragment.NewsFragment;
import com.zhang.neteasenews.ui.fragment.TopicFragment;

/**
 * 主界面的Activity
 */
public class MainActivity extends AbsBaseActivity {

    private RadioGroup mainRg;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainRg = byView(R.id.main_rg);
    }

    @Override
    protected void initDatas() {
        // 为RadioGroup添加监听
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (checkedId) {
                    case R.id.main_news_rb:
                        ft.replace(R.id.main_fl, NewsFragment.newInstance());
                        break;
                    case R.id.main_live_rb:
                        ft.replace(R.id.main_fl, LiveFragment.newInstance());
                        break;
                    case R.id.main_topic_rb:
                        ft.replace(R.id.main_fl, TopicFragment.newInstance());
                        break;
                    case R.id.main_me_rb:
                        ft.replace(R.id.main_fl, MeFragment.newInstance());
                        break;
                }
                ft.commit();
            }
        });
        mainRg.check(R.id.main_news_rb);
    }


}
