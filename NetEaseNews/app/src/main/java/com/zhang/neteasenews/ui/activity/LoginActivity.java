package com.zhang.neteasenews.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhang.neteasenews.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/9/12.
 * 登陆界面的Activity
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView loginBack;
    private TextView qqLogin, enterTv;
    private EditText userEt, passwordEt;
    private boolean canChange;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginBack = byView(R.id.login_back);
        qqLogin = byView(R.id.login_qq);
        userEt = byView(R.id.login_user_et);
        passwordEt = byView(R.id.login_password_et);
        enterTv = byView(R.id.login_enter_tv);
    }

    @Override
    protected void initDatas() {
        canChange = false;
        loginBack.setOnClickListener(this);
        qqLogin.setOnClickListener(this);

        userEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = userEt.getText().toString();
                if (ss != null && !ss.isEmpty()) {
                    canChange = true;
                } else {
                    canChange = false;
                }
            }
        });

        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = passwordEt.getText().toString();
                if ( ss != null && !ss.isEmpty()) {
                    if (canChange) {
                        enterTv.setBackgroundColor(Color.RED);
                        enterTv.setTextColor(Color.WHITE);
                    }else {
                        canChange = false;
                    }
                } else {
                    enterTv.setBackgroundColor(Color.WHITE);
                    enterTv.setTextColor(Color.GRAY);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.login_qq:
                login();
                break;
        }
    }

    // QQ登陆
    private void login() {
        // 获取第三方平台
        Platform platform = ShareSDK.getPlatform(this, QQ.NAME);
        // 授权
        platform.authorize();
        // 获取用户信息
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Toast.makeText(LoginActivity.this, R.string.login_over, Toast.LENGTH_SHORT).show();
                // 获取QQ的头像和名字
                PlatformDb db = platform.getDb();
                String name = db.getUserName();
                String icon = db.getUserIcon();
//                Intent intent = new Intent();
//                intent.putExtra("icon", icon);
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Toast.makeText(LoginActivity.this, R.string.login_error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(LoginActivity.this, R.string.login_cancel, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
