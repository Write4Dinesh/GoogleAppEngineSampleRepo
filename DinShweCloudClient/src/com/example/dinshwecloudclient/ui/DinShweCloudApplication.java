package com.example.dinshwecloudclient.ui;

import com.example.dinshwecloudclient.utility.DinShweLogger;

import android.app.Application;
import android.content.Context;

public class DinShweCloudApplication extends Application {
 public static Context mAppContext;
	@Override
	public void onCreate() {
		super.onCreate();
		DinShweLogger.enableLog(true);
		DinShweLogger.debugLog("Application Started");
		mAppContext = getApplicationContext();
	}
	

	@Override
	public void onTerminate() {
		super.onTerminate();
		DinShweLogger.debugLog("Application Terminated");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		DinShweLogger.debugLog("Application Running out of Memory");
	}

}
