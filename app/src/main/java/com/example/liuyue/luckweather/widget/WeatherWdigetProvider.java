package com.example.liuyue.luckweather.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.liuyue.luckweather.service.WdigetUpdateService;


public class WeatherWdigetProvider extends AppWidgetProvider {
	private Intent intent;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		intent = new Intent(context, WdigetUpdateService.class);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			context.startForegroundService(intent);
		} else {
			context.startService(intent);
		}

		super.onUpdate(context, appWidgetManager, appWidgetIds);

	}



	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		intent = new Intent(context, WdigetUpdateService.class);
		context.stopService(intent);
		super.onDeleted(context, appWidgetIds);
	}
}
