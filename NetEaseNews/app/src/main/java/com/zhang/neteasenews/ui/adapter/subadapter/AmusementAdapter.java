package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.AmusementEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面娱乐页的适配器
 */
public class AmusementAdapter extends BaseAdapter{

    private Context context;
    private List<AmusementEntity.T1348648517839Bean> datas;
    private LayoutInflater inflater;
    private int height;

    public AmusementAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<AmusementEntity.T1348648517839Bean> datas) {
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
        HeadHolder headHolder = null;
        NormalHolder normalHolder = null;
        OneHolder oneHolder = null;
        ThreeHolder threeHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {

            switch (type) {
                case Values.CH_TYPE_ROTATE:
                    convertView = inflater.inflate(R.layout.item_fra_news_ch_head, parent, false);
                    headHolder = new HeadHolder(convertView);
                    convertView.setTag(headHolder);
                    break;
                case Values.CH_TYPE_NORMAL:
//                    Log.d("ChoicenessAdapter", ">>>>>>>>");
                    convertView = inflater.inflate(R.layout.item_fra_news_headline, parent, false);

                    // 为每行设置高度
                    height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
                    ViewGroup.LayoutParams params1 = convertView.getLayoutParams();
                    params1.height = height / 6;
                    convertView.setLayoutParams(params1);

                    normalHolder = new NormalHolder(convertView);
                    convertView.setTag(normalHolder);
                    break;
                case Values.CH_TYPE_ONEIMG:
                    convertView = inflater.inflate(R.layout.item_fra_news_cho_oneimg, parent, false);
                    oneHolder = new OneHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case Values.CH_TYPE_THREEIMG:
                    convertView = inflater.inflate(R.layout.item_fra_news_ch_threeimg, parent, false);
                    threeHolder = new ThreeHolder(convertView);
                    convertView.setTag(threeHolder);
                    break;
            }
        } else {
            switch (type) {
                case Values.CH_TYPE_ROTATE:
                    headHolder = (HeadHolder) convertView.getTag();
                    break;
                case Values.CH_TYPE_NORMAL:
                    normalHolder = (NormalHolder) convertView.getTag();
                    break;
                case Values.CH_TYPE_ONEIMG:
                    oneHolder = (OneHolder) convertView.getTag();
                    break;
                case Values.CH_TYPE_THREEIMG:
                    threeHolder = (ThreeHolder) convertView.getTag();
                    break;
            }
        }
        AmusementEntity.T1348648517839Bean entity = (AmusementEntity.T1348648517839Bean) getItem(position);
        if (entity != null) {
            switch (type) {
                case Values.CH_TYPE_ROTATE:
                    headHolder.headTv.setText(entity.getTitle());
                    Glide.with(context).load(entity.getImgsrc()).into(headHolder.headImg);
                    break;
                case Values.CH_TYPE_NORMAL:
                    normalHolder.newsTitle.setText(entity.getTitle());
                    normalHolder.newsSource.setText(entity.getSource());
                    normalHolder.newsReply.setText(entity.getReplyCount() + "跟帖");
                    Glide.with(context).load(entity.getImgsrc()).into(normalHolder.newsImg);
                    break;
                case Values.CH_TYPE_ONEIMG:
                    oneHolder.titleTv.setText(entity.getTitle());
                    oneHolder.sourceTv.setText(entity.getSource());
                    oneHolder.replyTv.setText(entity.getReplyCount() + "跟帖");
                    Glide.with(context).load(entity.getImgsrc()).into(oneHolder.oneImg);
                    break;
                case Values.CH_TYPE_THREEIMG:
                    threeHolder.titleTv.setText(entity.getTitle());
                    threeHolder.sourceTv.setText(entity.getSource());
                    threeHolder.replyTv.setText(entity.getReplyCount() + "跟帖");
                    Glide.with(context).load(entity.getImgsrc()).into(threeHolder.leftImg);
                    Glide.with(context).load(entity.getImgextra().get(0).getImgsrc()).into(threeHolder.middleImg);
                    Glide.with(context).load(entity.getImgextra().get(1).getImgsrc()).into(threeHolder.rightImg);
                    break;
            }
        }
        return convertView;
    }

    class HeadHolder {
        ImageView headImg;
        TextView headTv;
        public HeadHolder(View view) {
            headImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_head_img);
            headTv = (TextView) view.findViewById(R.id.item_fra_news_ch_head_tv);
        }
    }

    class NormalHolder {
        ImageView newsImg;
        TextView newsTitle, newsSource, newsReply;

        public NormalHolder(View view) {
            newsImg = (ImageView) view.findViewById(R.id.item_fra_news_headline_img);
            newsTitle = (TextView) view.findViewById(R.id.item_fra_news_headline_title);
            newsSource = (TextView) view.findViewById(R.id.item_fra_news_headline_source);
            newsReply = (TextView) view.findViewById(R.id.item_fra_news_headline_reply);
        }
    }

    class OneHolder {
        TextView titleTv, sourceTv, replyTv;
        ImageView oneImg;
        public OneHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_title_tv);
            sourceTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_source_tv);
            replyTv = (TextView) view.findViewById(R.id.item_fra_news_ch_one_reply_tv);
            oneImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_one_img);
        }
    }

    class ThreeHolder {
        TextView titleTv, sourceTv, replyTv;
        ImageView leftImg, middleImg, rightImg;
        public ThreeHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_title_tv);
            sourceTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_source_tv);
            replyTv = (TextView) view.findViewById(R.id.item_fra_news_ch_three_reply_tv);
            leftImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_left_img);
            middleImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_middle_img);
            rightImg = (ImageView) view.findViewById(R.id.item_fra_news_ch_three_right_img);
        }
    }
}
