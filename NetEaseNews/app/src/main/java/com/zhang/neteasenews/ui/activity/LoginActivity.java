package com.zhang.neteasenews.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.zhang.neteasenews.R;

/**
 * Created by dllo on 16/9/12.
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView loginBack;
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginBack = byView(R.id.login_back);
    }

    @Override
    protected void initDatas() {
        loginBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                finish();
                break;
        }
    }
}
