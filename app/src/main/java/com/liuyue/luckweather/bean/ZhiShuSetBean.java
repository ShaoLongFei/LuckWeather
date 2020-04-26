package com.liuyue.luckweather.bean;

import java.io.Serializable;

public class ZhiShuSetBean implements Serializable {
    public String getName() {
        return name;
    }

    public ZhiShuSetBean setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public ZhiShuSetBean setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
        return this;
    }

    private String name;
    private Boolean ischeck;
}
