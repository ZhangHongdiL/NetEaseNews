package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.LiveListViewEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 直播界面的适配器
 */
public class LiveListViewAdapter extends BaseAdapter {

    private Context context;
    private List<LiveListViewEntity> datas;

    public LiveListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LiveListViewEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LiveViewHolder liveViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fra_live_listview, parent, false);
            liveViewHolder = new LiveViewHolder(convertView);
            convertView.setTag(liveViewHolder);
        } else {
            liveViewHolder = (LiveViewHolder) convertView.getTag();
        }
        LiveListViewEntity liveListViewEntity = (LiveListViewEntity) getItem(position);
        liveViewHolder.liveTitle.setText(liveListViewEntity.getLiveTitle());
        liveViewHolder.liveImg.setImageResource(liveListViewEntity.getLiveImg());
        liveViewHolder.liveJoin.setText(liveListViewEntity.getLiveJoin());
        return convertView;
    }

    class LiveViewHolder {
        TextView liveTitle, liveJoin;
        ImageView liveImg;

        public LiveViewHolder(View view) {
            liveTitle = (TextView) view.findViewById(R.id.item_fragment_live_title);
            liveImg = (ImageView) view.findViewById(R.id.item_fragment_live_img);
            liveJoin = (TextView) view.findViewById(R.id.item_fragment_live_join);
        }
    }
}
