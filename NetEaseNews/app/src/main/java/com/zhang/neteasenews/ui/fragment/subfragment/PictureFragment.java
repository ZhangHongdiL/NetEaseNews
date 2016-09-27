package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.PictureEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.PictureAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻的图片界面
 */
public class PictureFragment extends AbsBaseFragment implements VolleyResult {

    private PullDownListView listView;
    private PictureAdapter pictureAdapter;
    private List<PictureEntity> datas;

    public static PictureFragment newInstance() {

        Bundle args = new Bundle();

        PictureFragment fragment = new PictureFragment();
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
        pictureAdapter = new PictureAdapter(context);
        listView.setAdapter(pictureAdapter);
        VolleyInstance.getInstance().startRequest(Values.PICTUREURL, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("xxxx", resultStr);
        /**
         * 最外层为Array[]的数据类型解析
         */
        Gson gson = new Gson();
        Type type = new TypeToken<List<PictureEntity>>(){}.getType();
        datas = gson.fromJson(resultStr, type);
//        for (int i = 0; i < pictureEntities.size(); i++) {
//            Log.d("zzz", pictureEntities.get(i).getSetname());
//        }
        pictureAdapter.setDatas(datas);

        listView.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                            VolleyInstance.getInstance().startRequest(Values.PICTUREURL, new VolleyResult() {
                                @Override
                                public void success(String resultStr) {
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<PictureEntity>>(){}.getType();
                                    datas = gson.fromJson(resultStr, type);
                                    pictureAdapter.setDatas(datas);
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
                        pictureAdapter.notifyDataSetChanged();
                        listView.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
    }

    @Override
    public void failure() {

    }
}
