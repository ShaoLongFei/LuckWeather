package com.liuyue.luckweather.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.liuyue.luckweather.R;
import com.liuyue.luckweather.bean.City;
import com.liuyue.luckweather.bean.CityCodeBean;
import com.liuyue.luckweather.bean.EventMessage;
import com.liuyue.luckweather.bean.MottoBean;
import com.liuyue.luckweather.bean.CityWheatherBean;
import com.liuyue.luckweather.bean.WeatherFlyme;
import com.liuyue.luckweather.bean.WeatherHefeng;
import com.liuyue.luckweather.bean.ZhiShuBean;
import com.liuyue.luckweather.ui.adapter.CityMenuAdapter;
import com.liuyue.luckweather.ui.adapter.ZhiShuAdapter;
import com.liuyue.luckweather.utils.BitmapBlurUtil;
import com.liuyue.luckweather.utils.Constant;
import com.liuyue.luckweather.utils.DataUtil;
import com.liuyue.luckweather.utils.DateTimeUtil;
import com.liuyue.luckweather.utils.GpsUtil;
import com.liuyue.luckweather.utils.NetworkRequestUtils;
import com.liuyue.luckweather.utils.PermissionUnits;
import com.liuyue.luckweather.utils.SMSUtil;
import com.liuyue.luckweather.utils.ScreenUtil;
import com.liuyue.luckweather.utils.SharePrefUtil;
import com.liuyue.luckweather.utils.ViewUtil;
import com.liuyue.luckweather.utils.VoiceUtil;
import com.liuyue.luckweather.widget.AqiView;
import com.liuyue.luckweather.widget.IndexHorizontalScrollView;
import com.liuyue.luckweather.widget.SunRiseView;
import com.liuyue.luckweather.widget.Today24HourView;
import com.liuyue.luckweather.widget.WeekForcastView.ZzWeatherView;
import com.liuyue.luckweather.widget.WindmillView;
import com.liuyue.luckweather.widget.weather.SkyView;
import com.fadai.particlesmasher.ParticleSmasher;
import com.fadai.particlesmasher.SmashAnimator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class MainActivity extends AppCompatActivity implements BDLocationListener ,AMapLocationListener,CityMenuListener{

    private final String TAG = "MainActivity";
    public static City city = new City().setName("五台山").setCityId("101101010");
    private Toolbar mToolbar;

    private TextView mCurrentAreaTv;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ScrollView contentMian;
    private Toast toast;
    private Boolean updateMenu=true;
    private GpsUtil gpsUtil;

    //侧滑
    private DrawerLayout mDrawerLayout;
    private CityMenuAdapter cityMenuAdapter;
    private RelativeLayout leftRL;
    private ScrollView drawerBodySv;
    private ParticleSmasher smasher;
    //城市管理
    private ListView mCityMenu;
    private List<CityWheatherBean> cityWheatherBeanList;
    //网络请求
    private Boolean hefeng=false;
    private Boolean flyme=false;
    //背景模糊
    private ImageView backgroundVague;
    private LinearLayout backgroundBlack;
    //实时天气
    private TextView mRealTempTv, mWeatherAndFeelTemp;
    private TextView mRealAqiTv;
    private TextView mUpdateTimeTv;
    private SkyView mSkyView;
    private ImageView mAlarmIv;
    //风速湿度
    private WindmillView windViewBig;
    private WindmillView windViewSmall;
    private TextView mWindTv;
    private TextView mShiduTv;
    private TextView mVisibilityTv;
    private TextView mPressureTv;
    private TextView mCloudinessTv;
    //空气指数
    private AqiView mAqi;
    private TextView mPm2_5Tv, mPm10Tv, mSo2Tv, mNo2Tv;
    //日出日落图
    private SunRiseView mSunRiseView;
    private Today24HourView today24HourView;
    private ZzWeatherView weatherView;
    //指数
    private RecyclerView mZhishuRecy;
    private ZhiShuAdapter zhiShuAdapter;
    private List<ZhiShuBean> zhiShuBeanList = new ArrayList<ZhiShuBean>();
    //每日寄语
    private ImageView drawerHeaderIv;
    private TextView mottoTv;
    private ImageView mottoVoiceIv;
    private MottoBean mottoBean;
    //音乐播放
    private MediaPlayer mediaPlayer;
    public static MediaPlayer backgroundMusic;
    private Toast mToast;
    private ImageView mVoiceIv;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.INTENT_REQUEST_SET && resultCode == Constant.INTENT_RESULT_SET) {
            assert data != null;
            zhiShuBeanList = (List<ZhiShuBean>) Objects.requireNonNull(data.getExtras()).get("result");
            Set<String> zhiShuSet = new HashSet<String>();
            for (ZhiShuBean zhiShuBean : zhiShuBeanList) {
                zhiShuSet.add(zhiShuBean.getName());
            }
            SharePrefUtil.saveSetString(this, SharePrefUtil.zhishu, zhiShuSet);
            zhiShuBeanList.add(new ZhiShuBean().setName("加号"));
            zhiShuAdapter = new ZhiShuAdapter(zhiShuBeanList, MainActivity.this);
            mZhishuRecy.setAdapter(zhiShuAdapter);
        } else if (requestCode == Constant.INTENT_REQUEST_CITY && resultCode == Constant.INTENT_RESULT_CITY) {
            contentMian.setVisibility(View.INVISIBLE);
            swipeRefreshLayout.setRefreshing(true);
            if (mDrawerLayout.isDrawerOpen(leftRL)) {
                mDrawerLayout.closeDrawer(leftRL);
            }
            NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestWeatherByCity(data.getExtras().getString("city"));
            mCurrentAreaTv.setText(data.getExtras().getString("district"));
            NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode(data.getExtras().getString("city"));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        //获取屏幕宽高
        DisplayMetrics dm = getResources().getDisplayMetrics();
        Constant.SCREEN_WIDTH = dm.widthPixels;
        Constant.SCREEN_HEIGHT = dm.heightPixels;

        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        initWidget();
        //检查权限
        List<String> fail = PermissionUnits.checkMorePermissions(MainActivity.this, Constant.PERMISSIONS);
        if (fail.size() != 0) {
            Toast.makeText(MainActivity.this, "我们需要一些必要的权限", Toast.LENGTH_SHORT).show();
            PermissionUnits.requestMorePermissions(MainActivity.this, fail, 2);
        } else {
            initParam();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        VoiceUtil.create(MainActivity.this, mToast);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initParam();
    }

    private void initParam() {
        gpsUtil = new GpsUtil(this, this,this);
        gpsUtil.start();
        Log.e(TAG, "开始定位");
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        gpsUtil.stop();
        mCurrentAreaTv.setText(bdLocation.getDistrict());
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode(bdLocation.getCity());
    }
    

    @TargetApi(Build.VERSION_CODES.M)
    private void initWidget() {
        toast=Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT);
        contentMian = findViewById(R.id.content_main);
        contentMian.setVisibility(View.INVISIBLE);

        leftRL = findViewById(R.id.ll_left);

        mCurrentAreaTv = findViewById(R.id.tv_topCity);
        mCurrentAreaTv.setText("正在刷新");

        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                hefeng=false;
                flyme=false;
                NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestWeather(city);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.clear_sky_day_start));

        backgroundBlack = findViewById(R.id.backgroundBlack);
        contentMian.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY < 400) {
                    backgroundVague.setAlpha((float) 0.0025 * scrollY);
                    backgroundBlack.setAlpha((float) 0.001 * scrollY);
                }
            }
        });

        mAlarmIv = findViewById(R.id.alarm_iv);
        mAlarmIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AlarmActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

        findViewById(R.id.care_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> fail = PermissionUnits.checkMorePermissions(MainActivity.this, Constant.PERMISSIONS);
                if (fail.size() != 0) {
                    Toast.makeText(MainActivity.this, "我们需要一些必要的权限", Toast.LENGTH_SHORT).show();
                    PermissionUnits.requestMorePermissions(MainActivity.this, fail, 2);
                } else {
                    startActivity(new Intent(MainActivity.this, CareActivity.class),
                            ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                }
            }
        });

        mVoiceIv = findViewById(R.id.voice_iv);
        mVoiceIv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View v) {
                int voice = SharePrefUtil.getInt(MainActivity.this, SharePrefUtil.voiceTimbre, 0);
                if (voice != 2 && voice != 3 && voice != 4) {
                    VoiceUtil.play(MainActivity.this, getWeatherStr(), mVoiceIv);
                } else {
                    NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestTranslateStr(getWeatherStr());
                }
            }
        });

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        backgroundVague = findViewById(R.id.backgroundVague);

        mDrawerLayout = findViewById(R.id.drawLayout);

        View mFirstShowRl = findViewById(R.id.first_show_rl);

        @SuppressLint("Recycle")
        TypedArray actionbarSizeTypedArray = this.obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        int h = (int) actionbarSizeTypedArray.getDimension(0, 0);
        mFirstShowRl.getLayoutParams().height = Constant.SCREEN_HEIGHT - h - ScreenUtil.getStatusBarHeight(this);
        setDrawerLayout();
        setRealWeather();
        setForeCast();
        setDetails();
        setAqi();
        setSunRiseView();
        setZhiShu();
    }

    private String getWeatherStr() {
        String weather = Constant.WEATHER_HEFENG.getNow().getCond_txt();
        String tmp_max = Constant.WEATHER_HEFENG.getDaily_forecast().get(0).getTmp_max() + "度";
        String tmp_min = Constant.WEATHER_HEFENG.getDaily_forecast().get(0).getTmp_min() + "度";
        String wind = Constant.WEATHER_HEFENG.getNow().getWind_dir()
                + Constant.WEATHER_HEFENG.getNow().getWind_sc() + "级,风速是"
                + Constant.WEATHER_HEFENG.getNow().getWind_spd() + "千米每小时";
        String remind = Constant.WEATHER_HEFENG.getLifestyle().get(2).getTxt();
        return String.format(getResources().getString(R.string.voice_str), weather, tmp_max, tmp_min, wind, remind);
    }


    /**
     * 生活指数初始化
     */
    private void setZhiShu() {
        Set<String> zhiShuSet = SharePrefUtil.getSetString(getBaseContext(), SharePrefUtil.zhishu, Constant.DEFAULT_ZHISHU);
        for (String item : zhiShuSet) {
            zhiShuBeanList.add(new ZhiShuBean().setName(item));
        }
        zhiShuBeanList.add(new ZhiShuBean().setName("加号"));
        mZhishuRecy = findViewById(R.id.zhishu_recycle);
        zhiShuAdapter = new ZhiShuAdapter(zhiShuBeanList, MainActivity.this);
        mZhishuRecy.setLayoutManager(new GridLayoutManager(getBaseContext(), 4));
    }

    private void setAlarmIv() {
        String type = Constant.WEATHER_FLYME.getAlarms().get(0).getAlarmTypeDesc();
        if (type.contains("红")) {
            mAlarmIv.setImageResource(R.drawable.ic_alarm_red);
        } else if (type.contains("橙")) {
            mAlarmIv.setImageResource(R.drawable.ic_alarm_orange);
        } else if (type.contains("黄")) {
            mAlarmIv.setImageResource(R.drawable.ic_alarm_yellow);
        } else {
            mAlarmIv.setImageResource(R.drawable.ic_alarm_blue);
        }
    }

    private String getComfort(int temp) {
        if (temp < 10) {
            return "寒冷";
        } else if (temp < 25) {
            return "较冷";
        } else if (temp < 33) {
            return "舒适";
        } else if (temp < 38) {
            return "较热";
        } else {
            return "炎热";
        }
    }


    private void setForeCast() {
        //按小时预报
        IndexHorizontalScrollView indexHorizontalScrollView = findViewById(R.id.indexHorizontalScrollView);
        today24HourView = findViewById(R.id.today24HourView);
        indexHorizontalScrollView.setToday24HourView(today24HourView);
        //按周报
        weatherView = findViewById(R.id.weather_view);
        //设置线宽
        weatherView.setLineWidth(6f);
        //设置白天和晚上线条的颜色
        weatherView.setDayAndNightLineColor(Color.RED, Color.BLUE);
    }

    /**
     * 实时
     */
    private void setRealWeather() {
        mSkyView = findViewById(R.id.myWeatherView);
        mRealTempTv = findViewById(R.id.tv_RTTemp);
        mWeatherAndFeelTemp = findViewById(R.id.tv_RTTypeAndRealFeel);
        mRealAqiTv = findViewById(R.id.tv_aqi);
        mUpdateTimeTv = findViewById(R.id.tv_updateTime);
    }

    /**
     * 初始化日出日落
     */
    private void setSunRiseView() {
        mSunRiseView = findViewById(R.id.view_sun);
        mSunRiseView.setSunRiseDownTime("05:00", "18:46");
    }

    /**
     * 初始化空气
     */
    private void setAqi() {
        mPm2_5Tv = findViewById(R.id.tv_pm25);
        mPm10Tv = findViewById(R.id.tv_pm10);
        mSo2Tv = findViewById(R.id.tv_so2);
        mNo2Tv = findViewById(R.id.tv_no2);
        mAqi = findViewById(R.id.view_aqi);
    }

    /**
     * 初始化详细信息
     */
    private void setDetails() {
        windViewBig = findViewById(R.id.windViewBig);
        windViewSmall = findViewById(R.id.windViewSmall);
        mWindTv = findViewById(R.id.tv_wind);
        mShiduTv = findViewById(R.id.tv_humidity);
        mVisibilityTv = findViewById(R.id.tv_visibility);
        mPressureTv = findViewById(R.id.tv_pressure);
        mCloudinessTv = findViewById(R.id.tv_cloudiness);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    windViewBig.refreshView();
                    windViewSmall.refreshView();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @SuppressLint("HandlerLeak")
    private void setDrawerLayout() {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.open, R.string.close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (drawerBodySv.getScrollY()<=60){
                    drawerBodySv.smoothScrollTo(0,0);
                }
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        drawerHeaderIv = findViewById(R.id.iv_drawerHeaderIv);
        mottoTv = findViewById(R.id.tv_motto);
        mottoVoiceIv = findViewById(R.id.iv_motto_voice);
        mottoVoiceIv.setVisibility(View.GONE);
        mediaPlayer = new MediaPlayer();
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestMotto();
        mottoVoiceIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backgroundMusic != null && mediaPlayer.isPlaying()) {
                    backgroundMusic.pause();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backgroundMusic.start();
                        }
                    });
                }
                mediaPlayer.start();
            }
        });

    }

    @SuppressLint("HandlerLeak")
    private void setCityMenu() {
        //列表
        smasher = new ParticleSmasher(this);
        mCityMenu = findViewById(R.id.lv_drawer_menu);
        cityWheatherBeanList = new ArrayList<CityWheatherBean>();
        Set<String> citys = SharePrefUtil.getSetString(MainActivity.this, SharePrefUtil.city, new HashSet<String>());
        if (citys.isEmpty()) {
            citys.add(city.getName());
        } else if (!citys.contains(city.getName())) {
            citys.add(city.getName());
        }
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestWeathersByCitys(citys);
        findViewById(R.id.card_add_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, CitySelectActivity.class),
                        Constant.INTENT_REQUEST_CITY,
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
        drawerBodySv=findViewById(R.id.sv_drawerBody);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (SharePrefUtil.getBoolean(MainActivity.this, SharePrefUtil.backgroundMusic, true)){
            menu.findItem(R.id.menu_bg_music).setTitle(getResources().getString(R.string.menu_music_close));
        }else {
            menu.findItem(R.id.menu_bg_music).setTitle(getResources().getString(R.string.menu_music_open));
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                startActivityForResult(new Intent(this, SetActivity.class), Constant.INTENT_REQUEST_SET,
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                break;
            case R.id.menu_speech:
                mVoiceIv.setEnabled(true);
                startActivity(new Intent(MainActivity.this, SpeechSetActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                break;
            case R.id.menu_about:
                Toast.makeText(MainActivity.this, "很高兴认识你，我叫邵龙飞！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_bg_music:
                if (backgroundMusic != null && backgroundMusic.isPlaying()) {
                    backgroundMusic.pause();
                    SharePrefUtil.saveBoolean(MainActivity.this, SharePrefUtil.backgroundMusic, false);
                    item.setTitle(getResources().getString(R.string.menu_music_open));
                } else {
                    if (backgroundMusic == null) {
                        if (DateTimeUtil.isNight(Constant.WEATHER_FLYME.getWeathers().get(0).getSun_rise_time(),
                                Constant.WEATHER_FLYME.getWeathers().get(0).getSun_down_time())) {
                            backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.childhood);
                        } else {
                            backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.masbfca);
                        }
                        backgroundMusic.setLooping(true);
                    }
                    backgroundMusic.start();
                    SharePrefUtil.saveBoolean(MainActivity.this, SharePrefUtil.backgroundMusic, true);
                    item.setTitle(getResources().getString(R.string.menu_music_close));
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("HandlerLeak")
    @Override
    public void OnClickListener(int position) {
        contentMian.setVisibility(View.INVISIBLE);
        swipeRefreshLayout.setRefreshing(true);
        mCurrentAreaTv.setText(cityWheatherBeanList.get(position).getCity());
        if (mDrawerLayout.isDrawerOpen(leftRL)) {
            mDrawerLayout.closeDrawer(leftRL);
        }
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode(cityWheatherBeanList.get(position).getCity());
    }

    @Override
    public void OnLongClickListener(final int position, final View view) {
        smasher.with(view)
                .setStyle(SmashAnimator.STYLE_FLOAT_TOP)
                .setDuration(1500)
                .setHorizontalMultiple(3)
                .setVerticalMultiple(4)
                .addAnimatorListener(new SmashAnimator.OnAnimatorListener() {
                    @Override
                    public void onAnimatorStart() {
                        super.onAnimatorStart();
                    }

                    @Override
                    public void onAnimatorEnd() {
                        super.onAnimatorEnd();
                        cityWheatherBeanList.remove(position);
                        cityMenuAdapter=new CityMenuAdapter(cityWheatherBeanList,MainActivity.this,MainActivity.this);
                        mCityMenu.setAdapter(cityMenuAdapter);
                        ViewUtil.setListViewAutoHegiht(mCityMenu);
                        //存储数据
                        saveCityMenuData();
                        if (cityWheatherBeanList.size()>0&&city.getName()!=cityWheatherBeanList.get(0).getCity()){
                            swipeRefreshLayout.setRefreshing(true);
                            mCurrentAreaTv.setText(cityWheatherBeanList.get(0).getCity());
                            NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode(cityWheatherBeanList.get(0).getCity());
                        }else if (cityWheatherBeanList.size()==0){
                            swipeRefreshLayout.setRefreshing(true);
                            updateMenu=true;
                            gpsUtil.start();
                        }
                    }
                })
                .start();
    }

    private void saveCityMenuData() {
        Set<String> citys=new HashSet<String>();
        for (CityWheatherBean cityWheatherBean:cityWheatherBeanList){
            citys.add(cityWheatherBean.getCity());
        }
        SharePrefUtil.saveSetString(MainActivity.this,SharePrefUtil.city,citys);
    }

    private void showToast(String s){
        toast.setText(s);
        toast.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(EventMessage eventMessage){
        switch (eventMessage.key){
            case "城市代码":
                dealCityCode(eventMessage);
                break;
            case "多城市天气":
                dealWeathersByCitys(eventMessage);
                break;
            case "城市天气":
                dealWeatherByCity(eventMessage);
                break;
            case "每日寄语":
                dealMotto(eventMessage);
                break;
            case "翻译":
                dealTranslateStr(eventMessage);
                break;
            case "和风天气":
                Constant.WEATHER_HEFENG=((WeatherHefeng)eventMessage.value).getHeWeather6().get(0);
                hefeng=true;
                dealWeather();
                break;
            case "flyme天气":
                Constant.WEATHER_FLYME=(WeatherFlyme)eventMessage.value;
                flyme=true;
                dealWeather();
                break;
            default:
                break;
        }
    }

    @SuppressLint("StringFormatMatches")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void dealWeather() {
        if (!hefeng||!flyme)return;
        contentMian.setVisibility(View.VISIBLE);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //TODO:错误处理

        WeatherFlyme.RealtimeBean realtimeBean = Constant.WEATHER_FLYME.getRealtime();
        WeatherFlyme.Pm25Bean pm25Bean = Constant.WEATHER_FLYME.getPm25();
        WeatherFlyme.WeathersBean weathersBean = Constant.WEATHER_FLYME.getWeathers().get(0);
        WeatherHefeng.HeWeather6Bean.NowBean nowBean = Constant.WEATHER_HEFENG.getNow();

        mRealTempTv.setText(realtimeBean.getTemp()+"");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        mUpdateTimeTv.setText(
                String.format(getResources().getString(R.string.activity_home_refresh_time), simpleDateFormat.format(new Date(System.currentTimeMillis())))
        );
        mRealAqiTv.setText("空气" + pm25Bean.getQuality() + " " + pm25Bean.getAqi());
        mWeatherAndFeelTemp.setText(
                String.format(getResources().getString(R.string.activity_home_type_and_real_feel_temp),
                        getComfort(realtimeBean.getSendibleTemp()), realtimeBean.getSendibleTemp())
        );

        //周报&&时报
        weatherView.setList(DataUtil.loadWeekWeatherModel(Constant.WEATHER_HEFENG.getDaily_forecast()));
        today24HourView.setData(Constant.WEATHER_FLYME.getWeatherDetailsInfo()
                .getWeather24HoursDetailsInfos());

        //详细信息
        windViewBig.setWindSpeedDegree(Integer.parseInt(realtimeBean.getWS()));
        windViewSmall.setWindSpeedDegree(Integer.parseInt(realtimeBean.getWS()));
        mWindTv.setText(nowBean.getWind_dir() + nowBean.getWind_sc() + "级" + nowBean.getWind_spd() + "km/h");
        mShiduTv.setText(nowBean.getHum() + "%");
        mVisibilityTv.setText(nowBean.getVis() + "公里");
        mPressureTv.setText(nowBean.getPres() + "百帕");
        mCloudinessTv.setText(nowBean.getCloud());

        //空气
        mAqi.setProgressAndLabel(Integer.parseInt(pm25Bean.getAqi()), "空气" + pm25Bean.getQuality());
        mPm2_5Tv.setText(pm25Bean.getPm25() + " μg/m³");
        mPm10Tv.setText(pm25Bean.getPm10() + " μg/m³");
        mSo2Tv.setText(pm25Bean.getSo2() + " μg/m³");
        mNo2Tv.setText(pm25Bean.getNo2() + " μg/m³");
        //日出
        mSunRiseView.setSunRiseDownTime(weathersBean.getSun_rise_time(), weathersBean.getSun_down_time());

        //指数
        mZhishuRecy.setAdapter(zhiShuAdapter);

        //背景
        mSkyView.setWeather(weathersBean.getWeather(), weathersBean.getSun_rise_time(),
                weathersBean.getSun_down_time());
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = BitmapBlurUtil.getInstance().blur(
                        MainActivity.this, mSkyView.getBackgroundBitmap(), 25);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        backgroundVague.setImageBitmap(bitmap);
                        backgroundVague.setAlpha(0.0f);
                    }
                });
            }
        }).start();

        //预警
        if (Constant.WEATHER_FLYME.getAlarms().size() > 0) {
            mAlarmIv.setVisibility(View.VISIBLE);
            setAlarmIv();
        } else {
            mAlarmIv.setVisibility(View.GONE);
        }

        //关心提醒
        String lastTime = SharePrefUtil.getString(MainActivity.this,
                SharePrefUtil.careLastTime, "未知");
        Boolean isAuto = SharePrefUtil.getBoolean(MainActivity.this,
                SharePrefUtil.careMode, false);
        @SuppressLint("SimpleDateFormat")
        String CurrentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (isAuto && !CurrentTime.equals(lastTime)) {
            Set<String> careWeathers = SharePrefUtil.getSetString(
                    MainActivity.this, SharePrefUtil.careWeathers, new HashSet<String>());
            if (careWeathers.contains(nowBean.getCond_txt())) {
                //群发短信提醒
                SMSUtil.sendSMS(MainActivity.this, SharePrefUtil.getSetString(
                        MainActivity.this, SharePrefUtil.careNumbers, new HashSet<String>()));
            }
        }

        //背景音乐
        if (SharePrefUtil.getBoolean(MainActivity.this, SharePrefUtil.backgroundMusic, true)) {
            if (DateTimeUtil.isNight(weathersBean.getSun_rise_time(), weathersBean.getSun_down_time())) {
                backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.childhood);
            } else {
                backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.masbfca);
            }
            backgroundMusic.setLooping(true);
            backgroundMusic.start();
        }

        //移动视图
        contentMian.smoothScrollTo(0, 0);
    }

    private void dealTranslateStr(EventMessage eventMessage) {
        VoiceUtil.play(MainActivity.this, (String) eventMessage.value, mVoiceIv);
    }

    private void dealMotto(EventMessage eventMessage) {
        mottoBean = (MottoBean) eventMessage.value;
        Glide.with(MainActivity.this).load(mottoBean.getPicture2())
                .placeholder(R.drawable.glide_load)
                .error(R.drawable.glide_load)
                .into(drawerHeaderIv);
        if (mottoBean.getContent().length() > 70) {
            mottoTv.setText(Constant.defaultMotto);
        } else {
            mottoTv.setText(mottoBean.getContent() + "\n" + mottoBean.getNote());
        }

        mottoVoiceIv.setVisibility(View.VISIBLE);
        try {
            mediaPlayer.setDataSource(mottoBean.getTts());
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "网络原因，加载失败", Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.prepareAsync();
    }

    private void dealWeatherByCity(EventMessage eventMessage) {
        cityWheatherBeanList.add((CityWheatherBean)eventMessage.value);
        cityMenuAdapter.notifyDataSetChanged();
        ViewUtil.setListViewAutoHegiht(mCityMenu);
        saveCityMenuData();
    }

    private void dealWeathersByCitys(EventMessage eventMessage) {
        cityWheatherBeanList = (List<CityWheatherBean>)eventMessage.value;
        cityMenuAdapter = new CityMenuAdapter(cityWheatherBeanList, MainActivity.this,MainActivity.this);
        mCityMenu.setAdapter(cityMenuAdapter);
        ViewUtil.setListViewAutoHegiht(mCityMenu);
    }

    private void dealCityCode(EventMessage eventMessage) {
        CityCodeBean cityCodeBean = (CityCodeBean) eventMessage.value;
        city.setName(cityCodeBean.getRESULT().get(0).getCity_name().split("-")[0])
                .setCityId(cityCodeBean.getRESULT().get(0).getCity_id());
        if (updateMenu){
            setCityMenu();
            updateMenu=false;
        }
        hefeng=false;
        flyme=false;
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestWeather(city);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        if (null != location) {
            if(location.getErrorCode() == 0){
                gpsUtil.stop();
                mCurrentAreaTv.setText(location.getDistrict());
                NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode(location.getCity());
            } else {
                showToast("高德定位失败，错误码"+location.getErrorCode());
                defaultLocation();
            }
        } else {
            showToast("高德定位失败");
            defaultLocation();
        }
    }

    private void defaultLocation() {
        mCurrentAreaTv.setText("北京");
        NetworkRequestUtils.EnumFactory.singletonFactory.getIntance().requestCityCode("北京");
    }
}


