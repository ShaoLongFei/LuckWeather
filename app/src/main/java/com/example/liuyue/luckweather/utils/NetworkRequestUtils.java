package com.example.liuyue.luckweather.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.liuyue.luckweather.bean.City;
import com.example.liuyue.luckweather.bean.CityCodeBean;
import com.example.liuyue.luckweather.bean.CityWheatherBean;
import com.example.liuyue.luckweather.bean.EventMessage;
import com.example.liuyue.luckweather.bean.MottoBean;
import com.example.liuyue.luckweather.bean.WeatherFlyme;
import com.example.liuyue.luckweather.bean.WeatherHefeng;
import com.liuyue.myokhttp.MyCallBack;
import com.liuyue.myokhttp.MyOkHttp;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import okhttp3.Call;

/**
 * Created by 流月 on 2018/4/21.
 *
 * @description
 */

public class NetworkRequestUtils {

    public static MyOkHttp sMyOkHttp = null;

    public static enum EnumFactory {
        singletonFactory;

        private NetworkRequestUtils mNetworkRequestUtils = new NetworkRequestUtils();

        private EnumFactory() {
        }

        public NetworkRequestUtils getIntance() {
            return this.mNetworkRequestUtils;
        }
    }


    public void requestCityCode(final String city) {
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                MyOkHttp.EnumFactory.singletonFactory.getIntance().get(String.format(Constant.URL_CITYCODE,city), new MyCallBack<CityCodeBean>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        List<CityCodeBean.RESULTBean> resultBeanList=new ArrayList<CityCodeBean.RESULTBean>();
                        resultBeanList.add(new CityCodeBean.RESULTBean().setCity_id("101101010").setCity_name("五台山"));
                        CityCodeBean cityCodeBean=new CityCodeBean().setRESULT(resultBeanList);
                        EventBus.getDefault().post(new EventMessage("城市代码",cityCodeBean));
                    }

                    @Override
                    public void onSuccess(CityCodeBean cityCodeBean) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("城市代码",cityCodeBean));
                    }

                });
            }
        });
    }


    public void requestWeathersByCitys(final Set<String> citys){
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                List<CityWheatherBean> cityWheatherBeans = new ArrayList<>();
                for (String city:citys){
                    String urlCityWeather=String.format(Constant.URL_REALTIME_HEFENG,city);
                    String cityWeatherRsponse= HttpRetriever.retrieve(urlCityWeather);
                    JSONObject jsonObject= JSONObject.parseObject(cityWeatherRsponse).getJSONArray("HeWeather6").getJSONObject(0);
                    String time=jsonObject.getJSONObject("update").getString("loc");
                    String weather=jsonObject.getJSONObject("now").getString("cond_txt");
                    String temp=jsonObject.getJSONObject("now").getString("tmp");
                    CityWheatherBean cityWheatherBean=new CityWheatherBean()
                            .setCity(city)
                            .setTemp(temp)
                            .setTime(time)
                            .setWeather(weather);
                    cityWheatherBeans.add(cityWheatherBean);
                }
                //TODO:错误处理
                EventBus.getDefault().post(new EventMessage("多城市天气",cityWheatherBeans));
            }
        });
    }


    public void requestWeatherByCity(final String city){
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                sMyOkHttp = MyOkHttp.EnumFactory.singletonFactory.getIntance();
                sMyOkHttp.get(String.format(Constant.URL_REALTIME_HEFENG,city), new MyCallBack<String>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        //TODO:错误处理
                    }

                    @Override
                    public void onSuccess(String json) {
                        //TODO:错误处理
                        JSONObject jsonObject= JSONObject.parseObject(json).getJSONArray("HeWeather6").getJSONObject(0);
                        String time=jsonObject.getJSONObject("update").getString("loc");
                        String weather=jsonObject.getJSONObject("now").getString("cond_txt");
                        String temp=jsonObject.getJSONObject("now").getString("tmp");
                        CityWheatherBean cityWheatherBean=new CityWheatherBean()
                                .setCity(city)
                                .setTemp(temp)
                                .setTime(time)
                                .setWeather(weather);
                        EventBus.getDefault().post(new EventMessage("城市天气",cityWheatherBean));
                    }

                });
            }
        });
    }


    public void requestMotto(){
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                MyOkHttp.EnumFactory.singletonFactory.getIntance().get(Constant.URL_MOTTO, new MyCallBack<MottoBean>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        //TODO:错误处理
                    }

                    @Override
                    public void onSuccess(MottoBean mottoBean) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("每日寄语",mottoBean));
                    }

                });
            }
        });
    }


    public void requestTranslateStr(final String string){
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                MyOkHttp.EnumFactory.singletonFactory.getIntance().post(String.format(Constant.URL_TRANSLATE,string), new MyCallBack<String>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("翻译",null,""));
                    }

                    @Override
                    public void onSuccess(String json) {
                        //TODO:错误处理
                        String translated= JSON.parseObject(json).getJSONArray("data")
                                .getJSONObject(0).getString("dst");
                        EventBus.getDefault().post(new EventMessage("翻译",translated));
                    }

                });
            }
        });
    }


    public void requestWeather(final City city){
        ThreadUtils.EnumFactory.singletonFactory.getIntance().getFixedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                MyOkHttp.EnumFactory.singletonFactory.getIntance().get(String.format(Constant.URL_FORECAST_HEFENG,city.getName()), new MyCallBack<WeatherHefeng>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("和风天气",null));
                    }

                    @Override
                    public void onSuccess(WeatherHefeng weatherHefeng) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("和风天气",weatherHefeng));
                    }

                });
                MyOkHttp.EnumFactory.singletonFactory.getIntance().get(String.format(Constant.URL_FORECAST_FLYME, city.getCityId()), new MyCallBack<WeatherFlyme>() {
                    @Override
                    public void onFailure(Call call, Exception e) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("flyme天气",null));
                    }

                    @Override
                    public void onSuccess(WeatherFlyme weatherFlyme) {
                        //TODO:错误处理
                        EventBus.getDefault().post(new EventMessage("flyme天气",weatherFlyme));
                    }

                });
            }
        });
    }

}
