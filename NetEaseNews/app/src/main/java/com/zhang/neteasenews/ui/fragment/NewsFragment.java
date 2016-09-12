package com.zhang.neteasenews.ui.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.adapter.NewsFragmentAdapter;
import com.zhang.neteasenews.ui.fragment.subfragment.NewsHeadlineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsFragment extends AbsBaseFragment {

    private ImageView searchImg, liveImg;
    private ImageView downBtn;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> titles;
    private List<Fragment> fragments;

    private NewsFragmentAdapter newsFragmentAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        searchImg = byView(R.id.fragment_news_img_search);
        liveImg = byView(R.id.fragment_news_img_live);
        downBtn = byView(R.id.fragment_news_popup_img);
        tabLayout = byView(R.id.fragment_news_tl);
        viewPager = byView(R.id.fragment_news_vp);

        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        newsFragmentAdapter = new NewsFragmentAdapter(getChildFragmentManager(), fragments);

        buildData();

        tabLayout.setTabTextColors(Color.parseColor("#a9b7b7"), Color.parseColor("#eb4f38"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#eb4f38"));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(newsFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void buildData() {
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(NewsHeadlineFragment.newInstance());

    }

    @Override
    protected void initDatas() {
        tabLayout.getTabAt(0).setText("头条");
        tabLayout.getTabAt(1).setText("精选");
        tabLayout.getTabAt(2).setText("娱乐");
        tabLayout.getTabAt(3).setText("体育");
        tabLayout.getTabAt(4).setText("视频");
        tabLayout.getTabAt(5).setText("财经");
        tabLayout.getTabAt(6).setText("科技");
        tabLayout.getTabAt(7).setText("汽车");
        tabLayout.getTabAt(8).setText("时尚");
        tabLayout.getTabAt(9).setText("图片");
        tabLayout.getTabAt(10).setText("热帖");
        tabLayout.getTabAt(11).setText("房产");
        tabLayout.getTabAt(12).setText("轻松一刻");
        tabLayout.getTabAt(13).setText("军事");
        tabLayout.getTabAt(14).setText("历史");
    }

}
