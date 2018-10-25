package com.example.liuyue.luckweather.bean;

public class City {
    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public City setCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    String name;
    String cityId;
}
