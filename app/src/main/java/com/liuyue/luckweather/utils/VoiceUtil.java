package com.liuyue.luckweather.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liuyue.luckweather.R;
import com.liuyue.luckweather.ui.MainActivity;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

public class VoiceUtil {

    public static SpeechSynthesizer mTts;
    public static String[] mVoicersValue;
    private static Toast toast;
    private static View view;


    public static void create(Context context,Toast toast1) {
        //初始化语音
        toast=toast1;
        SpeechUtility.createUtility(context,  SpeechConstant.APPID+"=5ba77534");
        mTts = SpeechSynthesizer.createSynthesizer(context, mTtsInitListener);
        mVoicersValue=context.getResources().getStringArray(R.array.voicer_values);
    }

    public static int play(Context context, String string,View view1){
        view=view1;
        setParam(context);
        int code=mTts.startSpeaking(string,mTtsListener);
        return code;
    }
    public static void setParam(Context context) {
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        // 设置在线合成发音人
        mTts.setParameter(SpeechConstant.VOICE_NAME, mVoicersValue[SharePrefUtil.getInt(context,SharePrefUtil.voiceTimbre,0)]);
        //设置合成语速
        mTts.setParameter(SpeechConstant.SPEED, SharePrefUtil.getInt(context,SharePrefUtil.voiceSpeed,50)+"");
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, SharePrefUtil.getInt(context,SharePrefUtil.voiceTone,50)+"");
        //设置合成音量
        mTts.setParameter(SpeechConstant.VOLUME, SharePrefUtil.getInt(context,SharePrefUtil.voiceVolume,50)+"");
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, SharePrefUtil.getInt(context,SharePrefUtil.voiceStream,3)+"");
    }

    private static InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                toast.setText("初始化语音失败");
                toast.show();
            }
        }
    };

    private static SynthesizerListener mTtsListener = new SynthesizerListener() {
        Boolean isplaying=false;
        @Override
        public void onSpeakBegin() {
            if (MainActivity.backgroundMusic!=null&&MainActivity.backgroundMusic.isPlaying()){
                isplaying=true;
                MainActivity.backgroundMusic.pause();
            }
            view.setEnabled(false);
        }

        @Override
        public void onBufferProgress(int i, int i1, int i2, String s) {

        }

        @Override
        public void onSpeakPaused() {

        }

        @Override
        public void onSpeakResumed() {

        }

        @Override
        public void onSpeakProgress(int i, int i1, int i2) {

        }

        @Override
        public void onCompleted(SpeechError error) {
            if (MainActivity.backgroundMusic!=null&&isplaying){
                isplaying=false;
                MainActivity.backgroundMusic.start();
            }
            view.setEnabled(true);
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };

}
