package com.example.dinshwecloudclient.ui;

import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.location.LocationActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {
private Button getButton = null;
private TextView jsonTextView = null;
private Button getLocBtn = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		 getButton = (Button)findViewById(R.id.getBtn);
		 jsonTextView =(TextView)findViewById(R.id.json_text);
		 getButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getPosts();
				
			}
		});
		 getLocBtn = (Button)findViewById(R.id.loc_button); 
		 getLocBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startLocActivity();
				
			}
		}); 
	}
	private void startLocActivity(){
		Intent i = new Intent(this,LocationActivity.class);
		startActivity(i);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
	}
 private void getPosts(){
	 Intent intent = new Intent(this,PostListingActivity.class);
	 startActivity(intent);
	
 }

	@Override
	protected void onPause() {
		super.onPause();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
