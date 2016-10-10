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
import com.zhang.neteasenews.model.entity.VpDetailEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.ui.adapter.subadapter.DetailVpAdapter;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailVPActivity extends AbsBaseActivity implements View.OnClickListener {

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
    private DetailVpAdapter detailVpAdapter;
    private List<VpDetailEntity.PhotosBean> datas;

    private RelativeLayout shareRl, collectionRl, saveRl, faultRl;
    private TextView collectionTv;
    private ImageView collectionIv;
    private int width, height;
    private LinearLayout rootView;
    private RelativeLayout relativeLayout;
    private View view;
    private boolean state = false;

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


        Intent intent = getIntent();
        skipId = intent.getStringExtra("skipId");
        if (!skipId.isEmpty()) {
            skipId = skipId.substring(4, skipId.length());
            skipId = skipId.replace("|", "/");
            Log.d("iii", skipId);
            finalUrl = STARTURL + skipId + ENDURL;
            Log.d("iii", finalUrl);
        }
        datas = new ArrayList<>();
        detailVpAdapter = new DetailVpAdapter(this);
        setContent();
    }

    private void setContent() {
        VolleyInstance.getInstance().startRequest(finalUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("123", resultStr);
                Gson gson = new Gson();
                vpDetailEntity = gson.fromJson(resultStr, VpDetailEntity.class);
                datas = vpDetailEntity.getPhotos();
                detailVpAdapter.setDatas(datas);
                detailVp.setAdapter(detailVpAdapter);

                titleTv.setText(vpDetailEntity.getSetname());
                totalTv.setText(vpDetailEntity.getImgsum());
                contentTv.setText(datas.get(0).getImgtitle() + datas.get(0).getNote());
                positionTv.setText(1 + "/");
                detailVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (position < datas.size()) {
                            contentTv.setText(datas.get(position).getImgtitle() + datas.get(position).getNote());
                            positionTv.setText((position + 1) + "/");
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }

            @Override
            public void failure() {

            }
        });
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
        shareRl = (RelativeLayout) view.findViewById(R.id.detail_vp_share_rl);
        collectionRl = (RelativeLayout) view.findViewById(R.id.detail_vp_collection_rl);
        collectionTv = (TextView) view.findViewById(R.id.detail_vp_collection_tv);
        collectionIv = (ImageView) view.findViewById(R.id.detail_vp_collection_iv);

        saveRl = (RelativeLayout) view.findViewById(R.id.detail_vp_save_rl);
        faultRl = (RelativeLayout) view.findViewById(R.id.detail_vp_fault_rl);

        collectionRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, width, statusBarHeight);
    }
}
