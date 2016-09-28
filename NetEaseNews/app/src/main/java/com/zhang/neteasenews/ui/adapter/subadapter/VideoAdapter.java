package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.VideoEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面视频页的适配器
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    private List<VideoEntity.视频Bean> datas;
    private int height;
    private int minute;
    private int s;
    private String finalLength;


    public VideoAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<VideoEntity.视频Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fra_news_video, parent, false);
        // 为每行设置高度
        height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
        ViewGroup.LayoutParams params1 = view.getLayoutParams();
        params1.height = height / 3;
        view.setLayoutParams(params1);
        VideoViewHolder holder = new VideoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.topicnameTv.setText(datas.get(position).getTopicName());
        holder.titleTv.setText(datas.get(position).getTitle());
        holder.countTv.setText(datas.get(position).getPlayCount() + "播放");
        /**
         * 整理得到的视频时长
         */
        int length = datas.get(position).getLength();
        minute = length / 60;
        s = length % 60;
        if (minute >= 0 && minute < 10 && s > 9) {
            finalLength = "0" + minute + ":" + s;
            holder.lengthTv.setText(finalLength + "/");
        } else if (minute >= 0 && minute < 10 && s < 10){
            finalLength = "0" + minute + ":0" + s;
            holder.lengthTv.setText(finalLength + "/");
        } else if (minute >= 10 && s > 9) {
            finalLength = minute + ":" + s;
            holder.lengthTv.setText(finalLength + "/");
        } else if (minute >= 10 && s < 10){
            finalLength = minute + ":0" + s;
            holder.lengthTv.setText(finalLength + "/");
        }

        Glide.with(context).load(datas.get(position).getCover()).error(R.mipmap.netease_big).into(holder.videoImg);
        Glide.with(context).load(datas.get(position).getTopicImg()).error(R.mipmap.netease_small).into(holder.topicnameImg);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView videoImg, topicnameImg;
        TextView lengthTv, countTv, titleTv, topicnameTv;

        public VideoViewHolder(View itemView) {
            super(itemView);
            videoImg = (ImageView) itemView.findViewById(R.id.item_fra_news_video_img);
            topicnameImg = (ImageView) itemView.findViewById(R.id.item_fra_news_video_topicname_img);
            lengthTv = (TextView) itemView.findViewById(R.id.item_fra_news_video_length_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_fra_news_video_count_tv);
            titleTv = (TextView) itemView.findViewById(R.id.item_fra_news_video_title_tv);
            topicnameTv = (TextView) itemView.findViewById(R.id.item_fra_news_video_topicname_tv);
        }
    }
}
