package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.CollectionEntity;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 收藏的适配器
 */
public class ActCollectionAdapter extends BaseAdapter {

    private Context context;
    private List<CollectionEntity> datas;

    public ActCollectionAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CollectionEntity> datas) {
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
        CollcetionHolder collcetionHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_act_collection, parent, false);
            collcetionHolder = new CollcetionHolder(convertView);
            convertView.setTag(collcetionHolder);
        } else {
            collcetionHolder = (CollcetionHolder) convertView.getTag();
        }
        CollectionEntity entity = (CollectionEntity) getItem(position);
        collcetionHolder.titleTv.setText(entity.getTitle());
        collcetionHolder.sumTv.setText(entity.getImgSum());
        Glide.with(context).load(entity.getImgurl()).error(R.mipmap.netease_big).into(collcetionHolder.img);
        return convertView;
    }

    class CollcetionHolder {
        TextView titleTv, sumTv;
        ImageView img;
        private CollcetionHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_collection_title_tv);
            sumTv = (TextView) view.findViewById(R.id.item_collection_sum_tv);
            img = (ImageView) view.findViewById(R.id.item_collection_img);
        }
    }
}
