package com.zhang.neteasenews.ui.adapter.topicsubadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhang.neteasenews.model.entity.topicsubentity.AskEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 话题界面的问吧的适配器
 */
public class AskAdapter extends BaseAdapter {

    private Context context;
    private List<AskEntity> datas;

    public AskAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<AskEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    class AskViewHolder {
        
    }
}
