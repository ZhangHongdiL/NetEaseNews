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
import android.widget.Toast;

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

    private RelativeLayout shareRl, collectionRl, jpRl, characterRl, nightRl, faultRl;
    private TextView collectionTv;
    private ImageView collectionIv;
    private int width, height;
    private LinearLayout rootView;
    private RelativeLayout relativeLayout;
    private View view;
    private Boolean state;

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

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        detailWv.loadUrl(url);

        state = false;
    }

    private void setPopupWindow() {
        final PopupWindow pw = new PopupWindow(this);
        width = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.WIDTH);
        height = ScreenSizeUtils.getScreenSize(this, ScreenSizeUtils.ScreenState.HEIGHT);

        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;  // 获得状态栏的高度

        pw.setWidth(width / 2);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        view = getLayoutInflater().inflate(R.layout.act_detail_dialog, null);
        shareRl = (RelativeLayout) view.findViewById(R.id.detail_share_rl);
        collectionRl = (RelativeLayout) view.findViewById(R.id.detail_collection_rl);
        collectionTv = (TextView) view.findViewById(R.id.detail_collection_tv);
        collectionIv = (ImageView) view.findViewById(R.id.detail_collection_iv);

        jpRl = (RelativeLayout) view.findViewById(R.id.detail_jp_rl);
        characterRl = (RelativeLayout) view.findViewById(R.id.detail_character_rl);
        nightRl = (RelativeLayout) view.findViewById(R.id.detail_night_rl);
        faultRl = (RelativeLayout) view.findViewById(R.id.detail_fault_rl);

        collectionRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == false) {
                    collectionIv.setImageResource(R.mipmap.collection_true);
                    collectionTv.setText(R.string.dialog_change_collection);
                    pw.dismiss();
                    Toast.makeText(NewsDetailActivity.this, R.string.toast_collection_success, Toast.LENGTH_SHORT).show();
                    state = true;
                } else {
                    collectionIv.setImageResource(R.mipmap.collection);
                    collectionTv.setText(R.string.dialog_collection);
                    pw.dismiss();
                    Toast.makeText(NewsDetailActivity.this, R.string.toast_collection_cancel, Toast.LENGTH_SHORT).show();
                    state = false;
                }
            }
        });

        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, width, statusBarHeight);
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
}
