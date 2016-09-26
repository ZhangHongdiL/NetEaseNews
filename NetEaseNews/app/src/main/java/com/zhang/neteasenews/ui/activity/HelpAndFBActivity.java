package com.zhang.neteasenews.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhang.neteasenews.R;

/**
 * Created by dllo on 16/9/26.
 * 帮助和反馈界面
 */
public class HelpAndFBActivity extends AbsBaseActivity implements View.OnClickListener {

    private Button feedbackBtn, netBtn;
    private ImageView back;

    @Override
    protected int setLayout() {
        return R.layout.activity_helpandfb;
    }

    @Override
    protected void initViews() {
        back = byView(R.id.act_help_back);
        feedbackBtn = byView(R.id.act_help_feedback);
        netBtn = byView(R.id.act_help_net);
    }

    @Override
    protected void initDatas() {
        back.setOnClickListener(this);
        feedbackBtn.setOnClickListener(this);
        netBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_help_back:
                finish();
                break;
            case R.id.act_help_feedback:
                break;
            case R.id.act_help_net:
                break;
        }
    }
}
