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
import com.zhang.neteasenews.model.entity.HeadlineEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsHeadlineAdapter extends BaseAdapter {

    private Context context;
    private List<HeadlineEntity.T1348647909107Bean> datas;

    public NewsHeadlineAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HeadlineEntity.T1348647909107Bean> datas) {
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

            int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
            // 为每行设置高度
            ViewGroup.LayoutParams params = convertView.getLayoutParams();
            params.height = height / 5;
            convertView.setLayoutParams(params);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HeadlineEntity.T1348647909107Bean headlineEntity = (HeadlineEntity.T1348647909107Bean) getItem(position);
        if (headlineEntity != null) {
            Picasso.with(context).load(headlineEntity.getImgsrc()).into(viewHolder.newsImg);
            viewHolder.newsTitle.setText(headlineEntity.getTitle());
            viewHolder.newsDate.setText(headlineEntity.getLmodify());
            viewHolder.newsReply.setText(headlineEntity.getReplyCount() + "");
        }
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
