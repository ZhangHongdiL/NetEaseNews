package com.zhang.neteasenews.model.entity;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/10.
 * 收藏的实体类
 */
@Table("collection")
public class CollectionEntity {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    private String user;
    private String title;
    private String imgurl;
    private String content;
    private int reply;
    private int imgSum;
    private String skipId;
    private int type;
    private String url;

    public CollectionEntity() {

    }

    public CollectionEntity(String title, String imgurl, int imgSum, String skipId, int type) {
        this.title = title;
        this.imgurl = imgurl;
        this.imgSum = imgSum;
        this.skipId = skipId;
        this.type = type;
    }

    public CollectionEntity(String title, String content, int reply, int type, String url) {
        this.title = title;
        this.content = content;
        this.reply = reply;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getImgSum() {
        return imgSum;
    }

    public void setImgSum(int imgSum) {
        this.imgSum = imgSum;
    }

    public String getSkipId() {
        return skipId;
    }

    public void setSkipId(String skipId) {
        this.skipId = skipId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
