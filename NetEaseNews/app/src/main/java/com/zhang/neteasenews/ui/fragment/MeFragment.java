package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.MeListViewEntity;
import com.zhang.neteasenews.ui.activity.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 个人界面的Fragment
 */
public class MeFragment extends AbsBaseFragment implements View.OnClickListener {

    private Context context;
    private LinearLayout set;
    private TextView loginTv;
    private Button readBtn, collectBtn, replyBtn, goldBtn;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews() {
        loginTv = byView(R.id.fragment_me_login);
        set = byView(R.id.fragment_me_set);
        readBtn = byView(R.id.fragment_me_read);
        collectBtn = byView(R.id.fragment_me_collect);
        replyBtn = byView(R.id.fragment_me_reply);
        goldBtn = byView(R.id.fragment_me_gold);
    }

    @Override
    protected void initDatas() {
        loginTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_me_login:
                goTo(LoginActivity.class);
                break;
        }
    }
}
