package com.example.liuyue.luckweather.bean;

/**
 * Created by 流月 on 2018/4/18.
 *
 * @description
 */

public class EventMessage {
    public String key;
    public Object value;
    public String extraInfo="";

    public EventMessage(String key, Object value, String extraInfo) {
        this.key = key;
        this.value = value;
        this.extraInfo=extraInfo;
    }

    public EventMessage(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
