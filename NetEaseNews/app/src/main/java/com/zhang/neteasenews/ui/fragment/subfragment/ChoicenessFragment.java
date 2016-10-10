package com.zhang.neteasenews.ui.fragment.subfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.ChoicenessEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.secondactivity.NewsDetailActivity;
import com.zhang.neteasenews.ui.activity.secondactivity.NewsDetailVPActivity;
import com.zhang.neteasenews.ui.adapter.subadapter.ChoicenessAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.OnRefreshListener;
import com.zhang.neteasenews.view.PullDownListView;
import com.zhang.neteasenews.view.RefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻界面精选页
 */
public class ChoicenessFragment extends AbsBaseFragment implements VolleyResult, OnRefreshListener {

    private int i= 20;
    private RefreshListView listView;
    private ChoicenessAdapter choicenessAdapter;
    private List<ChoicenessEntity.T1467284926140Bean> datas;
    private List<ChoicenessEntity.T1467284926140Bean> list;
    private View headView;
    private ImageView headImg;
    private TextView headTv;

    public static ChoicenessFragment newInstance() {

        Bundle args = new Bundle();

        ChoicenessFragment fragment = new ChoicenessFragment();
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
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        choicenessAdapter = new ChoicenessAdapter(context);
        listView.setOnRefreshListener(this);
        listView.setAdapter(choicenessAdapter);

        VolleyInstance.getInstance().startRequest(Values.CHOICENESSURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ChoicenessEntity choicenessEntity = gson.fromJson(resultStr, ChoicenessEntity.class);
        datas = choicenessEntity.getT1467284926140();

//        headView = LayoutInflater.from(context).inflate(R.layout.choiceness_head, null);
//        headImg = (ImageView) headView.findViewById(R.id.choiceness_head_iv);
//        headTv = (TextView) headView.findViewById(R.id.choiceness_head_tv);
//        headTv.setText(datas.get(0).getTitle());
//        Glide.with(context).load(datas.get(0).getImgsrc()).override(ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH),
//                ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT) / 3)
//                .error(R.mipmap.netease_big)
//                .into(headImg);
//
//        listView.addHeaderView(headView);

        choicenessAdapter.setDatas(datas);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = datas.get(position).getPostid();
                if (str.startsWith("P")) {// 轮播图, 三张图片的行布局
                    Intent intent = new Intent(context, NewsDetailVPActivity.class);
                    intent.putExtra("skipId", datas.get(position).getSkipID());
                    startActivity(intent);

                }  else if (str.startsWith("C")) {  // 正常布局
                    Intent intent = new Intent(context, NewsDetailActivity.class);
                    intent.putExtra("url", datas.get(position).getUrl_3w());
                    startActivity(intent);

                } else {
//                    throw null;
                }
            }
        });
    }

    @Override
    public void failure() {

    }

    @Override
    public void onDownPullRefresh() {
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                    VolleyInstance.getInstance().startRequest(Values.CHOICENESSURL, new VolleyResult() {
                        @Override
                        public void success(String resultStr) {
                            Gson gson = new Gson();
                            ChoicenessEntity choicenessEntity = gson.fromJson(resultStr, ChoicenessEntity.class);
                            datas = choicenessEntity.getT1467284926140();
                            datas.remove(0);
                            choicenessAdapter.setDatas(datas);
                        }

                        @Override
                        public void failure() {
                            Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                choicenessAdapter.notifyDataSetChanged();
                listView.hideHeaderView();
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
                String CHOSENURL_LEFT = "http://c.m.163.com/nc/article/list/T1467284926140/";
                String RIGHT = ".html";
                VolleyInstance.getInstance().startRequest(CHOSENURL_LEFT + i + "-20" + RIGHT, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Gson gson = new Gson();
                        ChoicenessEntity entity = gson.fromJson(resultStr, ChoicenessEntity.class);
                        i = i + 20;
                        list = entity.getT1467284926140();
                        datas.addAll(list);
                        choicenessAdapter.setDatas(datas);

                    }

                    @Override
                    public void failure() {

                    }
                });

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                choicenessAdapter.notifyDataSetChanged();
                listView.hideFooterView();
            }
        }.execute(new Void[]{});
    }
}
