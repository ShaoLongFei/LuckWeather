package com.liuyue.luckweather.bean;

public class WeatherSummary {
    WeatherHefeng weatherHefeng;

    public WeatherHefeng getWeatherHefeng() {
        return weatherHefeng;
    }

    public WeatherSummary setWeatherHefeng(WeatherHefeng weatherHefeng) {
        this.weatherHefeng = weatherHefeng;
        return this;
    }

    public WeatherFlyme getWeatherFlyme() {
        return weatherFlyme;
    }

    public WeatherSummary setWeatherFlyme(WeatherFlyme weatherFlyme) {
        this.weatherFlyme = weatherFlyme;
        return this;
    }

    WeatherFlyme weatherFlyme;
}
