package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.AmusementEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 娱乐的适配器
 */
public class AmusementAdapter extends BaseAdapter{
    private Context context;
    private List<AmusementEntity.T1348648517839Bean> datas;

    public AmusementAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<AmusementEntity.T1348648517839Bean> datas) {
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

            // 为每行设置高度
            int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
            ViewGroup.LayoutParams params = convertView.getLayoutParams();
            params.height = height / 6;
            convertView.setLayoutParams(params);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AmusementEntity.T1348648517839Bean amusementEntity = (AmusementEntity.T1348648517839Bean) getItem(position);
        if (amusementEntity != null) {
            Picasso.with(context).load(amusementEntity.getImgsrc()).into(viewHolder.newsImg);
            viewHolder.newsTitle.setText(amusementEntity.getTitle());
            viewHolder.newsDate.setText(amusementEntity.getSource());
            viewHolder.newsReply.setText(amusementEntity.getReplyCount() + "" + "跟帖");
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
