package com.example.dinshwecloudclient;

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

import android.app.Activity;
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
	 
	Thread t = new Thread(new Runnable(){

		@Override
		public void run() { 
			URL url;
			try {
				url = new URL("http://10.0.2.2:8888/Services/V1/GetAllPosts");
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				InputStream in = con.getInputStream();
				InputStreamReader inputReader = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(inputReader);
				String line = null;
				StringBuilder builder = new StringBuilder();
				while((line = reader.readLine())!=null){
					builder.append(line);
				}
				reader.close();
				jsonTextView.setText(builder.toString());
				System.out.println("data=" + builder.toString());
				
			}
			System.out.println("response code = " + responseCode);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}); 
	progress.setVisibility(View.VISIBLE);
	t.start();
	try {
		t.join();
		progress.setVisibility(View.INVISIBLE);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
