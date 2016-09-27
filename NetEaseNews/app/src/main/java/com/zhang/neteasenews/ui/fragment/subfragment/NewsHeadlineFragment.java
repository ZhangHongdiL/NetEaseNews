package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.HeadlineEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.NewsHeadlineAdapter;
import com.zhang.neteasenews.ui.adapter.subadapter.RotateAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻头条的Fragment
 */
public class NewsHeadlineFragment extends AbsBaseFragment implements VolleyResult {

    private NewsHeadlineAdapter newsHeadlineAdapter;
    private List<HeadlineEntity.T1348647909107Bean> datas;
    private PullDownListView listView;

    /**
     * 头布局轮播图
     */
    private List<HeadlineEntity.T1348647909107Bean.AdsBean> adsBeen;
    private ViewPager viewPager;
    private LinearLayout pointLl;// 轮播状态改变的小圆点容器
    private RotateAdapter rotateAdapter;

    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;
    private View head;

    public static NewsHeadlineFragment newInstance() {
        /**
         * 在Fragment复用时在方法里添加url
         */
        Bundle args = new Bundle();
        NewsHeadlineFragment fragment = new NewsHeadlineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_headline;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_news_headline_lv);
        head = LayoutInflater.from(context).inflate(R.layout.fragment_news_rotate,null);
        viewPager = (ViewPager) head.findViewById(R.id.rotate_vp);
        pointLl = (LinearLayout) head.findViewById(R.id.rotate_point_container);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        adsBeen = new ArrayList<>();
        newsHeadlineAdapter = new NewsHeadlineAdapter(context);
        listView.setAdapter(newsHeadlineAdapter);
        //=========
        listView.addHeaderView(head);
        VolleyInstance.getInstance().startRequest(Values.HEADLINEURL, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("NewsHeadlineFragment", resultStr);
        Gson gson = new Gson();
        HeadlineEntity headlineEntity = gson.fromJson(resultStr, HeadlineEntity.class);
        List<HeadlineEntity.T1348647909107Bean> tb = headlineEntity.getT1348647909107();
        adsBeen =tb.get(0).getAds();
        datas = headlineEntity.getT1348647909107();
        newsHeadlineAdapter.setDatas(datas);
        //=====================
        rotateAdapter = new RotateAdapter(adsBeen, context);
        viewPager.setAdapter(rotateAdapter);
        // ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
        // 为了保证第一页始终为数据的第0条 取余要为0,因此设置数据集合大小的倍数
        viewPager.setCurrentItem(adsBeen.size() * 100);

        // 开始轮播
        handler = new Handler();
        startRotate();
        // 添加轮播小点
        addPoints();
        // 随着轮播改变小点
        changePoints();

        listView.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        newsHeadlineAdapter.notifyDataSetChanged();
                        listView.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
    }
    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    // 把所有小点设置为白色
                    for (int i = 0; i < adsBeen.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    // 设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointLl.getChildAt(position % adsBeen.size());
                    iv.setImageResource(R.mipmap.point_black);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播切换小点
     */
    private void addPoints() {
        // 有多少张图加载多少个小点
        for (int i = 0; i < adsBeen.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            pointIv.setLayoutParams(params);

            // 设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.point_black);
            } else {
                pointIv.setImageResource(R.mipmap.point_white);
            }
            pointLl.addView(pointIv);
        }
    }

    @Override
    public void failure() {


    }

    /**
     * 开始轮播
     */
    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, Values.TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, Values.TIME);
    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

}
