package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.LiveListViewEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 直播界面的适配器
 */
public class LiveListViewAdapter extends BaseAdapter {

    private Context context;
    private List<LiveListViewEntity.T1462958418713Bean> datas;

    public LiveListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LiveListViewEntity.T1462958418713Bean> datas) {
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

            // 为每行设置高度
            int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
            ViewGroup.LayoutParams params = convertView.getLayoutParams();
            params.height = height / 2;
            convertView.setLayoutParams(params);

            liveViewHolder = new LiveViewHolder(convertView);
            convertView.setTag(liveViewHolder);
        } else {
            liveViewHolder = (LiveViewHolder) convertView.getTag();
        }
        LiveListViewEntity.T1462958418713Bean liveListViewEntity = (LiveListViewEntity.T1462958418713Bean) getItem(position);
        if (liveListViewEntity != null) {
            liveViewHolder.liveTitle.setText(liveListViewEntity.getTitle());
            Picasso.with(context).load(liveListViewEntity.getImgsrc()).error(R.mipmap.netease_big).into(liveViewHolder.liveImg);
            liveViewHolder.liveJoin.setText(liveListViewEntity.getLive_info().getUser_count() + ""+ "参与");
        }
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
