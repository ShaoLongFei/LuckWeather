package com.liuyue.luckweather.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 流月 on 2018/4/11.
 *
 * @description 权限工具类
 */

public class PermissionUnits {

    private static final String TAG = "PermissionUnits";

    /**
     * 检查权限授权状态
     *
     * @param context
     * @param permission
     * @return
     */
    public static int checkSelfPermission(Context context, String permission) {
        try {
            final PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            int targetSdkVersion = info.applicationInfo.targetSdkVersion;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (targetSdkVersion >= Build.VERSION_CODES.M) {
                    Log.i(TAG, "targetSdkVersion >= Build.VERSION_CODES.M");
                    return ContextCompat.checkSelfPermission(context, permission);
                } else {
                    return PermissionChecker.checkSelfPermission(context, permission);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return ContextCompat.checkSelfPermission(context, permission);
    }

    public static boolean checkSelfPermissions(Context context, String[] permissions) {
        for (String permission : permissions) {
            int ss = ContextCompat.checkSelfPermission(context, permission);
            System.out.println("权限情况   " + ss);
            if (ss != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测权限 * * @return true：已授权； false：未授权；
     */
    public static boolean checkPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED){
            return true;
        } else{
            return false;
        }
    }


    /**
     * 检测多个权限 * * @return 未授权的权限
     */
    public static List<String> checkMorePermissions(Context context, String[] permissions) {
        List<String> permissionList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (!checkPermission(context, permissions[i])){
                permissionList.add(permissions[i]);
            }
        }
        return permissionList;
    }


    /**
     * 请求权限
     *
     * @param activity
     * @param permissions
     * @param requestCode
     */
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    /**
     * 请求多个权限
     */
    public static void requestMorePermissions(Activity activity, List permissionList, int requestCode) {
        String[] permissions = (String[]) permissionList.toArray(new String[permissionList.size()]);
        requestPermissions(activity, permissions, requestCode);
    }


}
