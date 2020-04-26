package com.liuyue.luckweather.bean;

import android.annotation.SuppressLint;
import android.content.res.Resources;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.utils.Constant;

import java.io.Serializable;
import java.util.Random;

public class ZhiShuBean implements Serializable{

    private String name;


    @SuppressLint("StringFormatMatches")
    public String getLink_url(Resources resources) {
        // http://m.zuimeitianqi.com/Phone/index/index.html?1=1&city=01011111&code1=0&temp=23/12&humi=65&wpow=1&wdir=6&code2=2&pres=932&ultr=-&visi=30&pm=优质&id=64&name=约会指数&level=3&lname=较适宜&lnum=4&desc=天气不会有太大的影响，你仍然可以有一个愉快的约会。
        // http://m.zuimeitianqi.com/Phone/index/index.html?code1=%s&#038; temp=%s&#038; wpow=%s&#038; wdir=%s&#038; pm=%s&#038; id=%s&#038; name=%s&#038; level=%s&#038; lname=%s&#038; lnum=5&#038; desc=%s
        if (Constant.ZHISHU_PART_NAMES.contains(name)){
            return String.format(resources.getString(R.string.activity_home_str_zhishu),
                    getWeatherId(),getTemp(),getWpow(),getDir(),getPm(),getViewId(name),
                    name,new Random().nextInt(5)+1,getLname(name),getDesc(name));
        }else {
            switch (name){
                case "卫星图":
                    return "http://m.nmc.cn/";
                case "笑话大全":
                    return "http://mread.huabian.com/api/tqt/xiaohua";
                case "星座运势":
                    return "http://m.go108.com.cn/shichang/cp/astro1/day.php?tqt";
                case "日历":
                    return "http://yun.rili.cn/wnl/m/index.html";
                case "钓鱼天气":
                    return "http://e.sportsweather.cn/fishing/#/";
                case "视频预报":
                    return "http://waptianqi.2345.com/html/tqbb/tqbb.htm";
                case "加号":
                    return "跳转设置";
            }
        }
        return "https://mread.huabian.com/api/tqt/xiaohua";
    }

    private String getDesc(String name) {
        switch (name){
            case "舒适指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(0).getTxt();
            case "穿衣指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(1).getTxt();
            case "感冒指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(2).getTxt();
            case "运动指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(3).getTxt();
            case "旅游指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(4).getTxt();
            case "紫外线指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(5).getTxt();
            case "洗车指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(6).getTxt();
            case "过敏指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(7).getTxt();
            default:
                return Constant.WEATHER_HEFENG.getLifestyle().get(0).getTxt();

        }
    }

    private String getLname(String name) {
        switch (name){
            case "舒适指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(0).getBrf();
            case "穿衣指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(1).getBrf();
            case "感冒指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(2).getBrf();
            case "运动指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(3).getBrf();
            case "旅游指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(4).getBrf();
            case "紫外线指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(5).getBrf();
            case "洗车指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(6).getBrf();
            case "过敏指数":
                return Constant.WEATHER_HEFENG.getLifestyle().get(7).getBrf();
            default:
                return Constant.WEATHER_HEFENG.getLifestyle().get(0).getBrf();

        }
    }

    private String getPm() {
        return Constant.WEATHER_FLYME.getPm25().getQuality();
    }

    private int getDir() {
        switch (Constant.WEATHER_HEFENG.getNow().getWind_dir()){
            case "微风":
                return 0;
            case "东北风":
                return 1;
            case "东风":
                return 2;
            case "东南风":
                return 3;
            case "南风":
                return 4;
            case "西南风":
                return 5;
            case "西风":
                return 6;
            case "西北风":
                return 7;
            case "北风":
                return 8;
            case "旋转风":
                return 9;
                default:
                    return 7;

        }
    }

    private String getWpow() {
        return Constant.WEATHER_HEFENG.getNow().getWind_sc();
    }

    private String getTemp(){
        return Constant.WEATHER_HEFENG.getDaily_forecast().get(0).getTmp_max()+"/"+Constant.WEATHER_HEFENG.getDaily_forecast().get(0).getTmp_min();
    }

    public String getName() {
        return name;
    }

    public ZhiShuBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getMsg() {
        if (Constant.ZHISHU_PART_NAMES.contains(name)){
            return getLname(name);
        }else {
            switch (name){
                case "卫星图":
                    return "卫星云图";
                case "笑话大全":
                    return "每日一笑";
                case "星座运势":
                    return "射手座";
                case "日历":
                    return "万年历";
                case "钓鱼天气":
                    return "钓鱼";
                case "视频预报":
                    return "天气预报";
                case "加号":
                    return "  ";
            }
        }
        return "笑话大全";
    }

    public int getImgResource() {
        switch (name){
            case "舒适指数":
                return R.drawable.ic_shushi_white;
            case "穿衣指数":
                return R.drawable.ic_chuanyi_white;
            case "感冒指数":
                return R.drawable.ic_ganmao_white;
            case "运动指数":
                return R.drawable.ic_yundong_white;
            case "旅游指数":
                return R.drawable.ic_lvyou_white;
            case "洗车指数":
                return R.drawable.ic_xiche_white;
            case "过敏指数":
                return R.drawable.ic_guomin_white;
            case "紫外线指数":
                return R.drawable.ic_ziwaixian_white;
            case "卫星图":
                return R.drawable.ic_weixing_white;
            case "笑话大全":
                return R.drawable.ic_xiaohua_white;
            case "星座运势":
                return R.drawable.ic_xingzuo_white;
            case "日历":
                return R.drawable.ic_rili_white;
            case "钓鱼天气":
                return R.drawable.ic_diaoyu_white;
            case "视频预报":
                return R.drawable.ic_shipin_white;
            case "加号":
                return R.drawable.ic_jiahao_white;
            default:
                return R.drawable.ic_jiahao_white;
        }
    }

    private int getWeatherId(){
        switch (Constant.WEATHER_HEFENG.getNow().getCond_txt()){
            case "晴":
                return 0;
            case "多云":
                return 1;
            case "阴":
                return 1;
            case "阵雨":
                return 2;
            case "雷阵雨":
                return 3;
            case "雨夹雪":
                return 5;
            case "小雨":
                return 6;
            case "中雨":
                return 7;
            case "大雨":
                return 8;
            case "暴雨":
                return 9;
            case "大暴雨":
                return 10;
            case "特大暴雨":
                return 11;
            case "阵雪":
                return 12;
            case "小雪":
                return 13;
            case "中雪":
                return 14;
            case "大雪":
                return 15;
            case "暴雪":
                return 16;
            case "雾":
                return 17;
            case "冻雨":
                return 18;
            case "沙尘暴":
                return 19;
            case "浮尘":
                return 28;
            case "扬沙":
                return 29;
            case "强沙尘暴":
                return 30;
            case "龙卷风":
                return 32;
            default:
                return 1;

        }
    }

    private int getViewId(String viewName){
        switch (viewName){
            case "洗车指数":
                return 4;
            case "感冒指数":
                return 3;
            case "旅游指数":
                return 6;
            case "运动指数":
                return 5;
            case "紫外线指数":
                return 10;
            case "舒适指数":
                return 51;
            case "过敏指数":
                return 11;
            case "穿衣指数":
                return 64;
            default:
                    return 64;

        }
    }




}
