package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.adapter.NewsFragmentAdapter;
import com.zhang.neteasenews.ui.fragment.subfragment.ChoicenessFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.NewsHeadlineFragment;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面的Fragment
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {

    private Context context;
    private ImageView searchImg, liveImg;
    private ImageView downBtn;
    private RelativeLayout frament_news;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;

    private NewsFragmentAdapter newsFragmentAdapter;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
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
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        searchImg = byView(R.id.fragment_news_img_search);
        liveImg = byView(R.id.fragment_news_img_live);
        downBtn = byView(R.id.fragment_news_popup_img);
        tabLayout = byView(R.id.fragment_news_tl);
        viewPager = byView(R.id.fragment_news_vp);

    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        newsFragmentAdapter = new NewsFragmentAdapter(getFragmentManager(), fragments);
        buildData();
        tabLayout.setTabTextColors(Color.parseColor("#a9b7b7"), Color.parseColor("#eb4f38"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#eb4f38"));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(newsFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setData();

        downBtn.setOnClickListener(this);
    }

    private void setData() {
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

    private void buildData() {
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(ChoicenessFragment.newInstance());
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_news_popup_img:
                setPopupwindow(); // 设置popupWindow的方法
                break;
        }
    }

    private void setPopupwindow() {
        PopupWindow pw = new PopupWindow(context);
        // 获得屏幕的宽高
        int width = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH);
        int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
        pw.setWidth(width);
        pw.setHeight(height);

        pw.setFocusable(true);
        pw.showAsDropDown(frament_news);
    }
}
