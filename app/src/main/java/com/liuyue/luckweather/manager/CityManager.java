package com.liuyue.luckweather.manager;

import android.content.Context;
import android.os.Handler;

import com.alibaba.fastjson.JSONObject;
import com.liuyue.luckweather.bean.CityWheatherBean;
import com.liuyue.luckweather.utils.Constant;
import com.liuyue.luckweather.utils.HttpRetriever;


public class CityManager extends BaseManager{

    private String TAG=CityManager.class.getSimpleName();
    public CityManager(Context context) {
        super(context);
    }

    public void searchWeatherByCity(final String city,final Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String urlCityWeather=String.format(Constant.URL_REALTIME_HEFENG,city);
                String cityWeatherRsponse= HttpRetriever.retrieve(urlCityWeather);
                JSONObject jsonObject= JSONObject.parseObject(cityWeatherRsponse).getJSONArray("HeWeather6").getJSONObject(0);
                String time=jsonObject.getJSONObject("update").getString("loc");
                String weather=jsonObject.getJSONObject("now").getString("cond_txt");
                String temp=jsonObject.getJSONObject("now").getString("tmp");
                CityWheatherBean cityWheatherBean=new CityWheatherBean()
                        .setCity(city)
                        .setTemp(temp)
                        .setTime(time)
                        .setWeather(weather);
                sendMessage(handler,cityWheatherBean);

            }
        }).start();
    }
}
