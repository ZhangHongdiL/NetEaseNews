package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.HeadlineEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsHeadlineAdapter extends BaseAdapter {

    private List<HeadlineEntity> datas;
    private Context context;

    public NewsHeadlineAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HeadlineEntity> datas) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fra_news_headline, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HeadlineEntity headlineEntity = (HeadlineEntity) getItem(position);
        viewHolder.newsImg.setImageResource(headlineEntity.getNewsImg());
        viewHolder.newsTitle.setText(headlineEntity.getNewsTitle());
        viewHolder.newsDate.setText(headlineEntity.getNewsDate());
        viewHolder.newsReply.setText(headlineEntity.getNewsReply() );
        return convertView;
    }

    class ViewHolder {
        ImageView newsImg;
        TextView newsTitle, newsDate, newsReply;

        public ViewHolder(View view) {
            newsImg = (ImageView) view.findViewById(R.id.item_fra_news_headline_img);
            newsTitle = (TextView) view.findViewById(R.id.item_fra_news_headline_title);
            newsDate = (TextView) view.findViewById(R.id.item_fra_news_headline_date);
            newsReply = (TextView) view.findViewById(R.id.item_fra_news_headline_reply);
        }
    }
}
