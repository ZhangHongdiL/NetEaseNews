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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.db.LiteOrmInstance;
import com.zhang.neteasenews.model.entity.CollectionEntity;
import com.zhang.neteasenews.model.entity.VpDetailEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.ui.adapter.subadapter.DetailVpAdapter;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

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
    private Boolean state = false; // 存储pw的状态
    private Boolean toast = false; // 存储toast的状态
    private String id;

    /**
     * 数据库实体类的参数
     */
    private String title, imgUrl;
    private int imgSum;

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
        id = intent.getStringExtra("skipId");
        if (!skipId.isEmpty()) {
            skipId = skipId.substring(4, skipId.length());
            skipId = skipId.replace("|", "/");
//            Log.d("iii", skipId);
            finalUrl = STARTURL + skipId + ENDURL;
//            Log.d("iii", finalUrl);
        }
        datas = new ArrayList<>();
        detailVpAdapter = new DetailVpAdapter(this);
        setContent();
    }

    private void setContent() {
        VolleyInstance.getInstance().startRequest(finalUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
//                Log.d("123", resultStr);
                Gson gson = new Gson();
                vpDetailEntity = gson.fromJson(resultStr, VpDetailEntity.class);
                datas = vpDetailEntity.getPhotos();
                detailVpAdapter.setDatas(datas);
                detailVp.setAdapter(detailVpAdapter);

                titleTv.setText(vpDetailEntity.getSetname());
                totalTv.setText(vpDetailEntity.getImgsum());
                contentTv.setText(datas.get(0).getImgtitle() + datas.get(0).getNote());
                positionTv.setText(1 + "/");

                title = vpDetailEntity.getSetname();
                imgUrl = vpDetailEntity.getPhotos().get(0).getImgurl();
                imgSum = Integer.valueOf(vpDetailEntity.getImgsum());

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
        final PopupWindow pw = new PopupWindow(this);
        width = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.WIDTH);
        pw.setWidth(width / 2);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;  // 电量栏的高度

        view = getLayoutInflater().inflate(R.layout.act_detail_vp_dialog, null);
        shareRl = (RelativeLayout) view.findViewById(R.id.detail_vp_share_rl);
        collectionRl = (RelativeLayout) view.findViewById(R.id.detail_vp_collection_rl);
        collectionTv = (TextView) view.findViewById(R.id.detail_vp_collection_tv);
        collectionIv = (ImageView) view.findViewById(R.id.detail_vp_collection_iv);

        if (!LiteOrmInstance.getInstance().queryByTitle(title).isEmpty()) {
            collectionIv.setImageResource(R.mipmap.collection_true);
            collectionTv.setText(R.string.dialog_change_collection);
            toast = false;
            state = true;
        } else {
            collectionIv.setImageResource(R.mipmap.collection);
            collectionTv.setText(R.string.dialog_collection);
            LiteOrmInstance.getInstance().deleteByTile(title);
            toast = true;
            state = false;
        }
        collectionRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionEntity ce = new CollectionEntity(title, imgUrl, imgSum, id);

                if (state == false) {
                    pw.dismiss();
                    LiteOrmInstance.getInstance().insert(ce);
                } else {
                    pw.dismiss();
                    LiteOrmInstance.getInstance().deleteByTile(title);
                }
                if (toast == true) {
                    Toast.makeText(NewsDetailVPActivity.this, R.string.toast_collection_success, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NewsDetailVPActivity.this, R.string.toast_collection_cancel, Toast.LENGTH_SHORT).show();
                }

            }
        });

        /**
         * 分享
         */
        shareRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle(vpDetailEntity.getSetname());
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText(datas.get(0).getImgtitle() + datas.get(0).getNote());
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//                Glide.with(NewsDetailVPActivity.this).load(datas.get(0).getImgurl()).into(oks);
                
                oks.setImageUrl(datas.get(0).getImgurl());
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("ShareSDK");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
                oks.show(NewsDetailVPActivity.this);
            }
        });

        saveRl = (RelativeLayout) view.findViewById(R.id.detail_vp_save_rl);
        faultRl = (RelativeLayout) view.findViewById(R.id.detail_vp_fault_rl);

        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, width, statusBarHeight);
        pw.isShowing();

    }
}
