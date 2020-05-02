package com.liuyue.luckweather.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.utils.SharePrefUtil;
import com.liuyue.luckweather.utils.TitleBarUtil;
import com.liuyue.luckweather.utils.VoiceUtil;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.views.Slider;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.iflytek.cloud.ErrorCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SpeechSetActivity extends AppCompatActivity implements View.OnClickListener {
    private NiftyDialogBuilder dialogBuilder;
    private Toast mToast;

    private View sliderView;
    private View listView;
    private Slider slider;
    private ListView list;
    private TextView speedTv;
    private TextView toneTv;
    private TextView volumeTv;
    private TextView timbreTv;
    private TextView audioStreamTv;
    private ButtonRectangle playBtn;

    private String[] mVoicersEntries;
    private String[] mVoicersValue;
    private String[] mStreamEntries;
    private String[] mStreamValue;
    private int voicersSelect;
    private int streamSelect;

    private MyListAdapter listAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TitleBarUtil.setStatusBarColor(this, R.color.clear_sky_day_start);
        setContentView(R.layout.activity_speech_set);
        Slide slide=new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);
        //标题栏
        findViewById(R.id.titlebar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView)findViewById(R.id.titlebar_title)).setText("语音设置");
        //初始化控件
        initControl();
        //初始化数据
        initData();
        //初始化语音
        VoiceUtil.create(SpeechSetActivity.this,mToast);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }

    @SuppressLint("SetTextI18n")
    private void initData() {
        speedTv.setText(SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceSpeed,50)+"");
        toneTv.setText(SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceTone,50)+"");
        volumeTv.setText(SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceVolume,50)+"");

        mVoicersEntries=getResources().getStringArray(R.array.voicer_entries);
        mVoicersValue=getResources().getStringArray(R.array.voicer_values);
        mStreamEntries=getResources().getStringArray(R.array.stream_entries);
        mStreamValue=getResources().getStringArray(R.array.stream_values);

        timbreTv.setText(mVoicersEntries[SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceTimbre,0)].split("—")[0]);
        audioStreamTv.setText(mStreamEntries[SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceStream,3)]);

    }

    private void initControl() {
        speedTv=findViewById(R.id.tv_speed);
        toneTv=findViewById(R.id.tv_tone);
        volumeTv=findViewById(R.id.tv_volume);
        timbreTv=findViewById(R.id.tv_timbre);
        audioStreamTv=findViewById(R.id.tv_audio_stream);
        findViewById(R.id.ll_speed).setOnClickListener(this);
        findViewById(R.id.ll_tone).setOnClickListener(this);
        findViewById(R.id.ll_volume).setOnClickListener(this);
        findViewById(R.id.ll_timbre).setOnClickListener(this);
        findViewById(R.id.ll_audio_stream).setOnClickListener(this);
        playBtn=findViewById(R.id.speech_set_play);
        playBtn.setOnClickListener(this);
    }

    private void initDialog() {
        dialogBuilder=NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withTitleColor("#FFFFFF")
                .withDividerColor("#11000000")
                .withDialogColor("#ff1f99d6")
                .withIcon(getResources().getDrawable(R.drawable.ic_drawer_setting))
                .isCancelableOnTouchOutside(true)
                .withDuration(700)
                .withEffect(Effectstype.RotateBottom)
                .withButton1Text("确定")
                .withButton2Text("取消")
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                });
    }

    private void showSliderDailog(String title, final String key, final TextView textView){
        sliderView=getLayoutInflater().inflate(R.layout.layout_slider,null);
        slider=sliderView.findViewById(R.id.layout_sliderNumber);
        int value= SharePrefUtil.getInt(SpeechSetActivity.this,key,50);
        slider.setValue(value);
        dialogBuilder
                .withTitle(title)
                .setCustomView(sliderView,SpeechSetActivity.this)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharePrefUtil.saveInt(SpeechSetActivity.this,key,slider.getValue());
                        textView.setText(slider.getValue()+"");
                        dialogBuilder.hide();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_speed:
                initDialog();
                showSliderDailog("语速设置",SharePrefUtil.voiceSpeed,speedTv);
                break;
            case R.id.ll_volume:
                initDialog();
                showSliderDailog("音量设置",SharePrefUtil.voiceVolume,volumeTv);
                break;
            case R.id.ll_tone:
                initDialog();
                showSliderDailog("音调设置",SharePrefUtil.voiceTone,toneTv);
                break;
            case R.id.ll_timbre:
                initDialog();
                showTimbreDalog("发音人设置",SharePrefUtil.voiceTimbre,timbreTv);
                break;
            case R.id.ll_audio_stream:
                initDialog();
                showTimbreDalog("音频流设置",SharePrefUtil.voiceStream,audioStreamTv);
                break;
            case R.id.speech_set_play:
                playVoice();
                break;
        }
    }

    private void playVoice() {
        int value=SharePrefUtil.getInt(SpeechSetActivity.this,SharePrefUtil.voiceTimbre,0);
        int code = -1;
        if (value!=2&&value!=3&&value!=4){
            code= VoiceUtil.play(SpeechSetActivity.this,"您好，我是幸运天气语音小助手！", playBtn);
        }else {
            code= VoiceUtil.play(SpeechSetActivity.this,"Nice to meet you,I am lucky weather voice assistant!", playBtn);
        }
        if (code != ErrorCode.SUCCESS) {
            showToast("语音合成失败,错误码: " + code);
        }
    }

    private void showToast(String message){
        mToast.setText(message);
        mToast.show();
    }

    private void showTimbreDalog(String title, final String key, final TextView textView) {
        listView=getLayoutInflater().inflate(R.layout.layout_list,null);
        list=listView.findViewById(R.id.layout_list);

        if (key.equals("voice_stream")){
            streamSelect=SharePrefUtil.getInt(SpeechSetActivity.this,key,3);
            List<Boolean> booleanList=new ArrayList<>();
            for (int i=0;i<6;i++){
                if (i==streamSelect){
                    booleanList.add(true);
                }else {
                    booleanList.add(false);
                }
            }
            listAdapter = new MyListAdapter(SpeechSetActivity.this,mStreamEntries,booleanList,key);
        }else {
            voicersSelect=SharePrefUtil.getInt(SpeechSetActivity.this,key,0);
            List<Boolean> booleanList=new ArrayList<>();
            for (int i=0;i<18;i++){
                if (i==voicersSelect){
                    booleanList.add(true);
                }else {
                    booleanList.add(false);
                }
            }
            listAdapter = new MyListAdapter(SpeechSetActivity.this,mVoicersEntries,booleanList,key);
        }
        list.setAdapter(listAdapter);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 500);
        list.setLayoutParams(layoutParams);
        //反射调用修改
        TextView messageTv = null;
        Class temp = dialogBuilder.getClass();
        try {
            Field f = temp.getDeclaredField("mMessage");
            f.setAccessible(true);
            messageTv = (TextView) f.get(dialogBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageTv.setVisibility(View.GONE);

        dialogBuilder
                .withTitle(title)
                .setCustomView(listView,SpeechSetActivity.this)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (key.equals("voice_stream")){
                            SharePrefUtil.saveInt(SpeechSetActivity.this,key,streamSelect);
                            textView.setText(mStreamEntries[streamSelect]);
                        }else {
                            SharePrefUtil.saveInt(SpeechSetActivity.this,key,voicersSelect);
                            textView.setText(mVoicersEntries[voicersSelect].split("—")[0]);
                        }
                        dialogBuilder.dismiss();
                    }
                })
                .show();
    }

    public class MyListAdapter extends BaseAdapter {
        public String[] strings;
        private Context mContext;
        private List<Boolean> selectList;
        private String type;

        public MyListAdapter(Context context, String[] strings,List<Boolean> selectList,String type){
            mContext = context;
            this.strings = strings;
            this.selectList=selectList;
            this.type=type;
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public Object getItem(int i) {
            return strings[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int postion, View view, ViewGroup viewGroup) {
            final MyListAdapter.viewHolder viewHolder;

            if (view == null){
                viewHolder = new MyListAdapter.viewHolder();
                view = LayoutInflater.from(mContext).inflate(R.layout.speech_set_item,null);
                view.setTag(viewHolder);
                viewHolder.textView = view.findViewById(R.id.text);
            }else {
                viewHolder = (MyListAdapter.viewHolder) view.getTag();
            }

            if (selectList.get(postion)){
                viewHolder.textView.setBackground(getResources().getDrawable(R.color.deepBlue));
            }else {
                viewHolder.textView.setBackground(getResources().getDrawable(R.color.clear_sky_day_start));
            }

            viewHolder.textView.setText(strings[postion]);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (type.equals("voice_stream")){
                        if (postion!=streamSelect){
                            selectList.set(streamSelect,false);
                            streamSelect=postion;
                            selectList.set(streamSelect,true);
                            Log.e("点击了",postion+"");
                            SharePrefUtil.saveInt(SpeechSetActivity.this,SharePrefUtil.voiceStream,postion);
                            listAdapter.notifyDataSetChanged();
                        }
                    }else {
                        if (postion!=voicersSelect){
                            selectList.set(voicersSelect,false);
                            voicersSelect=postion;
                            selectList.set(voicersSelect,true);
                            SharePrefUtil.saveInt(SpeechSetActivity.this,SharePrefUtil.voiceTimbre,postion);
                            listAdapter.notifyDataSetChanged();
                        }
                    }

                }
            });

            return view;
        }

        class viewHolder{
            public TextView textView;
        }
    }

}


