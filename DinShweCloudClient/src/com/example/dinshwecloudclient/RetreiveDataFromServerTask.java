package com.example.dinshwecloudclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.dinshwecloudclient.utility.DinCryptoAndSecurity;
import com.example.dinshwecloudclient.utility.DinShweLogger;
import com.example.dinshwecloudclient.utility.EndpointURL;
import com.example.dinshwecloudclient.utility.ResponseCode;
import com.example.dinshwecloudclient.utility.Utility;

import android.os.AsyncTask;

public class RetreiveDataFromServerTask extends AsyncTask<String, Integer, TaskResult> {
	private OnTaskCompletedCallback mCallback = null;

	public RetreiveDataFromServerTask(OnTaskCompletedCallback callback) {
		mCallback = callback;
	}

	@Override
	protected TaskResult doInBackground(String... params) {
		TaskResult result = new TaskResult();
		if (!Utility.isConnectedToNet()) {
			result.responseCode = ResponseCode.NO_NETWORK;
			return result;
		}
		String url = params[0];
		result = getDataFromServer(url); 
		return result;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

	}

	@Override
	protected void onPostExecute(TaskResult result) {
		mCallback.onTaskCompleted(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
	}

	private TaskResult getDataFromServer(String uri) {
		TaskResult result = new TaskResult();
		StringBuilder builder = null;
		try {
			DinShweLogger.debugLog("AsyncTask-URL=" + uri);
			HttpURLConnection con = (HttpURLConnection) new URL(uri).openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream in = con.getInputStream();
				InputStreamReader inputReader = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(inputReader);
				String line = null;
				builder = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
				reader.close();
				result.responseCode = ResponseCode.SUCCESS;
				result.result = builder.toString();
				DinCryptoAndSecurity cryptoService = new DinCryptoAndSecurity();
				String encryptionKey, initVector, dataToBeEncrypted;
				encryptionKey = "dinesh@masthaiah";
				initVector = "RandomInitVector";
				dataToBeEncrypted = result.result;
				result.result = cryptoService.decrypt(encryptionKey, initVector, dataToBeEncrypted);
				DinShweLogger.debugLog("Json Response from Server:" + result.result);
				
			}
			else {
				result.responseCode = ResponseCode.HTTP_ERROR;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			result.responseCode = ResponseCode.EXCEPTION;
		} catch (IOException e) {
			e.printStackTrace();
			result.responseCode = ResponseCode.EXCEPTION;
		}

		return result;
	}

}
