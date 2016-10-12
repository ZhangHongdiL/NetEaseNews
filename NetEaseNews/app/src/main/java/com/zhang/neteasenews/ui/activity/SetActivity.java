package com.zhang.neteasenews.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.zhang.neteasenews.R;

/**
 * 设置界面的Activity
 */
public class SetActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView backIv;

    @Override
    protected int setLayout() {
        return R.layout.activity_set;
    }

    @Override
    protected void initViews() {
        backIv = byView(R.id.act_help_back);
    }

    @Override
    protected void initDatas() {
        backIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_help_back:
                finish();
                break;
        }
    }
}
