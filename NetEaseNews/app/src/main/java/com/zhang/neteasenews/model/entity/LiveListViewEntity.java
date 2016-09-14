package com.zhang.neteasenews.model.entity;

/**
 * Created by dllo on 16/9/10.
 */
public class LiveListViewEntity {
    private String liveTitle; // 直播标题
    private int liveImg; // 直播图片
    private String liveJoin; // 直播的参与人数

    public LiveListViewEntity() {
    }

    public LiveListViewEntity(String liveTitle, int liveImg, String liveJoin) {
        this.liveTitle = liveTitle;
        this.liveImg = liveImg;
        this.liveJoin = liveJoin;
    }

    public String getLiveTitle() {
        return liveTitle;
    }

    public void setLiveTitle(String liveTitle) {
        this.liveTitle = liveTitle;
    }

    public int getLiveImg() {
        return liveImg;
    }

    public void setLiveImg(int liveImg) {
        this.liveImg = liveImg;
    }

    public String getLiveJoin() {
        return liveJoin;
    }

    public void setLiveJoin(String liveJoin) {
        this.liveJoin = liveJoin;
    }
}
