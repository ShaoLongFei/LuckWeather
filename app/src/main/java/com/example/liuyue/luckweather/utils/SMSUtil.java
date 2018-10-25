package com.example.liuyue.luckweather.utils;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.support.annotation.RequiresApi;
import android.telephony.SmsManager;

import com.example.liuyue.luckweather.R;

import java.util.Set;

public class SMSUtil {
    public static String SENT_SMS_ACTION = "SENT_SMS_ACTION";
    public static String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION";
    public static final Uri SMS_URI = Uri.parse("content://sms/");
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void sendSMS(Context context, Set<String> phones) {
        if (phones.size()==0){
            return;
        }
        SmsManager msg = SmsManager.getDefault();
        Intent send = new Intent(SENT_SMS_ACTION);
        // 短信发送广播
        PendingIntent sendPI = PendingIntent.getBroadcast(context, 0, send, 0);
        Intent delive = new Intent(DELIVERED_SMS_ACTION);
        // 发送结果广播
        PendingIntent deliverPI = PendingIntent
                .getBroadcast(context, 0, delive, 0);
        //短信内容
        String body=getSmsMessage(context);
        //发送短信
        for (String pno : phones) {
            msg.sendTextMessage(pno, null, body, sendPI, deliverPI);
        }
    }

    private static String getSmsMessage(Context context){
        String weather=Constant.WEATHER_HEFENG.getNow().getCond_txt();
        String wind=Constant.WEATHER_HEFENG.getNow().getWind_dir()
                +Constant.WEATHER_HEFENG.getNow().getWind_sc()+"级"
                +Constant.WEATHER_HEFENG.getNow().getWind_spd()+"km/h";
        String remind=Constant.WEATHER_HEFENG.getLifestyle().get(2).getTxt();
        return String.format(context.getResources().getString(R.string.send_sms),weather,wind,remind);
    }
}
