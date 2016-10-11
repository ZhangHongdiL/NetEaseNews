package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.MeListViewEntity;
import com.zhang.neteasenews.ui.activity.HelpAndFBActivity;
import com.zhang.neteasenews.ui.activity.LoginActivity;
import com.zhang.neteasenews.ui.activity.SetActivity;
import com.zhang.neteasenews.ui.activity.secondactivity.CollectionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 个人界面的Fragment
 */
public class MeFragment extends AbsBaseFragment implements View.OnClickListener {

    private LinearLayout set;
    private TextView loginTv, offTv;
    private Button readBtn, collectBtn, replyBtn, goldBtn;
    private RelativeLayout opinionRl, offRl, myMsg, dynamic;
    private boolean offState = false;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews() {
        loginTv = byView(R.id.fragment_me_login);
        offTv = byView(R.id.item_fra_me_off_line_tv);
        set = byView(R.id.fragment_me_set);
        readBtn = byView(R.id.fragment_me_read);
        collectBtn = byView(R.id.fragment_me_collect);
        replyBtn = byView(R.id.fragment_me_reply);
        goldBtn = byView(R.id.fragment_me_gold);

        opinionRl = byView(R.id.item_fra_me_opinion);
        offRl = byView(R.id.item_fra_me_off_line);
        myMsg = byView(R.id.item_fra_me_mymsg);
        dynamic = byView(R.id.item_fra_me_dynamic);
    }

    @Override
    protected void initDatas() {
        loginTv.setOnClickListener(this);
        collectBtn.setOnClickListener(this);
        set.setOnClickListener(this);

        opinionRl.setOnClickListener(this);
        offRl.setOnClickListener(this);
        dynamic.setOnClickListener(this);
        myMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_me_login:
                goTo(LoginActivity.class); // 登陆的点击事件
                break;
            case R.id.fragment_me_collect: // 收藏的点击事件
                goTo(CollectionActivity.class);
                break;
            case R.id.fragment_me_set:  // 设置的点击事件
                goTo(SetActivity.class);
                break;

            case R.id.item_fra_me_opinion: // 意见反馈行的跳转
                goTo(HelpAndFBActivity.class);
                break;
            case R.id.item_fra_me_off_line: // 离线阅读的跳转
                if (offState == false) {
                    Toast.makeText(context, R.string.off_read_toast, Toast.LENGTH_SHORT).show();
                    offTv.setText(R.string.off_read);
                    offState = true;
                } else if (offState == true){
                    Toast.makeText(context, R.string.off_read_stop_toast, Toast.LENGTH_SHORT).show();
                    offTv.setText(R.string.off_read_begin);
                    offState = false;
                }

                break;
            case R.id.item_fra_me_dynamic: // 最新动态的点击
                Toast.makeText(context, R.string.dynamic, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_fra_me_mymsg: // 我的消息的点击
                Toast.makeText(context, R.string.my_msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
