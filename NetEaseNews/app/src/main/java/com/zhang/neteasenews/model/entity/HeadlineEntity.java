package com.zhang.neteasenews.model.entity;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadlineEntity {

    private int newsImg;   // 新闻图片
    private String newsTitle; // 新闻标题
    private String newsDate;  // 新闻类型
    private String newsReply; // 新闻跟帖数

    public HeadlineEntity() {
    }

    public HeadlineEntity(int newsImg, String newsTitle, String newsDate, String newsReply) {
        this.newsImg = newsImg;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsReply = newsReply;
    }

    public int getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(int newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsReply() {
        return newsReply;
    }

    public void setNewsReply(String newsReply) {
        this.newsReply = newsReply;
    }
}
