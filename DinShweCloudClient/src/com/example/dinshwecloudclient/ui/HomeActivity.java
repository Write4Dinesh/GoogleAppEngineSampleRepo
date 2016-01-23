package com.example.dinshwecloudclient.ui;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.R.id;
import com.example.dinshwecloudclient.R.layout;
import com.example.dinshwecloudclient.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HomeActivity extends Activity {
private ProgressBar progress = null;
private Button getButton = null;
private TextView jsonTextView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		progress = (ProgressBar)findViewById(R.id.progress);
		 getButton = (Button)findViewById(R.id.getBtn);
		 jsonTextView =(TextView)findViewById(R.id.json_text);
		 getButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getPosts();
				
			}
		});
		 
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
