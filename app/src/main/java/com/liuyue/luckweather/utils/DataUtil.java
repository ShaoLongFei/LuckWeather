package com.liuyue.luckweather.utils;

import com.liuyue.luckweather.bean.WeatherHefeng;
import com.liuyue.luckweather.widget.WeekForcastView.AirLevel;
import com.liuyue.luckweather.widget.WeekForcastView.WeekWeatherModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<WeekWeatherModel> loadWeekWeatherModel(List<WeatherHefeng.HeWeather6Bean.DailyForecastBean> dailyForecastBeanList){
        List<WeekWeatherModel> weekWeatherModelList=new ArrayList<>();
        for (WeatherHefeng.HeWeather6Bean.DailyForecastBean dailyForecastBean:dailyForecastBeanList){
            WeekWeatherModel weekWeatherModel=new WeekWeatherModel();
            weekWeatherModel.setDate(dailyForecastBean.getDate().substring(5).replace("-","/"));
            try {
                weekWeatherModel.setWeek(DateTimeUtil.getWeekOfDate(DateTimeUtil.getDateFromStr(dailyForecastBean.getDate())));
            } catch (ParseException e) {
                weekWeatherModel.setWeek("星期三");
            }
            weekWeatherModel.setDayWeather(dailyForecastBean.getCond_txt_d())
                    .setDayTemp(dailyForecastBean.getTmp_max())
                    .setNightTemp(dailyForecastBean.getTmp_min())
                    .setNightWeather(dailyForecastBean.getCond_txt_n())
                    .setWindOrientation(dailyForecastBean.getWind_dir())
                    .setWindLevel(dailyForecastBean.getWind_sc()+"级")
                    .setAirLevel(AirLevel.EXCELLENT);
            weekWeatherModelList.add(weekWeatherModel);
        }
        return weekWeatherModelList;
    }
}
