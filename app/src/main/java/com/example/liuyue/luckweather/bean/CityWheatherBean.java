package com.example.liuyue.luckweather.bean;

import com.example.liuyue.luckweather.R;

public class CityWheatherBean {
    private int icon;
    private String city;
    private String weather;
    private String temp;
    private String time;

    public String getTime() {
        return time;
    }

    public CityWheatherBean setTime(String time) {
        this.time = time;
        return this;
    }

    public int getIcon(){
        if (weather.contains("晴")){
            return R.drawable.bg_card_sun;
        }else if (weather.contains("雨")&&weather.contains("雪")){
            return R.drawable.bg_card_rain_and_snow;
        }else if (weather.contains("雨")){
            return R.drawable.bg_card_rain;
        }else if (weather.contains("雪")){
            return R.drawable.bg_card_snow;
        }else if (weather.contains("多云")){
            return R.drawable.bg_card_cloud;
        }else if (weather.contains("雷")){
            return R.drawable.bg_card_thunder;
        }else if (weather.contains("霾")){
            return R.drawable.bg_card_haze;
        }else {
            return R.drawable.bg_card_cloud;
        }
    }

    public String getCity() {
        return city;
    }

    public CityWheatherBean setCity(String city) {
        this.city = city;
        return this;
    }

    public String getWeather() {
        return weather;
    }

    public CityWheatherBean setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public String getTemp() {
        return temp;
    }

    public CityWheatherBean setTemp(String temp) {
        this.temp = temp;
        return this;
    }


    @Override
    public String toString() {
        return "CityWheatherBean{" +
                "icon=" + icon +
                ", city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
