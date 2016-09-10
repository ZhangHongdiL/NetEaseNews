package com.zhang.neteasenews.ui.fragment;

import android.widget.Button;
import android.widget.TextView;

import com.zhang.neteasenews.R;

/**
 * Created by dllo on 16/9/10.
 */
public class MeFragment extends AbsBaseFragment {

    private TextView loginTv, setTv;
    private Button readBtn, collectBtn, replyBtn, goldBtn;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews() {
        loginTv = byView(R.id.fragment_me_login);
        setTv = byView(R.id.fragment_me_set);
        readBtn = byView(R.id.fragment_me_read);
        collectBtn = byView(R.id.fragment_me_collect);
        replyBtn = byView(R.id.fragment_me_reply);
        goldBtn = byView(R.id.fragment_me_gold);
    }

    @Override
    protected void initDatas() {

    }
}
