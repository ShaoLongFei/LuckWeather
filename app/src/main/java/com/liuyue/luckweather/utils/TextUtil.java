package com.liuyue.luckweather.utils;

/**
 * Created by ghbha on 2016/5/9.
 */
public class TextUtil {

    public static String getFormatArea(String areaName) {
        if (areaName.length() > 2 && areaName.contains("县")) {
            areaName = areaName.replace("县", "");
        } else if (areaName.contains("市")) {
            areaName = areaName.replace("市", "");
        }
        return areaName;
    }

    public static int getInteger(String s){
        try {
            return Integer.valueOf(s);
        }catch (Exception e){
            return 0;
        }

    }
}
