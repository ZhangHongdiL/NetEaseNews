package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.SearchHotEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 新闻界面跳转的搜索界面的适配器
 */
public class SearchHotAdapter extends RecyclerView.Adapter<SearchHotAdapter.SearchViewHolder>{

    private Context context;
    private List<SearchHotEntity.HotWordListBean> datas;

    public SearchHotAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SearchHotEntity.HotWordListBean> datas) {
        this.datas = datas;
//        Log.d("rrr", "datas.size():-----" + datas.size());
        notifyDataSetChanged();
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_hot, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        if (holder != null) {
            holder.hotTv.setText(datas.get(position).getHotWord());
//        Log.d("rrr", datas.get(position).getHotWord());
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView hotTv;
        public SearchViewHolder(View itemView) {
            super(itemView);
            hotTv = (TextView) itemView.findViewById(R.id.item_search_hot_tv);
        }
    }
}
