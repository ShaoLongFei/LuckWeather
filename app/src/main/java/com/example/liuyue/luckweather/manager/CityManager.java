package com.example.liuyue.luckweather.manager;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.liuyue.luckweather.bean.CityCodeBean;
import com.example.liuyue.luckweather.bean.CityWheatherBean;
import com.example.liuyue.luckweather.utils.Constant;
import com.example.liuyue.luckweather.utils.HttpRetriever;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
