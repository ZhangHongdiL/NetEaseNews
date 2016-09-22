package com.zhang.neteasenews.model.entity.subentity;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面的图片页的实体类
 */
public class PictureEntity {

    /**
     * desc : 2016年9月20日，上海，崔恒义，一位58岁的上海老人，在浦东有房有家，却十多年住在街头靠捡垃圾收养流浪狗，28年间救助了3000条流浪狗。东方IC
     * pvnum :
     * createdate : 2016-09-22 11:42:13
     * scover : http://img4.cache.netease.com/photo/0096/2016-09-22/s_C1IK3DK254GI0096.jpg
     * setname : 上海大叔拾荒10年收容3000流浪狗
     * cover : http://img4.cache.netease.com/photo/0096/2016-09-22/C1IK3DK254GI0096.jpg
     * pics : ["http://img4.cache.netease.com/photo/0096/2016-09-22/C1IK3DJS54GI0096.jpg","http://img4.cache.netease.com/photo/0096/2016-09-22/C1IK3DJT54GI0096.jpg","http://img4.cache.netease.com/photo/0096/2016-09-22/C1IK3DJU54GI0096.jpg"]
     * clientcover1 : http://img4.cache.netease.com/photo/0096/2016-09-22/C1IK3DK254GI0096.jpg
     * replynum : 8614
     * topicname :
     * setid : 108978
     * seturl : http://help.3g.163.com/photoview/54GI0096/108978.html
     * datetime : 2016-09-22 11:42:16
     * clientcover :
     * imgsum : 10
     * tcover : http://img4.cache.netease.com/photo/0096/2016-09-22/t_C1IK3DK254GI0096.jpg
     */

    private String desc;
    private String pvnum;
    private String createdate;
    private String scover;
    private String setname;
    private String cover;
    private String clientcover1;
    private String replynum;
    private String topicname;
    private String setid;
    private String seturl;
    private String datetime;
    private String clientcover;
    private String imgsum;
    private String tcover;
    private List<String> pics;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPvnum() {
        return pvnum;
    }

    public void setPvnum(String pvnum) {
        this.pvnum = pvnum;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getScover() {
        return scover;
    }

    public void setScover(String scover) {
        this.scover = scover;
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getClientcover1() {
        return clientcover1;
    }

    public void setClientcover1(String clientcover1) {
        this.clientcover1 = clientcover1;
    }

    public String getReplynum() {
        return replynum;
    }

    public void setReplynum(String replynum) {
        this.replynum = replynum;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getSetid() {
        return setid;
    }

    public void setSetid(String setid) {
        this.setid = setid;
    }

    public String getSeturl() {
        return seturl;
    }

    public void setSeturl(String seturl) {
        this.seturl = seturl;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getClientcover() {
        return clientcover;
    }

    public void setClientcover(String clientcover) {
        this.clientcover = clientcover;
    }

    public String getImgsum() {
        return imgsum;
    }

    public void setImgsum(String imgsum) {
        this.imgsum = imgsum;
    }

    public String getTcover() {
        return tcover;
    }

    public void setTcover(String tcover) {
        this.tcover = tcover;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }
}
