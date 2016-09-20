package com.zhang.neteasenews.ui.adapter.topicsubadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeEntity;
import com.zhang.neteasenews.utils.Values;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/20.
 * 话题界面话题的适配器
 */
public class ThemeAdapter extends BaseAdapter {

    private Context context;
    private List<ThemeEntity.DataBean.SubjectListBean> datas;
    private LayoutInflater inflater;
    private int type;

    public ThemeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<ThemeEntity.DataBean.SubjectListBean> datas) {
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
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        type = datas.get(position).getType();
        if(type == 0){
            return Values.THEME_TWO;
        }else {
            return Values.THEME_THREE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TwoViewHolder twoViewHolder = null;
        ThreeViewHolder threeViewHolder = null;
        if (convertView == null) {
            switch (type){
                case Values.THEME_TWO:
                    convertView = inflater.inflate(R.layout.item_fra_topic_theme_two, parent, false);
                    twoViewHolder = new TwoViewHolder(convertView);
                    convertView.setTag(twoViewHolder);
                    break;
                case Values.THEME_THREE:
                    convertView = inflater.inflate(R.layout.item_fra_topic_theme_three, parent, false);
                    threeViewHolder = new ThreeViewHolder(convertView);
                    convertView.setTag(threeViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case Values.THEME_TWO:
                    twoViewHolder = (TwoViewHolder) convertView.getTag();
                    break;
                case Values.THEME_THREE:
                    threeViewHolder = (ThreeViewHolder) convertView.getTag();
                    break;
            }
        }
        ThemeEntity.DataBean.SubjectListBean slBean = (ThemeEntity.DataBean.SubjectListBean) getItem(position);
        ThemeEntity.DataBean.SubjectListBean.TalkContentBean tcb = (ThemeEntity.DataBean.SubjectListBean.TalkContentBean) getItem(position);
        if (slBean != null) {
            switch (type) {
                case Values.THEME_TWO:
                    twoViewHolder.twoTitleTv.setText("#" + slBean.getName() + "#");
                    twoViewHolder.upTv.setText("\"" + tcb.getContent() + "\"");
                    twoViewHolder.downTv.setText("\"" + tcb.getContent() + "\"");
                    Picasso.with(context).load(tcb.getUserHeadPicUrl()).into(twoViewHolder.upCiv);
                    Picasso.with(context).load(tcb.getUserHeadPicUrl()).into(twoViewHolder.downCiv);
                    twoViewHolder.twoSourceTv.setText(slBean.getClassification());
                    twoViewHolder.twoAttentionTv.setText(slBean.getConcernCount() + "关注");
                    twoViewHolder.twoAskTv.setText(slBean.getTalkCount() + "讨论");
                    break;
                case Values.THEME_THREE:
                    threeViewHolder.threeTitleTv.setText("#" + slBean.getName() + "#");
                    Picasso.with(context).load("http://mobilepics.nosdn.127.net/netease_subject/866288027258932/1474360697378203893").into(threeViewHolder.leftImg);
//                    Picasso.with(context).load(slBean.getTalkPicture().get(1).toString()).into(threeViewHolder.middleImg);
//                    Picasso.with(context).load(slBean.getTalkPicture().get(2).toString()).into(threeViewHolder.rightImg);
                    threeViewHolder.threeSourceTv.setText(slBean.getClassification());
                    threeViewHolder.threeAttentionTv.setText(slBean.getConcernCount() + "关注");
                    threeViewHolder.threeAskTv.setText(slBean.getTalkCount() + "讨论");
                    break;
            }
        }
        return convertView;
    }

    class TwoViewHolder {
        TextView twoTitleTv, upTv, downTv, twoSourceTv, twoAttentionTv, twoAskTv;
        CircleImageView upCiv, downCiv;
        public TwoViewHolder(View view) {
            twoTitleTv = (TextView) view.findViewById(R.id.theme_two_title_tv);
            upTv = (TextView) view.findViewById(R.id.theme_two_up_tv);
            downTv = (TextView) view.findViewById(R.id.theme_two_down_tv);
            twoSourceTv = (TextView) view.findViewById(R.id.theme_two_source_tv);
            twoAttentionTv = (TextView) view.findViewById(R.id.theme_two_attention_tv);
            twoAskTv = (TextView) view.findViewById(R.id.theme_two_ask_tv);
            upCiv = (CircleImageView) view.findViewById(R.id.theme_two_up_civ);
            downCiv = (CircleImageView) view.findViewById(R.id.theme_two_down_civ);
        }
    }

    class ThreeViewHolder {
        TextView threeTitleTv, threeSourceTv, threeAttentionTv, threeAskTv;
        ImageView leftImg, middleImg, rightImg;
        public ThreeViewHolder(View view) {
            threeTitleTv = (TextView) view.findViewById(R.id.theme_three_title_tv);
            threeSourceTv = (TextView) view.findViewById(R.id.theme_three_source_tv);
            threeAttentionTv = (TextView) view.findViewById(R.id.theme_three_attention_tv);
            threeAskTv = (TextView) view.findViewById(R.id.theme_three_ask_tv);
            leftImg = (ImageView) view.findViewById(R.id.theme_three_left_img);
            middleImg = (ImageView) view.findViewById(R.id.theme_three_middle_img);
            rightImg = (ImageView) view.findViewById(R.id.theme_three_right_img);
        }
    }
}
