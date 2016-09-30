package com.zhang.neteasenews.ui.adapter.topicsubadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeHeadEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 */
public class ThemeHeadAdapter extends RecyclerView.Adapter<ThemeHeadAdapter.ThemeViewHolder> {

    private List<ThemeHeadEntity.话题Bean> datas;
    private Context context;
    private int width, height;

    public ThemeHeadAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ThemeHeadEntity.话题Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_head_theme, parent, false);

        height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
        width = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height / 4;
        params.width = width * 2 / 5;
        view.setLayoutParams(params);

        ThemeViewHolder themeViewHolder = new ThemeViewHolder(view);
        return themeViewHolder;
    }

    @Override
    public void onBindViewHolder(ThemeViewHolder holder, int position) {
        if (holder != null) {
            Glide.with(context).load(datas.get(position).getPicUrl()).error(R.mipmap.netease_small).into(holder.img);
            holder.tv.setText("#" + datas.get(position).getTopicName() + "#");
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ThemeViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        public ThemeViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_head_theme_img);
            tv = (TextView) itemView.findViewById(R.id.item_head_theme_tv);
        }
    }
}
