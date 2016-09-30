package com.zhang.neteasenews.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.secondactivity.SearchHotActivity;
import com.zhang.neteasenews.ui.adapter.NewsFragmentAdapter;
import com.zhang.neteasenews.ui.adapter.popupwindowadapter.NewsPwAdapter;
import com.zhang.neteasenews.ui.fragment.subfragment.AmusementFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.ChoicenessFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.CrossTalkFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.NewsHeadlineFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.PictureFragment;
import com.zhang.neteasenews.ui.fragment.subfragment.VideoFragment;
import com.zhang.neteasenews.utils.RecyclerViewItemClick;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面的Fragment
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView searchImg, liveImg;
    private ImageView downBtn;
    private RelativeLayout frament_news;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;

    private NewsFragmentAdapter newsFragmentAdapter;

    /**
     * popupwindow的相关
     */
    private RecyclerView recyclerView;
    private NewsPwAdapter newsPwAdapter;
    private List<String> list;
    private ImageView pwIv;

    private View view;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
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
        frament_news = byView(R.id.fragment_news);
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
        liveImg.setOnClickListener(this);
        searchImg.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_news_popup_img:
                setPopupwindow(); // 设置popupWindow的方法
                break;
            case R.id.fragment_news_img_live:
//                Intent intent = new Intent(NewsFragment.this, LiveFragment.class);
                break;
            case R.id.fragment_news_img_search:
                goTo(SearchHotActivity.class);
                break;
        }
    }

    private void setPopupwindow() {
        final PopupWindow pw = new PopupWindow(context);
        // 获得屏幕的宽高
        int width = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH);
        int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
        pw.setWidth(width);
        pw.setHeight(height);
        view = LayoutInflater.from(context).inflate(R.layout.fragment_news_popupwindow, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.popupwindow_rv);
        pwIv = (ImageView) view.findViewById(R.id.fragment_news_pw_iv);
        pwIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAsDropDown(frament_news);

        // 设置适配器
        newsPwAdapter = new NewsPwAdapter(context);
        recyclerView.setAdapter(newsPwAdapter);
        // 设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        // 构造数据
        list = new ArrayList<>();
        for (int i = 0; i < fragments.size(); i++) {
            list.add((getResources().getStringArray(R.array.titles))[i]);
        }
        newsPwAdapter.setDatas(list);
        newsPwAdapter.setCurrent(viewPager.getCurrentItem());
        pwIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
        newsPwAdapter.setPopupRecyclerItemClick(new RecyclerViewItemClick() {
            @Override
            public void onRvItemClickListener(int position, Object o) {
                tabLayout.setScrollPosition(position,0,false);
                viewPager.setCurrentItem(position);
                newsPwAdapter.setCurrent(position);
                pw.dismiss();
            }
        });
//        int po = viewPager.getCurrentItem();
//        tabLayout.setTabTextColors(Color.parseColor("#a9b7b7"), Color.parseColor("#eb4f38"));
//        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#eb4f38"));
//        newsPwAdapter.setCurrent(po);
    }

    private void setData() {
        /**
         * get到的是array数组!!!!!
         */
        for (int i = 0; i < fragments.size(); i++) {
            tabLayout.getTabAt(i).setText((getResources().getStringArray(R.array.titles))[i] + "");
        }
    }

    private void buildData() {
        fragments.add(NewsHeadlineFragment.newInstance());
        fragments.add(ChoicenessFragment.newInstance());
        fragments.add(AmusementFragment.newInstance());
        fragments.add(CrossTalkFragment.newInstance());
        fragments.add(PictureFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
    }
}
