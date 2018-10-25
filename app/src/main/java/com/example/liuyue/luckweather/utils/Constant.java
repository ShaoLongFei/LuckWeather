package com.example.liuyue.luckweather.utils;

import android.Manifest;

import com.example.liuyue.luckweather.bean.WeatherFlyme;
import com.example.liuyue.luckweather.bean.WeatherHefeng;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Constant {

    public final static int MSG_ERROR = 0;
    public final static int MSG_SUCCESS = 1;

    public final static int INTENT_REQUEST_SET=0;
    public final static int INTENT_RESULT_SET=1;
    public final static int INTENT_REQUEST_CITY=3;
    public final static int INTENT_RESULT_CITY=4;

    //未来七天天气预报
    public static final String URL_FORECAST_JUHE =
            "http://v.juhe.cn/weather/index?format=2&cityname=%s&key=60840102c71a2cb8c0f050fb54d44ca3";
    //未来七天天气，每天三条信息
    public static final String URL_FORECAST_AFANDA=
            "https://api.avatardata.cn/Weather/Query?key=aa8da5b68b464d448b55286bba8284f9&cityname=%E6%AD%A6%E6%B1%89";
    //逐小时预报
    public static final String URL_FORECAST_FLYME =
            "http://res.aider.meizu.com/1.0/weather/%s.json";
    //未来七天天气(带日出日落)
    public static final String URL_FORECAST_HEFENG=
            "https://free-api.heweather.com/s6/weather?location=%s&key=8ae2581e738141d8b9969194c648a405";
    //实时天气
    public static final String URL_REALTIME_HEFENG=
            "https://free-api.heweather.com/s6/weather/now?location=%s&key=8ae2581e738141d8b9969194c648a405";
    //空气质量
    public static final String URL_AQI_HEFENG=
            "https://free-api.heweather.com/s6/air/now?location=%s&key=8ae2581e738141d8b9969194c648a405";
    //日出日落月出月落
    public static final String URL_SUNANDMOON_HEFENG=
            "https://free-api.heweather.com/s6/solar/sunrise-sunset?location=%s&key=8ae2581e738141d8b9969194c648a405";
    //城市代码
    public static final String URL_CITYCODE=
            "http://api.shujuzhihui.cn/api/weather/city?appKey=164503039fd94aaa9825e45352f06053&city=%s";
    //翻译
    public static final String URL_TRANSLATE=
            "https://fanyi.baidu.com/transapi?query=%s";

    //每日寄语
    public static final String URL_MOTTO= "http://open.iciba.com/dsapi/";
    public static final String defaultMotto="Time is a bird for ever on the wing\n时间是一只永远在飞翔的鸟";

    //屏幕宽高
    public static int SCREEN_WIDTH = 0;
    public static int SCREEN_HEIGHT=0;

    //生活指数
    public final static List<String> ZHISHU_NAMES;
    public final static List<String> ZHISHU_PART_NAMES;
    public final static Set<String> DEFAULT_ZHISHU=new HashSet();

    //周报参数
    public static int UI_WIDTH = SCREEN_WIDTH;
    public static int UI_HEIGHT = SCREEN_HEIGHT;
    public static int UI_DENSITY = 4;

    //全局天气数据
    public static WeatherHefeng.HeWeather6Bean WEATHER_HEFENG;
    public static WeatherFlyme WEATHER_FLYME;

    //关心天气
    public static List<String> CARE_WEATHERS= Arrays.asList("中雨","大雨","中雪","大雪","冰雹","扬沙","雨夹雪","沙尘暴");

    //权限
    public static String[] PERMISSIONS=new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_CONTACTS,
            Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS,Manifest.permission.READ_PHONE_STATE};

    static {
        ZHISHU_NAMES= Arrays.asList("舒适指数","穿衣指数","感冒指数","运动指数",
                "旅游指数","洗车指数","过敏指数","紫外线指数","卫星图","笑话大全","星座运势","日历","钓鱼天气","视频预报");
        ZHISHU_PART_NAMES=Arrays.asList("舒适指数","穿衣指数","感冒指数","运动指数",
                "旅游指数","洗车指数","过敏指数","紫外线指数");
        DEFAULT_ZHISHU.addAll((List)Arrays.asList("舒适指数","感冒指数","穿衣指数","紫外线指数","卫星图","笑话大全","视频预报"));
    }



}
