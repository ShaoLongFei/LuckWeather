package com.liuyue.luckweather.utils;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class TitleBarUtil {
    public static void setStatusBarColor(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(activity.getResources().getColor(statusColor));
    }
}
