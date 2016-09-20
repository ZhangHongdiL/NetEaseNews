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
import com.zhang.neteasenews.model.entity.topicsubentity.AskEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/20.
 * 话题界面的问吧的适配器
 */
public class AskAdapter extends BaseAdapter {

    private Context context;
    private List<AskEntity.DataBean.ExpertListBean> datas;

    public AskAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<AskEntity.DataBean.ExpertListBean> datas) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        AskViewHolder askViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fra_topic_ask_listview, parent, false);
            askViewHolder = new AskViewHolder(convertView);
            convertView.setTag(askViewHolder);
        } else {
            askViewHolder = (AskViewHolder) convertView.getTag();
        }
        AskEntity.DataBean.ExpertListBean expertListBean = (AskEntity.DataBean.ExpertListBean) getItem(position);
        if (expertListBean != null) {
            Picasso.with(context).load(expertListBean.getPicurl()).into(askViewHolder.titleImg);
            Picasso.with(context).load(expertListBean.getHeadpicurl()).into(askViewHolder.personImg);
            askViewHolder.contentTv.setText(expertListBean.getAlias());
            askViewHolder.personTv.setText(expertListBean.getName() + "/");
            askViewHolder.titleTv.setText(expertListBean.getTitle());
            askViewHolder.sourceTv.setText(expertListBean.getClassification());
            askViewHolder.attentionTv.setText(expertListBean.getConcernCount() + "关注");
            askViewHolder.askTv.setText(expertListBean.getQuestionCount() + "提问");
        }
        return convertView;
    }

    class AskViewHolder {
        ImageView titleImg;
        CircleImageView personImg;
        TextView personTv, contentTv, sourceTv, attentionTv, askTv, titleTv;
        public AskViewHolder(View view) {
            titleImg = (ImageView) view.findViewById(R.id.ask_title_img);
            personImg = (CircleImageView) view.findViewById(R.id.ask_person_img);
            personTv = (TextView) view.findViewById(R.id.ask_person_tv);
            contentTv = (TextView) view.findViewById(R.id.ask_content_tv);
            sourceTv = (TextView) view.findViewById(R.id.ask_source_tv);
            attentionTv = (TextView) view.findViewById(R.id.ask_attention_tv);
            askTv = (TextView) view.findViewById(R.id.ask_ask_tv);
            titleTv = (TextView) view.findViewById(R.id.ask_title_tv);
        }
    }
}
