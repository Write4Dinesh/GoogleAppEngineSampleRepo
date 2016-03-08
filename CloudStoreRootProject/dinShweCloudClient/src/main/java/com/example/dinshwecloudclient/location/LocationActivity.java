package com.example.dinshwecloudclient.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Toast;

public class LocationActivity extends Activity {
	private static final long MIN_TIME_BETWEEN_UPDATE = 60 * 1000;
	private static final long MIN_DISTANCE_BETWEEN_CHANGE = 10;// in meters

	private boolean isNetworkEnabled = false;
	private boolean isGPSEnabled = false;
	private boolean canGetLocation = false;

	private Location currentLoc = null;
	private String mCurrentProvider = "";
    private LocationManager mLocMgr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 mLocMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		isGPSEnabled = mLocMgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
		isNetworkEnabled = mLocMgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		canGetLocation = isGPSEnabled || isNetworkEnabled;

		mCurrentProvider = isGPSEnabled ? LocationManager.GPS_PROVIDER : LocationManager.NETWORK_PROVIDER;
		
		if (canGetLocation) {
			mLocMgr.requestLocationUpdates(mCurrentProvider, MIN_TIME_BETWEEN_UPDATE, MIN_DISTANCE_BETWEEN_CHANGE, new LocationListenerImp(this));
		}
		currentLoc = mLocMgr.getLastKnownLocation(mCurrentProvider);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if(canGetLocation)
		Toast.makeText(this, "Provider Enabled=" + mCurrentProvider, Toast.LENGTH_LONG).show();
		else 
			Toast.makeText(this, "Provider Disabled", Toast.LENGTH_LONG).show();
	    
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}

class LocationListenerImp implements LocationListener {
	private Context mContext;

	public LocationListenerImp(Context context) {
		mContext = context;

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO: What should be done on location change
		showToast("LocationChanged:lat=" + location.getLatitude() + ",lang:" + location.getLongitude());
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO : what should be done when provider status changes. ex. it
		// becomes available/un-available/cant work
		// status can be :
		// LocationProvider.AVAILABLE,LocationProvider.TEMPORARILY_UNAVAILABLE,LocationProvider.OUT_OF_SERVICE;
		String strStatus = "";
		if (status == LocationProvider.AVAILABLE) {
			strStatus = "AVAILABLE";
		}
		if (status == LocationProvider.TEMPORARILY_UNAVAILABLE) {
			strStatus = "TEMPORARILY_UNAVAILABLE";
		}
		if (status == LocationProvider.OUT_OF_SERVICE) {
			strStatus = "OUT_OF_SERVICE";
		}
		showToast("ProviderStatusChanged:status=" + strStatus);
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO: user has just enabled the provider
		showToast("Provider enabled");
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO :user has just disable the provider
		showToast("Provider disabled");
	}

	private void showToast(String message) {
		Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
		
	}

}