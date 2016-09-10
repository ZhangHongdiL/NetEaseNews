package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.MeListViewEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class MeListViewAdapter extends BaseAdapter {

    private Context context;
    private List<MeListViewEntity> datas;

    public MeListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<MeListViewEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fragment_me_listview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MeListViewEntity meListViewEntity = (MeListViewEntity) getItem(position);
        viewHolder.meImg.setImageResource(meListViewEntity.getMeImg());
        viewHolder.meTv.setText(meListViewEntity.getMeTv());
        return convertView;
    }

    class ViewHolder {
        ImageView meImg;
        TextView meTv;

        public ViewHolder(View view) {
            meImg = (ImageView) view.findViewById(R.id.item_fra_me_img);
            meTv = (TextView) view.findViewById(R.id.item_fra_me_tv);
        }
    }
}
