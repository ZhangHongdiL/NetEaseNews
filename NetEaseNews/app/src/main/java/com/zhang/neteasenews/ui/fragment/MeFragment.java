package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.MeListViewEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class MeFragment extends AbsBaseFragment {

    private Context context;
    private LinearLayout set;
    private TextView loginTv;
    private Button readBtn, collectBtn, replyBtn, goldBtn;

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

    }
}
