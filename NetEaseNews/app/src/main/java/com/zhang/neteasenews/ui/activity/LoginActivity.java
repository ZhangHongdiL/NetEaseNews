package com.zhang.neteasenews.ui.activity;

import android.content.Intent;
import android.view.View;
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
    private TextView qqLogin;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginBack = byView(R.id.login_back);
        qqLogin = byView(R.id.login_qq);
    }

    @Override
    protected void initDatas() {
        loginBack.setOnClickListener(this);
        qqLogin.setOnClickListener(this);
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
                Toast.makeText(LoginActivity.this, "完成", Toast.LENGTH_SHORT).show();
                // 获取QQ的头像和名字
                PlatformDb db = platform.getDb();
                String name = db.getUserName();
                String icon = db.getUserIcon();
//                Intent intent = new Intent();
//                intent.putExtra("icon", icon);

            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(LoginActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
