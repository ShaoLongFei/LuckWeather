package com.example.liuyue.luckweather.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liuyue.luckweather.R;
import com.example.liuyue.luckweather.bean.AlarmBean;
import com.example.liuyue.luckweather.bean.WeatherFlyme;
import com.example.liuyue.luckweather.ui.adapter.AlarmAdapter;
import com.example.liuyue.luckweather.utils.Constant;
import com.example.liuyue.luckweather.utils.TitleBarUtil;

import java.util.ArrayList;
import java.util.List;

public class AlarmActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TitleBarUtil.setStatusBarColor(this,R.color.clear_sky_day_start);
        setContentView(R.layout.activity_alarm_info);
        Slide slide=new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);
        List<AlarmBean> alarmBeanList=new ArrayList();
        for (WeatherFlyme.AlarmsBean alarmsBean: Constant.WEATHER_FLYME.getAlarms()){
            alarmBeanList.add(new AlarmBean()
                    .setTitle(alarmsBean.getAlarmTypeDesc())
                    .setMessage(alarmsBean.getAlarmContent())
                    .setRemind(alarmsBean.getPrecaution()));
        }
        ((ListView)findViewById(R.id.alarm_list)).setAdapter(new AlarmAdapter(this,alarmBeanList));
        findViewById(R.id.titlebar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView)findViewById(R.id.titlebar_title)).setText("天气预警");

    }
}
