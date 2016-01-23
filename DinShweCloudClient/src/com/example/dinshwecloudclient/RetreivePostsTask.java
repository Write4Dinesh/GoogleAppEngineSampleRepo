package com.example.dinshwecloudclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class RetreivePostsTask extends AsyncTask<String, Integer, String> {
	private TaskCompletedCallback mCallback = null;

	public RetreivePostsTask(TaskCompletedCallback callback) {
		mCallback = callback;
	}

	@Override
	protected String doInBackground(String... params) {
		String url = params[0];
        String result = getDataFromServer(url);
		return result;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(String result) {
		mCallback.onTaskCompleted(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
	}

	private String getDataFromServer(String uri){
		StringBuilder builder = null;
		URL url;
		try {
			//url = new URL("http://10.0.2.2:8888/Services/V1/GetAllPosts");
			url = new URL("http://dinshwecloudstore.appspot.com/Services/V1/GetAllPosts");
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.connect();
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK){
			InputStream in = con.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(inputReader);
			String line = null;
			 builder = new StringBuilder();
			while((line = reader.readLine())!=null){
				builder.append(line);
			}
			reader.close();
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
	
	return  builder.toString();
	}
}
