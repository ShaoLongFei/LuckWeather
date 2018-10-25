package com.example.liuyue.luckweather.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.liuyue.luckweather.R;
import com.example.liuyue.luckweather.bean.CityWheatherBean;
import com.example.liuyue.luckweather.manager.CityManager;
import com.example.liuyue.luckweather.ui.MainActivity;
import com.example.liuyue.luckweather.widget.WeatherWdigetProvider;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class WdigetUpdateService extends Service {
    private static final int UPDATE = 1;
    private RemoteViews remoteViews;
    private CityWheatherBean cityWheatherBean=null;
    private Boolean isRegister=false;

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE:
                    updateTime();
                    updateWeather();
                    updateView();
                    break;
            }
        }
    };

    private BroadcastReceiver mTimePickerBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateTime();
            updateView();
        }
    };

    @SuppressLint("HandlerLeak")
    private void updateWeather() {
        remoteViews.setTextViewText(R.id.tv_temperature, cityWheatherBean.getTemp()+"℃");
        remoteViews.setTextViewText(R.id.tv_weather_text, cityWheatherBean.getWeather());
        remoteViews.setImageViewResource(R.id.iv_weather_icon, getIcon(cityWheatherBean.getWeather()));

        new CityManager(getBaseContext()).searchWeatherByCity(MainActivity.city.getName(),new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                cityWheatherBean=(CityWheatherBean) msg.obj;
            }
        });
    }

    private void updateView() {
        ComponentName componentName = new ComponentName(
                getApplicationContext(), WeatherWdigetProvider.class);
        AppWidgetManager.getInstance(getApplicationContext()).updateAppWidget(
                componentName, remoteViews);
    }

    private int getIcon(String weather) {
        if (weather.contains("晴")){
            return R.drawable.wic_sunny;
        }else if (weather.contains("雪")){
            return R.drawable.wic_snow;
        }else if (weather.contains("雨")){
            return R.drawable.wic_rain;
        }else if (weather.contains("多云")){
            return R.drawable.wic_cloudy;
        }else if (weather.contains("阴")) {
            return R.drawable.wic_yin;
        }else if (weather.contains("雷")){
            return R.drawable.wic_thunder;
        }else if (weather.contains("雾")||weather.contains("霾")){
            return R.drawable.wic_fog;
        }else {
            return R.drawable.wic_cloudy;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForeground(10010, new Notification());
        }

        if (!isRegister){
            IntentFilter updateIntent = new IntentFilter();
            updateIntent.addAction("android.intent.action.TIME_TICK");
            registerReceiver(mTimePickerBroadcast, updateIntent);
        }

        remoteViews = new RemoteViews("com.example.liuyue.luckweather", R.layout.widget);
        new CityManager(getBaseContext()).searchWeatherByCity(MainActivity.city.getName(),new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                cityWheatherBean=(CityWheatherBean) msg.obj;
                init();
            }
        });
    }

     public void init() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, 0);
        remoteViews.setOnClickPendingIntent(R.id.rl_wdiget, pendingIntent);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                msg.what = UPDATE;
                handler.sendMessage(msg);
            }
        },0,3600*500);

    }

    private void updateTime() {
        Date date = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String timeStr = df.format(date);
        Log.e("这样行吗",timeStr);
        remoteViews.setTextViewText(R.id.tv_date, timeStr.split(" ")[0]);
        remoteViews.setTextViewText(R.id.tv_time, timeStr.split(" ")[1]);
    }


    @Override
    public void onDestroy() {
        if (isRegister){
            unregisterReceiver(mTimePickerBroadcast);
        }
        Intent intent = new Intent(getApplicationContext(), WeatherWdigetProvider.class);
        getApplication().startService(intent);
        super.onDestroy();
    }


}
