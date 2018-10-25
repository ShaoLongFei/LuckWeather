package com.example.liuyue.luckweather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liuyue.luckweather.R;
import com.example.liuyue.luckweather.bean.ZhiShuBean;
import com.example.liuyue.luckweather.bean.ZhiShuSetBean;
import com.example.liuyue.luckweather.ui.adapter.ZhiShuAdapter;
import com.example.liuyue.luckweather.ui.adapter.ZhiShuSetAdapter;
import com.example.liuyue.luckweather.utils.Constant;
import com.example.liuyue.luckweather.utils.SharePrefUtil;
import com.example.liuyue.luckweather.utils.TitleBarUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetActivity extends AppCompatActivity{

    private List<ZhiShuSetBean> zhiShuSetBeanList=new ArrayList();
    private ListView listView;
    private ZhiShuSetAdapter zhiShuSetAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TitleBarUtil.setStatusBarColor(this,R.color.clear_sky_day_start);
        setContentView(R.layout.activity_set);
        Slide slide=new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);
        Set<String> zhiShuSet= SharePrefUtil.getSetString(getBaseContext(),SharePrefUtil.zhishu, Constant.DEFAULT_ZHISHU);
        for (String item:Constant.ZHISHU_NAMES){
            if (zhiShuSet.contains(item)){
                zhiShuSetBeanList.add(new ZhiShuSetBean().setName(item).setIscheck(true));
            }else {
                zhiShuSetBeanList.add(new ZhiShuSetBean().setName(item).setIscheck(false));
            }
        }

        listView=findViewById(R.id.zhishu_set_list);
        zhiShuSetAdapter=new ZhiShuSetAdapter(this,zhiShuSetBeanList);
        listView.setAdapter(zhiShuSetAdapter);

        findViewById(R.id.titlebar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                finish();
            }
        });

        ((TextView)findViewById(R.id.titlebar_title)).setText("栏目设置");

    }

    private void saveData() {
        List<ZhiShuBean> zhiShuBeanList=new ArrayList<>();
        for (ZhiShuSetBean zhiShuSetBean:zhiShuSetBeanList){
            if (zhiShuSetBean.getIscheck()){
                zhiShuBeanList.add(new ZhiShuBean().setName(zhiShuSetBean.getName()));
            }
        }
        Intent intent = new Intent();
        intent.putExtra("result", (Serializable) zhiShuBeanList);
        setResult(Constant.INTENT_RESULT_SET, intent);
    }

    @Override
    public void onBackPressed() {
        saveData();
        super.onBackPressed();
    }
}
