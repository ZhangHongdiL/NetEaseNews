package com.zhang.neteasenews.model.entity;

/**
 * Created by dllo on 16/9/10.
 * 个人界面的实体类
 */
public class MeListViewEntity {

    private int meImg;
    private String meTv;

    public MeListViewEntity() {
    }

    public MeListViewEntity(int meImg, String meTv) {
        this.meImg = meImg;
        this.meTv = meTv;
    }

    public int getMeImg() {
        return meImg;
    }

    public void setMeImg(int meImg) {
        this.meImg = meImg;
    }

    public String getMeTv() {
        return meTv;
    }

    public void setMeTv(String meTv) {
        this.meTv = meTv;
    }
}
