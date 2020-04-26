package com.liuyue.luckweather.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;


/**
 * SharePreferences操作工具类
 */
public class SharePrefUtil {

	private final static String SP_NAME = "config";
	private static SharedPreferences sp;

	public static final String city="citys";
	public static final String careNumbers="careNumbers";
	public static final String careWeathers="careWeathers";
	public static final String careMode="careMode";
	public static final String zhishu="zhishu";
	public static final String voiceTimbre="voice_timbre";
	public static final String backgroundMusic="backgroundMusic";
	public static final String careLastTime="careLastTime";
	public static final String voiceSpeed="voice_speed";
	public static final String voiceTone="voice_tone";
	public static final String voiceVolume="voice_volume";
	public static final String voiceStream="voice_stream";



	public static void saveSetString(Context context, String key, Set<String> stringSet){
		if (sp==null)
			sp=context.getSharedPreferences(SP_NAME,0);
		sp.edit().putStringSet(key,stringSet).commit();
	}

	public static Set<String> getSetString(Context context,String key,Set<String> stringSet){
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getStringSet(key,stringSet);
	}

	/**
	 * 保存字符串
	 *
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveString(Context context, String key, String value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putString(key, value).commit();
	}

	/**
	 * 获取字符值
	 *
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(Context context, String key, String defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getString(key, defValue);
	}

	/**
	 * 保存布尔值
	 *
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveBoolean(Context context, String key, boolean value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putBoolean(key, value).commit();
	}

	/**
	 * 获取布尔值
	 *
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(Context context, String key,
									 boolean defValue) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		return sp.getBoolean(key, defValue);
	}

	public static void saveInt(Context context,String key,int value){
		if (sp==null)
			sp=context.getSharedPreferences(SP_NAME,0);
		sp.edit().putInt(key,value).commit();
	}

	public static int getInt(Context context,String key,int defValue){
		if (sp==null)
			sp=context.getSharedPreferences(SP_NAME,0);
		return sp.getInt(key,defValue);
	}



}
