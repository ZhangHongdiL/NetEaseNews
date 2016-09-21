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
import com.zhang.neteasenews.model.entity.subentity.ChoicenessEntity;
import com.zhang.neteasenews.utils.Values;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻界面精选页的适配器
 */
public class ChoicenessAdapter extends BaseAdapter {

    private Context context;
    private List<ChoicenessEntity.T1467284926140Bean> datas;
    private LayoutInflater inflater;
    private int type;

    public ChoicenessAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<ChoicenessEntity.T1467284926140Bean> datas) {
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
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (datas.get(position).getOrder() == 1) {
            return Values.CH_TYPE_ROTATE; // 轮播图
        } else if (null != datas.get(position).getSkipType() && "photoset".equals(datas.get(position).getSkipType())) {
            return Values.CH_TYPE_THREEIMG; // 三张图片的行布局
        } else if (datas.get(position).getImgType() == 1) {
            return Values.CH_TYPE_ONEIMG; // 一张图片的行布局
        } else {
            return Values.CH_TYPE_NORMAL; // 正常布局
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NormalViewHolder normalViewHolder = null;
        OneViewHolder oneViewHolder = null;
        ThreeViewHolder threeViewHolder = null;
        if (convertView == null) {
            switch (type) {
                case Values.CH_TYPE_NORMAL:
                    convertView = inflater.inflate(R.layout.item_fra_news_headline, parent, false);
                    normalViewHolder = new NormalViewHolder(convertView);
                    convertView.setTag(normalViewHolder);
                    break;
                case Values.CH_TYPE_ONEIMG:
                    convertView = inflater.inflate(R.layout.item_fra_news_cho_oneimg, parent, false);
                    oneViewHolder = new OneViewHolder(convertView);
                    convertView.setTag(oneViewHolder);
                    break;
                case Values.CH_TYPE_THREEIMG:
                    convertView = inflater.inflate(R.layout.item_fra_news_ch_threeimg, parent, false);
                    threeViewHolder = new ThreeViewHolder(convertView);
                    convertView.setTag(threeViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case Values.CH_TYPE_NORMAL:
                    normalViewHolder = (NormalViewHolder) convertView.getTag();
                    break;
                case Values.CH_TYPE_ONEIMG:
                    oneViewHolder = (OneViewHolder) convertView.getTag();
                    break;
                case Values.CH_TYPE_THREEIMG:
                    threeViewHolder = (ThreeViewHolder) convertView.getTag();
                    break;
            }
        }
        ChoicenessEntity.T1467284926140Bean entity = (ChoicenessEntity.T1467284926140Bean) getItem(position);
        if (entity != null) {
            switch (type) {
                case Values.CH_TYPE_NORMAL:
                    normalViewHolder.newsTitle.setText(entity.getTitle());
                    normalViewHolder.newsSource.setText(entity.getSource());
                    normalViewHolder.newsReply.setText(entity.getReplyCount() + "跟帖");
                    Picasso.with(context).load(datas.get(position).getImgsrc()).into(normalViewHolder.newsImg);
                    break;
                case Values.CH_TYPE_ONEIMG:
                    oneViewHolder.titleTv.setText(entity.getTitle());
                    oneViewHolder.sourceTv.setText(entity.getSource());
                    oneViewHolder.replyTv.setText(entity.getReplyCount() + "跟帖");
                    Picasso.with(context).load(datas.get(position).getImgsrc()).into(oneViewHolder.oneImg);
                    break;
                case Values.CH_TYPE_THREEIMG:
                    threeViewHolder.titleTv.setText(entity.getTitle());
                    threeViewHolder.sourceTv.setText(entity.getSource());
                    threeViewHolder.replyTv.setText(entity.getReplyCount() + "跟帖");
                    Picasso.with(context).load(datas.get(position).getImgsrc()).into(threeViewHolder.leftImg);
                    Picasso.with(context).load(datas.get(position).getImgextra().get(0).getImgsrc()).into(threeViewHolder.middleImg);
                    Picasso.with(context).load(datas.get(position).getImgextra().get(1).getImgsrc()).into(threeViewHolder.rightImg);
                    break;
            }
        }
        return convertView;
    }

    class NormalViewHolder {
        ImageView newsImg;
        TextView newsTitle, newsSource, newsReply;

        public NormalViewHolder(View view) {
            newsImg = (ImageView) view.findViewById(R.id.item_fra_news_headline_img);
            newsTitle = (TextView) view.findViewById(R.id.item_fra_news_headline_title);
            newsSource = (TextView) view.findViewById(R.id.item_fra_news_headline_source);
            newsReply = (TextView) view.findViewById(R.id.item_fra_news_headline_reply);
        }
    }

    class OneViewHolder {
        TextView titleTv, sourceTv, replyTv;
        ImageView oneImg;
        public OneViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_title_tv);
            sourceTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_source_tv);
            replyTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_reply_tv);
            oneImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_one_img);
        }
    }

    class ThreeViewHolder {
        TextView titleTv, sourceTv, replyTv;
        ImageView leftImg, middleImg, rightImg;
        public ThreeViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_title_tv);
            sourceTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_source_tv);
            replyTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_reply_tv);
            leftImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_left_img);
            middleImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_middle_img);
            rightImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_right_img);
        }
    }
}
