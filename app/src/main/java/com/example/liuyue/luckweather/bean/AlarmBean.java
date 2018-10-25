package com.example.liuyue.luckweather.bean;

import com.example.liuyue.luckweather.R;

public class AlarmBean {
    private String title;
    private String message;
    private String remind;

    public int getImage() {
        if (title.contains("红")){
            return R.drawable.ic_alarm_red;
        }else if (title.contains("黄")){
            return R.drawable.ic_alarm_yellow;
        }else if (title.contains("橙")){
            return R.drawable.ic_alarm_orange;
        }else {
            return R.drawable.ic_alarm_blue;
        }
    }

    public String getTitle() {
        return title;
    }

    public AlarmBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AlarmBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getRemind() {
        return remind;
    }

    public AlarmBean setRemind(String remind) {
        this.remind = remind;
        return this;
    }

}
