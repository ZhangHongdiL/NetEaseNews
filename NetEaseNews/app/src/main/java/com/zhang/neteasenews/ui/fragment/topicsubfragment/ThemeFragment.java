package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeEntity;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeHeadEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.ThemeAdapter;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.ThemeHeadAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面话题的Fragment
 */
public class ThemeFragment extends AbsBaseFragment implements VolleyResult {
    private List<ThemeEntity.DataBean> dataBeen;
    private PullDownListView listView;
    private ThemeAdapter themeAdapter;

    /**
     * 头布局
     */
    private ThemeHeadAdapter themeHeadAdapter;
    private RecyclerView headRv;
    private List<ThemeHeadEntity.话题Bean> been;
    private View view;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic_theme;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_topic_theme_lv);
    }

    @Override
    protected void initDatas() {
        dataBeen = new ArrayList<>();
        themeAdapter = new ThemeAdapter(context);
        listView.setAdapter(themeAdapter);
        view = LayoutInflater.from(context).inflate(R.layout.head_theme, null);
        headRv = (RecyclerView) view.findViewById(R.id.head_theme_rv);

//        been = new ArrayList<>();
        themeHeadAdapter = new ThemeHeadAdapter(context);
        headRv.setAdapter(themeHeadAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        headRv.setLayoutManager(manager);
        VolleyInstance.getInstance().startRequest(Values.THEMEHEADURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                Log.d("bbbb", resultStr);
                ThemeHeadEntity themeHeadEntity = gson.fromJson(resultStr, ThemeHeadEntity.class);
                been = themeHeadEntity.get话题();
                themeHeadAdapter.setDatas(been);
                listView.addHeaderView(view);
            }

            @Override
            public void failure() {

            }
        });

        VolleyInstance.getInstance().startRequest(Values.THEMEURL, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("ThemeFragment", );
        Gson gson = new Gson();
        ThemeEntity themeEntity = gson.fromJson(resultStr, ThemeEntity.class);
        ThemeEntity.DataBean dataBean = themeEntity.getData();
        themeAdapter.setDatas(dataBean);

        listView.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                            VolleyInstance.getInstance().startRequest(Values.THEMEURL, new VolleyResult() {
                                @Override
                                public void success(String resultStr) {
                                    Gson gson = new Gson();
                                    ThemeEntity themeEntity = gson.fromJson(resultStr, ThemeEntity.class);
                                    ThemeEntity.DataBean dataBean = themeEntity.getData();
                                    themeAdapter.setDatas(dataBean);
                                }

                                @Override
                                public void failure() {
                                    Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        themeAdapter.notifyDataSetChanged();
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
