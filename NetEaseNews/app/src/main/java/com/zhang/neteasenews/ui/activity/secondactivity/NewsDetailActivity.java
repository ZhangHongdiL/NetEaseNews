package com.zhang.neteasenews.ui.activity.secondactivity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;

/**
 * Created by dllo on 16/9/28.
 * 新闻详情界面
 */
public class NewsDetailActivity extends AbsBaseActivity implements View.OnClickListener {

    private WebView detailWv;
    private ImageView backIv, pointsIv, shareIv;
    private TextView replyTv;
    private EditText writeEt;

    private TextView shareTv, collectionTv, jpTv, characterTv, nightTv, faultTv;
    private int width, height;
    private LinearLayout rootView;
    private RelativeLayout relativeLayout;
    private View view;

    @Override
    protected int setLayout() {
        return R.layout.act_detail_webview;
    }

    @Override
    protected void initViews() {
        detailWv = byView(R.id.act_detail_wv);
        backIv = byView(R.id.act_detail_wv_back_img);
        pointsIv = byView(R.id.act_detail_wv_points_img);
        shareIv = byView(R.id.act_detail_wv_share_iv);
        replyTv = byView(R.id.act_detail_wv_reply_tv);
        writeEt = byView(R.id.act_detail_wv_write_et);
        rootView = byView(R.id.root_view);
        relativeLayout = byView(R.id.root_view2);
    }

    @Override
    protected void initDatas() {
        backIv.setOnClickListener(this);
        pointsIv.setOnClickListener(this);

        detailWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });

        //WebSettings set = detailWv.getSettings();
       // set.setJavaScriptEnabled(true);
        //set.setJavaScriptCanOpenWindowsAutomatically(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
//        Log.d("vvvv", url);
        detailWv.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_detail_wv_back_img:
                finish();
                break;
            case R.id.act_detail_wv_points_img:
                setPopupWindow();
                break;
        }
    }

    private void setPopupWindow() {
        PopupWindow pw = new PopupWindow(this);
        width = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.WIDTH);
        height = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.HEIGHT);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;  // 获得状态栏的高度

        pw.setWidth(width / 2);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        view = getLayoutInflater().inflate(R.layout.act_detail_dialog, null);
        shareTv = (TextView) view.findViewById(R.id.detail_share_tv);
        collectionTv = (TextView) view.findViewById(R.id.detail_collection_tv);
        jpTv = (TextView) view.findViewById(R.id.detail_jp_tv);
        characterTv = (TextView) view.findViewById(R.id.detail_character_tv);
        nightTv = (TextView) view.findViewById(R.id.detail_night_tv);
        faultTv = (TextView) view.findViewById(R.id.detail_fault_tv);

        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, width, statusBarHeight);
    }
}
