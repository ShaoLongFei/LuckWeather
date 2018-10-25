package com.example.liuyue.luckweather.ui;


import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyue.luckweather.R;
import com.example.liuyue.luckweather.bean.CitySelectBean;
import com.example.liuyue.luckweather.ui.adapter.AutoCompleteTextAdapter;
import com.example.liuyue.luckweather.utils.Constant;
import com.example.liuyue.luckweather.utils.TitleBarUtil;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CitySelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridViewhotCity;
    private List<Map<String, Object>> dataList;
    private TextView tv_hotCityText;
    private ArrayList<CitySelectBean> resultsList;


    //搜索提示控件
    private AutoCompleteTextView auto_seektips;
    //热门城市
    private final String[] HotCityName = {"北京", "上海", "南京", "广州", "深圳", "西安", "沈阳", "成都", "佛山", "重庆", "武汉", "郑州", "太原", "石家庄", "长春", "青岛"
            , "天津", "昆明"};
    //热门城市适配器
    private SimpleAdapter hotCityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TitleBarUtil.setStatusBarColor(this, R.color.clear_sky_day_start);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);

        Slide slide=new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);

        //将控件实例化
        gridViewhotCity = findViewById(R.id.gd_hotcity);
        auto_seektips = findViewById(R.id.auto_seekTips);
        tv_hotCityText = findViewById(R.id.tv_hotCitytext);
        ((TextView)findViewById(R.id.titlebar_title)).setText("城市选择");
        findViewById(R.id.titlebar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //获取资源的名字
        XmlResourceParser xmlParser = this.getResources().getXml(R.xml.string);
        resultsList=Parserxml(xmlParser);

        AutoCompleteTextAdapter adapter=new AutoCompleteTextAdapter(resultsList, this);
        auto_seektips.setAdapter(adapter);

        dataList = new ArrayList<>();
        getData();
        //热门城市的适配器
        hotCityAdapter = new SimpleAdapter(this, dataList, R.layout.hot_city_item, new String[]{"text"}, new int[]{R.id.tv_hotcity});
        gridViewhotCity.setAdapter(hotCityAdapter);
        gridViewhotCity.setOnItemClickListener(this);
        auto_seektips.setOnItemClickListener(this);
        //AutoCompleteTextView控件的点击事件
        auto_seektips.addTextChangedListener(new TextWatcher() {
            @Override//改变之前
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override//改变时
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override//改变后
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(auto_seektips.getText())) {
                    tv_hotCityText.setVisibility(View.GONE);
                    gridViewhotCity.setVisibility(View.GONE);
                } else {
                    tv_hotCityText.setVisibility(View.VISIBLE);
                    gridViewhotCity.setVisibility(View.VISIBLE);
                }
            }
        });
        auto_seektips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取到过滤后的结果的集合
                auto_seektips.setText("");
                ArrayList<CitySelectBean> results=AutoCompleteTextAdapter.newvalues;
                CitySelectBean result=results.get(position);
                Intent intent = new Intent();
                intent.putExtra("city", result.getCity());
                intent.putExtra("district",result.getDistrict());
                setResult(Constant.INTENT_RESULT_CITY, intent);
                finish();
            }
        });

    }

    //将热门城市添加到集合中
    private void getData() {
        for (int i = 0; i < HotCityName.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("text", HotCityName[i]);
            dataList.add(map);
        }
    }

    @Override//热门城市的点击事件
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("city", HotCityName[position]);
        intent.putExtra("district",HotCityName[position]);
        setResult(Constant.INTENT_RESULT_CITY, intent);
        finish();
    }

    //省市县的XML数据解析
    public ArrayList<CitySelectBean> Parserxml(XmlPullParser parser) {

        ArrayList<CitySelectBean> cityArray = new ArrayList<>();
        CitySelectBean resultTemp = null;
        String province = null, city = null, district = null;

        try {
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        //给当前的标签起一个名字
                        String tagName = parser.getName();
                        if (tagName.equals("resources")){

                        }else if (tagName.equals("item")) {
                            resultTemp = new CitySelectBean();
                        }else if(tagName.equals("id")){

                        }else if (tagName.equals("province")) {
                            province = parser.nextText();
                        } else if (tagName.equals("city")) {
                            city = parser.nextText();
                        } else if (tagName.equals("district")) {
                            district = parser.nextText();
                            resultTemp.setPrivance(province);
                            resultTemp.setCity(city);
                            resultTemp.setDistrict(district);
                            cityArray.add(resultTemp);
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                }
                eventType=parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityArray;
    }


}
