package com.zhang.neteasenews.ui.activity;

import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

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
    private long exitTime = 0; // 定义退出时长

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

    /**
     * 点击两次返回键退出应用
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), R.string.out_app, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
