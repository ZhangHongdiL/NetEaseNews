package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.adapter.TopicTabLayoutAdapter;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.AskFragment;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.AttentionFragment;
import com.zhang.neteasenews.ui.fragment.topicsubfragment.ThemeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class TopicFragment extends AbsBaseFragment {

    private Context context;
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
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
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
    }

    @Override
    protected void initDatas() {
        topicTl.getTabAt(0).setText("问吧");
        topicTl.getTabAt(1).setText("话题");
        topicTl.getTabAt(2).setText("关注");
    }
}
