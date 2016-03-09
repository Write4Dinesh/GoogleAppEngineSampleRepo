package com.example.dinshwecloudclient.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.location.LocationActivity;

public class HomeActivity extends Activity {
private Button getButton = null;
	private Button addPostBtn = null;
private TextView jsonTextView = null;
private Button getLocBtn = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		 getButton = (Button)findViewById(R.id.get_post_btn);
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
		addPostBtn = (Button)findViewById(R.id.add_post_btn);
		addPostBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createPost();

			}
		});
	}
	private void startLocActivity(){
		Intent i = new Intent(this,LocationActivity.class);
		startActivity(i);
	}

	private void createPost(){
		Intent i = new Intent(this,CreateOrEditPostActivity.class);
		i.putExtra(CreateOrEditPostActivity.MODE_CREATE_POST,true);
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
