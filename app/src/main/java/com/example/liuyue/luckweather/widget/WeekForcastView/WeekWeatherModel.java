package com.example.liuyue.luckweather.widget.WeekForcastView;

/**
 * Model of weather
 * @author Zz
 * 2016/12/8 9:42
 */
public class WeekWeatherModel {

    private int dayTemp;
    private int nightTemp;
    private String dayWeather;
    private String nightWeather;
    private String date;
    private String week;
    private boolean isToday;

    public int getDayTemp() {
        return dayTemp;
    }

    public WeekWeatherModel setDayTemp(int dayTemp) {
        this.dayTemp = dayTemp;
        return this;
    }

    public int getNightTemp() {
        return nightTemp;
    }

    public WeekWeatherModel setNightTemp(int nightTemp) {
        this.nightTemp = nightTemp;
        return this;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public WeekWeatherModel setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
        return this;
    }

    public String getNightWeather() {
        return nightWeather;
    }

    public WeekWeatherModel setNightWeather(String nightWeather) {
        this.nightWeather = nightWeather;
        return this;
    }

    public String getDate() {
        return date;
    }

    public WeekWeatherModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getWeek() {
        return week;
    }

    public WeekWeatherModel setWeek(String week) {
        this.week = week;
        return this;
    }

    public boolean isToday() {
        return isToday;
    }

    public WeekWeatherModel setToday(boolean today) {
        isToday = today;
        return this;
    }

    public int getDayPic() {
        return dayPic;
    }

    public WeekWeatherModel setDayPic(int dayPic) {
        this.dayPic = dayPic;
        return this;
    }

    public int getNightPic() {
        return nightPic;
    }

    public WeekWeatherModel setNightPic(int nightPic) {
        this.nightPic = nightPic;
        return this;
    }

    public String getWindOrientation() {
        return windOrientation;
    }

    public WeekWeatherModel setWindOrientation(String windOrientation) {
        this.windOrientation = windOrientation;
        return this;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public WeekWeatherModel setWindLevel(String windLevel) {
        this.windLevel = windLevel;
        return this;
    }

    public AirLevel getAirLevel() {
        return airLevel;
    }

    public WeekWeatherModel setAirLevel(AirLevel airLevel) {
        this.airLevel = airLevel;
        return this;
    }

    private int dayPic;
    private int nightPic;
    private String windOrientation;
    private String windLevel;
    private AirLevel airLevel;

}
