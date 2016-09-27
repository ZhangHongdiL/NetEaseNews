package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.AskEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.AskAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面问吧的Fragment
 */
public class AskFragment extends AbsBaseFragment implements VolleyResult {

    private PullDownListView askLv;
    private List<AskEntity.DataBean.ExpertListBean> datas;
    private AskAdapter askAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic_ask;
    }

    @Override
    protected void initViews() {
        askLv = byView(R.id.fragment_topic_ask_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        askAdapter = new AskAdapter(context);
        askLv.setAdapter(askAdapter);
        VolleyInstance.getInstance().startRequest(Values.ASKURL, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("AskFragment", resultStr);
        Gson gson = new Gson();
        AskEntity askEntity = gson.fromJson(resultStr, AskEntity.class);
        AskEntity.DataBean dataBean = askEntity.getData();
        datas = dataBean.getExpertList();
        askAdapter.setDatas(datas);
        askLv.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                            VolleyInstance.getInstance().startRequest(Values.ASKURL, new VolleyResult() {
                                @Override
                                public void success(String resultStr) {
                                    Gson gson = new Gson();
                                    AskEntity askEntity = gson.fromJson(resultStr, AskEntity.class);
                                    AskEntity.DataBean dataBean = askEntity.getData();
                                    datas = dataBean.getExpertList();
                                    askAdapter.setDatas(datas);
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
                        askAdapter.notifyDataSetChanged();
                        askLv.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
    }

    @Override
    public void failure() {

    }
}
