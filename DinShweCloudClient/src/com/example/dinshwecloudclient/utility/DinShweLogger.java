package com.example.dinshwecloudclient.utility;

import android.util.Log;

public class DinShweLogger {
	private static final String LOG_TAG = "DinShwe";
    private static  boolean isLogEnabled = false; 
    public static void enableLog(boolean enable){
    	isLogEnabled = enable;
    }
	public static void debugLog(String logMessage) {
		if(isLogEnabled)
		Log.d(LOG_TAG, logMessage);
	}

	public static void infoLog(String logMessage) {
		if(isLogEnabled)
		Log.d(LOG_TAG, logMessage);
	}

	public static void warningLog(String logMessage) {
		if(isLogEnabled)
		Log.d(LOG_TAG, logMessage);
	}

	public static void verboseLog(String logMessage) {
		if(isLogEnabled)
		Log.d(LOG_TAG, logMessage);
	}

	public static void errorLog(String logMessage) {
		if(isLogEnabled)
		Log.d(LOG_TAG, logMessage);
	}

	
}
