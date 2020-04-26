package com.liuyue.luckweather.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

public class PictureUtil {
    public static Bitmap resizeWidthAndHeight(Resources resources, int pic, int width, int height){
        Bitmap bitmap= BitmapFactory.decodeResource(resources, pic);
        Bitmap resizeBmp = ThumbnailUtils.extractThumbnail(bitmap, width, height);
        return resizeBmp;
    }
}
