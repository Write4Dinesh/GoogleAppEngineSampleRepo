package com.example.dinshwecloudclient.utility;

import com.example.dinshwecloudclient.ui.DinShweCloudApplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utility {
	public static boolean isConnectedToNet() {
		NetworkInfo networkInfo = getConnectivityManager();
		if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	public static int getNetworkType() {
		NetworkInfo networkInfo = getConnectivityManager();
		if (networkInfo != null) {
			return networkInfo.getType();
		}
		return -1;
	}

	private static NetworkInfo getConnectivityManager() {
		Context context = DinShweCloudApplication.mAppContext;
		ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();
		return networkInfo;
	}
}
