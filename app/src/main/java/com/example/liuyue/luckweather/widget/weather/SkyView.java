package com.example.liuyue.luckweather.widget.weather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.liuyue.luckweather.R;
import com.example.liuyue.luckweather.utils.Constant;
import com.example.liuyue.luckweather.utils.DateTimeUtil;
import com.example.liuyue.luckweather.utils.PictureUtil;


public class SkyView extends FrameLayout {


    LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private String weather, oldWeather = "";
    private String sunrise = "06:00", sunset = "18:00";
    private Context context;
    private BaseAnimView baseView;
    private Bitmap bitmap;

    public Bitmap getBackgroundBitmap(){
        return bitmap;
    }

    public SkyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(getResources().getColor(R.color.clear_sky_day_start));
        this.context = context;
    }

    public SkyView(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(R.color.clear_sky_day_start));
        this.context = context;

    }

    public SkyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(getResources().getColor(R.color.clear_sky_day_start));
        this.context = context;
    }


    public void setWeather(String weather, String sunrise, String sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.weather = weather;
        refreshView();
    }

    public void setWeather(String weather) {
        this.weather = weather;
        refreshView();
    }

    @SuppressLint("ResourceAsColor")
    private void refreshView() {

        if (oldWeather.equals(weather)) {
            baseView.reset();
            return;
        }
        oldWeather = weather;

        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                View childView = getChildAt(i);
                if (childView instanceof BaseAnimView) {
                    ((BaseAnimView) childView).callStop();
                }
            }
        }

        this.removeAllViews();
        if (baseView != null) {
            baseView = null;
        }

        boolean isNight = DateTimeUtil.isNight(sunrise, sunset);

        if (weather.equals("晴")) {

            if (isNight) {
                bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_sun_night, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
                baseView = new SunnyNightView(context, bitmap);
            } else {
                bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_sun_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
                baseView = new SunnyDayView(context, bitmap);
            }

            addView(baseView, layoutParams);
            return;
        }
        if (weather.equals("多云")) {
            bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_cloud_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
            baseView = new CloudyView(context, bitmap);
            addView(baseView, layoutParams);
            return;
        }
        if (weather.contains("雨") || weather.contains("雪")) {

            if (weather.contains("雨") && !weather.contains("雪")) {
                bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_rain_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
                baseView = new RainSnowHazeView(context, RainSnowHazeView.Type.RAIN, bitmap);
            } else if (!weather.contains("雨") && weather.contains("雪")) {
                bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_snow_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
                baseView = new RainSnowHazeView(context, RainSnowHazeView.Type.SNOW, bitmap);
            } else {
                bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_rain_rand_snow_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
                baseView = new RainSnowHazeView(context, RainSnowHazeView.Type.RAIN_SNOW, bitmap);
            }
            addView(baseView, layoutParams);
            return;
        }
        if (weather.equals("霾") || weather.equals("浮尘") || weather.equals("扬沙")) {
            bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_haze_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
            baseView = new RainSnowHazeView(context, RainSnowHazeView.Type.HAZE, bitmap);
            addView(baseView, layoutParams);
            return;
        }
        if (weather.contains("阴")) {
            bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_yin_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
            baseView = new CloudyView(context, bitmap);
            addView(baseView, layoutParams);
            return;
        }
        if (weather.contains("雾")) {
            bitmap= PictureUtil.resizeWidthAndHeight(getResources(),R.drawable.bg_fog_day, Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
            baseView = new FogView(context, bitmap);
            addView(baseView, layoutParams);
            return;
        }
    }


}
