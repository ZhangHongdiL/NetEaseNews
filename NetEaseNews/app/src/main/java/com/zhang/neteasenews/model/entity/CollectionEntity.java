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
    private String url;

    public CollectionEntity() {

    }

    public CollectionEntity(String user, String title, String url) {
        this.user = user;
        this.title = title;
        this.url = url;
    }

    public CollectionEntity(int id, String user, String title, String url) {
        this.id = id;
        this.user = user;
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
