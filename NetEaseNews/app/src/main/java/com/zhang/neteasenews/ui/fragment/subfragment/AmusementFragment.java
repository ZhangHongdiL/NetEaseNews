package com.zhang.neteasenews.ui.fragment.subfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.AmusementEntity;
import com.zhang.neteasenews.model.entity.subentity.ChoicenessEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.secondactivity.NewsDetailActivity;
import com.zhang.neteasenews.ui.activity.secondactivity.NewsDetailVPActivity;
import com.zhang.neteasenews.ui.adapter.subadapter.AmusementAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.OnRefreshListener;
import com.zhang.neteasenews.view.PullDownListView;
import com.zhang.neteasenews.view.RefreshListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/22.
 * 新闻界面娱乐页
 */
public class AmusementFragment extends AbsBaseFragment implements VolleyResult, OnRefreshListener {

    private int i;
    private AmusementAdapter amusementAdapter;
    private List<AmusementEntity.T1348648517839Bean> datas;
    private List<AmusementEntity.T1348648517839Bean> list;

    /**
     * 下拉刷新
     */
    private RefreshListView lv;

    public static AmusementFragment newInstance() {

        Bundle args = new Bundle();

        AmusementFragment fragment = new AmusementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_headline;
    }

    @Override
    protected void initViews() {
        lv = byView(R.id.fragment_news_headline_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        amusementAdapter = new AmusementAdapter(context);
        lv.setOnRefreshListener(this);
        lv.setAdapter(amusementAdapter);
        VolleyInstance.getInstance().startRequest(Values.AMUSEMENTURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        AmusementEntity amusementEntity = gson.fromJson(resultStr, AmusementEntity.class);
        datas = amusementEntity.getT1348648517839();
        amusementAdapter.setDatas(datas);
//        lv.setonRefreshListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = datas.get(position - 1).getPostid();
                if (str.startsWith("P")) {  // 轮播图, 三张图片的行布局
                    Intent intent = new Intent(context, NewsDetailVPActivity.class);
                    intent.putExtra("skipId", datas.get(position - 1).getSkipID());
                    startActivity(intent);
                } else if (str.startsWith("C")) {  // 一张图片的行布局
                    Intent intent = new Intent(context, NewsDetailActivity.class);
                    intent.putExtra("url", datas.get(position).getUrl_3w());
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "无详情", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void failure() {

    }

//    @Override
//    public void onRefresh() {
//
//    }


    @Override
    public void onDownPullRefresh() {
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                VolleyInstance.getInstance().startRequest(Values.AMUSEMENTURL, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Gson gson = new Gson();
                        AmusementEntity amusementEntity = gson.fromJson(resultStr, AmusementEntity.class);
                        datas = amusementEntity.getT1348648517839();
                        amusementAdapter.setDatas(datas);
                    }

                    @Override
                    public void failure() {
                        Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                amusementAdapter.notifyDataSetChanged();
                lv.hideHeaderView();
            }
        }.execute(null, null, null);
    }

    /**
     * 上拉加载数据
     */
    @Override
    public void onLoadingMore() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                SystemClock.sleep(2000);
                String CHOSENURL_LEFT = "http://c.m.163.com/nc/article/list/T1348648517839/";
                String RIGHT = ".html";
                VolleyInstance.getInstance().startRequest(CHOSENURL_LEFT + i + "-20" + RIGHT, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Gson gson = new Gson();
                        AmusementEntity entity = gson.fromJson(resultStr, AmusementEntity.class);
                        i = i + 20;
                        list = entity.getT1348648517839();
                        datas.addAll(list);
                        datas.remove(0);
                        amusementAdapter.setDatas(datas);

                    }

                    @Override
                    public void failure() {

                    }
                });

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                amusementAdapter.notifyDataSetChanged();
                lv.hideFooterView();
            }
        }.execute(new Void[]{});
    }
}
