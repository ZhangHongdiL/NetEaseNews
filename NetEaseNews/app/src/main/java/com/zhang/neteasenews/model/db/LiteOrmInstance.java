package com.zhang.neteasenews.model.db;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.zhang.neteasenews.model.entity.CollectionEntity;
import com.zhang.neteasenews.ui.app.NetEaseNewsApp;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 数据库操作的单例类
 */
public class LiteOrmInstance {

    private static LiteOrmInstance instance;

    /**
     * LiteOrm对象
     */
    private LiteOrm liteOrm;
    /**
     * 数据库名
     */
    private static final String DB_NAME = "collection.db";

    private LiteOrmInstance(){
        liteOrm = LiteOrm.newSingleInstance(NetEaseNewsApp.getContext(), DB_NAME);
    }

    public static LiteOrmInstance getInstance() {
        if (instance == null) {
            synchronized (LiteOrmInstance.class) {
                if (instance == null) {
                    instance = new LiteOrmInstance();
                }
            }
        }
        return instance;
    }

    //========================增删改查=================================
    /**
     * 插入一条数据的方法
     */
    public void insert(CollectionEntity collectionEntity) {
        liteOrm.insert(collectionEntity);
    }

    /**
     * 插入集合数据
     */
    public void insert(List<CollectionEntity> ces) {
        liteOrm.insert(ces);
    }

    /**
     * 查询所有数据的方法
     */
    public void queryAll() {
        liteOrm.query(CollectionEntity.class);
    }

    /**
     * 按条件查询的方法(根据新闻标题)
     */
    public List<CollectionEntity> queryByTitle(String title) {
        QueryBuilder<CollectionEntity> qb = new QueryBuilder<>(CollectionEntity.class);
        qb.where("title = ?", new String[]{title});
        return liteOrm.query(qb);
    }

    /**
     * @param title
     * @param start
     * @param end  限制使用的条目
     * @return
     */
    public List<CollectionEntity> queryByTitle(String title, int start, int end) {
        QueryBuilder<CollectionEntity> qb = new QueryBuilder<>(CollectionEntity.class);
        qb.where("title = ?", new String[]{title});
        qb.limit(start, end);
        return liteOrm.query(qb);
    }

    /**
     * 按条件删除
     */
    public void deleteByTile(String title) {
        WhereBuilder wb = new WhereBuilder(CollectionEntity.class, "title = ?", new String[]{title});
        liteOrm.delete(wb);
    }

    /**
     * 删除所有数据
     */
    public void deleteAll(){
        liteOrm.deleteAll(CollectionEntity.class);
    }
}
