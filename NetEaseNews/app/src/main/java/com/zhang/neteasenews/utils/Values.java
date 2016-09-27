package com.zhang.neteasenews.utils;

/**
 * Created by dllo on 16/9/13.
 * 常量类
 */
public class Values {
    private Values(){}

    /***********************网址****************************/

    /**
     * 新闻头条的接口
     */
    public static final String HEADLINEURL = "http://c.3g.163.com/recommend/getSubDocPic?tid=T1348647909107&from=toutiao&size=20&prog=NOHEAD&offset=0&fn=2&passport=&devId=44t6%2B5mG3ACAOlQOCLuIHg%3D%3D&lat=&lon=&version=14.2&net=wifi&ts=1473231158&sign=5GqzD5yFT920iQKTNOyR3MwCzQuzy%2Buhs6NuDA7CsyF48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=wandoujia_news&mac=";

    /**
     * 新闻精选的接口
     */
    public static final String CHOICENESSURL = "http://c.m.163.com/nc/article/list/T1467284926140/0-20.html";

    /**
     * 新闻娱乐的接口
     */
    public static final String AMUSEMENTURL = "http://c.m.163.com/nc/article/list/T1348648517839/0-20.html";

    /**
     * 新闻体育的接口
     */
    public static final String PHYSICALURL = "http://c.m.163.com/nc/article/list/T1348649079062/0-20.html";

    /**
     * 新闻视频的接口
     */
    public static final String VIDEOURL = "http://c.3g.163.com/recommend/getChanListNews?channel=T1457068979049&size=10&offset=0&fn=2&passport=&devId=44t6%2B5mG3ACAOlQOCLuIHg%3D%3D&lat=&lon=&version=14.2&net=wifi&ts=1474540981&sign=CSZnTDA7E%2B%2FpWniX0HR2j2%2F%2FmXOcKxmUgk8uLzb6ohx48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=wandoujia_news&mac=3Fg2bhJMR1xtVeOmVPRkSIe1A3IUPLLdoCiqBVf2Go0%3D";

    /**
     * 新闻财经的接口
     */
    public static final String FINANCEURL = "http://c.m.163.com/nc/article/list/T1348648756099/0-20.html";

    /**
     * 新闻科技的接口
     */
    public static final String TECHNOLOGYURL = "http://c.m.163.com/nc/article/list/T1348649580692/0-20.html";

    /**
     * 新闻汽车的接口
     */
    public static final String CARURL = "http://c.m.163.com/nc/auto/list/5YWo5Zu9/0-20.html";

    /**
     * 新闻时尚的接口
     */
    public static final String FASHION = "http://c.m.163.com/nc/article/list/T1348650593803/0-20.html";

    /**
     * 新闻图片的接口
     */
    public static final String PICTUREURL = "http://c.m.163.com/photo/api/list/0096/4GJ60096.json";

    /**
     * 新闻热帖的接口
     */
    public static final String HOTURL = "http://c.m.163.com/nc/article/house/5YyX5Lqs/0-20.html";

    /**
     * 新闻房产的接口
     */
    public static final String HOUSEURL = "http://c.m.163.com/nc/article/house/5YyX5Lqs/0-20.html";

    /**
     * 新闻轻松一刻的接口
     */
    public static final String FUNTIMEURL = "http://c.m.163.com/nc/article/list/T1350383429665/0-20.html";

    /**
     * 新闻段子的接口
     */
    public static final String CROSSTALKURL = "http://c.3g.163.com/recommend/getChanListNews?channel=T1419316284722&size=20&offset=0&fn=1&passport=&devId=44t6%2B5mG3ACAOlQOCLuIHg%3D%3D&lat=&lon=&version=14.2&net=wifi&ts=1474185043&sign=ocJU3mnUGTFYMwf1ZFDf6g9HzhmncxoPCfvGbKSf4f548ErR02zJ6%2FKXOnxX046I&encryption=1&canal=wandoujia_news&mac=3Fg2bhJMR1xtVeOmVPRkSIe1A3IUPLLdoCiqBVf2Go0%3D";

    /**
     * 新闻军事的接口
     */
    public static final String WARURL = "http://c.m.163.com/nc/article/list/T1348648141035/0-20.html";

    /**
     * 新闻历史的接口
     */
    public static final String HISTORYURL = "http://c.m.163.com/nc/article/list/T1368497029546/0-20.html";

    /**
     * 直播的接口
     */
    public static final String LIVEURL = "http://c.m.163.com/nc/live/list/5YWo5Zu9/0-20.html";

    /**
     * 话题界面问吧的接口
     */
    public static final String ASKURL = "http://c.3g.163.com/newstopic/list/expert/YWxs/0-10.html";

    public static final String FICATIONURL = "http://c.3g.163.com/newstopic/list/classification.html";

    /**
     * 话题界面话题的接口
     */
    public static final String THEMEURL = "http://topic.comment.163.com/topic/list/subject/0-10.html";

    /***********************常量****************************/
    /**
     * 轮播图时间常量
     */
    public static final int TIME = 3000;

    /**
     * 新闻界面精选的常量类
     */
    public static final int CH_TYPE_ROTATE = 0;
    public static final int CH_TYPE_NORMAL = 1;
    public static final int CH_TYPE_ONEIMG = 2;
    public static final int CH_TYPE_THREEIMG = 3;

    /**
     * 新闻界面图片的常量
     */
    public static final int PICTURE_TYPE_ONE = 0;
    public static final int PICTURE_TYPE_THREE = 1;

    /**
     * 话题界面话题的常量
     */
    public static final int THEME_TWO = 0;
    public static final int THEME_THREE = 1;
    public static final int THEME_POSITION = 2;

    /**
     * 下拉刷新的常量
     */
    public static final int RELEASE_TO_REFRESH = 0; // 下拉过程的状态值
    public static final int PULL_TO_REFRESH = 1;  // 从下拉返回到不刷新的状态值
    public static final int REFRESHING = 2;   // 正在刷新的状态值
    public static final int DONE = 3;
    public static final int LOADING = 4;

    public static final int RATIO = 3; // 实际padding的距离与界面上移偏移量的比例
}
