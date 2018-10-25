package com.example.liuyue.luckweather.utils;

import android.content.Context;
import android.location.LocationListener;
import android.util.Log;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol;
import com.amap.api.location.AMapLocationListener;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class GpsUtil {

    //百度
    private LocationClient bdLocationClient;
    private Context context = null;
    //高德
    private AMapLocationClient aMapLocationClient = null;
    private AMapLocationClientOption aMapLocationClientOption = null;

    /**
     * 初始化
     */
    public GpsUtil(Context ctx, BDLocationListener bdLocationListener, AMapLocationListener gdLocationListener) {
        //百度定位
        context = ctx;
        try {
            bdLocationClient = new LocationClient(context.getApplicationContext());
            bdLocationClient.registerLocationListener(bdLocationListener);    //注册监听函数
            bdLocationClient.start();
        } catch (Exception e) {
            Log.e("GpsUtil error : ", e.getMessage(), e);
        }

        //高德定位
        aMapLocationClient = new AMapLocationClient(context);
        aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClient.setLocationListener(gdLocationListener);

        //初始化配置
        initLocation();
    }

    public void stop() {
        bdLocationClient.stop();
        aMapLocationClient.stopLocation();
    }

    public void start() {
        bdLocationClient.start();
        aMapLocationClient.startLocation();
    }

    private void initLocation() {
        //百度定位
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        //option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        //int span=1000;
        //option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        //option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        //option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        //option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(true);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        bdLocationClient.setLocOption(option);

        //高德定位
        aMapLocationClientOption.setLocationMode(AMapLocationMode.Battery_Saving);
//        locationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
//        locationOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
//        locationOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
//        locationOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        aMapLocationClientOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        aMapLocationClientOption.setOnceLocation(true);//可选，设置是否单次定位。默认是false
//        locationOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
//        AMapLocationClientOption.setLocationProtocol(AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
//        locationOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
//        locationOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
//        locationOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        aMapLocationClientOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.ZH);//可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
    }
}
