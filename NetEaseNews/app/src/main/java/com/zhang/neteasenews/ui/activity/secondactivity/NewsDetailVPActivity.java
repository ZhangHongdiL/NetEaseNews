package com.zhang.neteasenews.ui.activity.secondactivity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.VpDetailEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.List;

public class NewsDetailVPActivity extends AbsBaseActivity implements View.OnClickListener, VolleyResult {

    private ViewPager detailVp;
    private ImageView backIv, pointsIv, shareIv;
    private EditText writeEt;
    private TextView titleTv, positionTv, totalTv, contentTv, replyTv;

    // 拼接网址
    private static String STARTURL = "http://c.m.163.com/photo/api/set/";
    private static String ENDURL = ".json";
    private String skipId;
    private String finalUrl;
    private VpDetailEntity vpDetailEntity;

    private TextView shareTv, collectionTv, saveTv, faultTv;
    private int width, height;
    private LinearLayout rootView;
    private RelativeLayout relativeLayout;
    private View view;

    @Override
    protected int setLayout() {
        return R.layout.act_news_detail_vp;
    }

    @Override
    protected void initViews() {
        detailVp = byView(R.id.act_detail_vp);
        backIv = byView(R.id.act_detail_vp_back_img);
        pointsIv = byView(R.id.act_detail_vp_points_img);
        shareIv = byView(R.id.act_detail_vp_share_iv);
        titleTv = byView(R.id.act_detail_vp_title_tv);
        positionTv = byView(R.id.act_detail_vp_position_tv);
        totalTv = byView(R.id.act_detail_vp_total_tv);
        contentTv = byView(R.id.act_detail_vp_content_tv);
        replyTv = byView(R.id.act_detail_vp_reply_tv);
        writeEt = byView(R.id.act_detail_vp_write_et);
        relativeLayout = byView(R.id.vp_rl);
    }

    @Override
    protected void initDatas() {
        backIv.setOnClickListener(this);
        pointsIv.setOnClickListener(this);
        shareIv.setOnClickListener(this);
        setContent();

        Intent intent = getIntent();
        skipId = intent.getStringExtra("skipId");
        if (!skipId.isEmpty()) {
            skipId = skipId.substring(4, skipId.length());
            skipId = skipId.replace("|", "/");
            Log.d("iii", skipId);
            finalUrl = STARTURL + skipId + ENDURL;
            Log.d("iii", finalUrl);
        }
    }

    private void setContent() {
        VolleyInstance.getInstance().startRequest(finalUrl, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_detail_vp_back_img:
                finish();
                break;
            case R.id.act_detail_vp_points_img:
                setPopupWindow();
                break;
            case R.id.act_detail_vp_share_iv:
                break;
        }
    }

    private void setPopupWindow() {
        PopupWindow pw = new PopupWindow(this);
        width = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.WIDTH);
        pw.setWidth(width / 2);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;

        view = getLayoutInflater().inflate(R.layout.act_detail_vp_dialog, null);
        shareTv = (TextView) view.findViewById(R.id.detail_vp_share_tv);
        collectionTv = (TextView) view.findViewById(R.id.detail_vp_collection_tv);
        saveTv = (TextView) view.findViewById(R.id.detail_vp_save_tv);
        faultTv = (TextView) view.findViewById(R.id.detail_vp_fault_tv);

        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, width, statusBarHeight);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        vpDetailEntity = gson.fromJson(resultStr, VpDetailEntity.class);
        List<VpDetailEntity.PhotosBean> photosBean = vpDetailEntity.getPhotos();
        titleTv.setText(vpDetailEntity.getSetname());
//        contentTv.setText(photosBean.get().getImgtitle() + photosBean.get().getNote());
        totalTv.setText(vpDetailEntity.getImgsum());
    }

    @Override
    public void failure() {

    }
}
