package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.LoginActivity;
import com.zhang.neteasenews.ui.adapter.TopicTabLayoutAdapter;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.AskFragment;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.AttentionFragment;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.ThemeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面的Fragment
 */
public class TopicFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView topicPerson, topicSearch;
    private TabLayout topicTl;
    private ViewPager topicVp;
    private TopicTabLayoutAdapter topicTabLayoutAdapter;

    private List<String> titles;
    private List<Fragment> fragments;

    public static TopicFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TopicFragment fragment = new TopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initViews() {
        topicSearch = byView(R.id.fragment_topic_search);
        topicPerson = byView(R.id.fragment_topic_person);
        topicTl = byView(R.id.fragment_topic_tl);
        topicVp = byView(R.id.fragment_topic_vp);


    }

    @Override
    protected void initDatas() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        topicTabLayoutAdapter = new TopicTabLayoutAdapter(getChildFragmentManager(), fragments);

        fragments.add(new AskFragment());
        fragments.add(new ThemeFragment());
        fragments.add(new AttentionFragment());
        topicTl.setSelectedTabIndicatorColor(Color.WHITE);
        topicTl.setTabTextColors(Color.GRAY, Color.WHITE);
        topicVp.setAdapter(topicTabLayoutAdapter);
        topicTl.setupWithViewPager(topicVp);
        topicTl.getTabAt(0).setText("问吧");
        topicTl.getTabAt(1).setText("话题");
        topicTl.getTabAt(2).setText("关注");

        setListener();
    }

    private void setListener() {
        topicPerson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_topic_person:
                goTo(LoginActivity.class);
                break;
        }
    }
}
