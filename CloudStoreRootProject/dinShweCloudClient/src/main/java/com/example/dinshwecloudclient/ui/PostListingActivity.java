package com.example.dinshwecloudclient.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dinshwecloudclient.OnTaskCompletedCallback;
import com.example.dinshwecloudclient.Post;
import com.example.dinshwecloudclient.PostAdapter;
import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.RetreiveDataFromServerTask;
import com.example.dinshwecloudclient.TaskResult;
import com.example.dinshwecloudclient.utility.BuildSettings;
import com.example.dinshwecloudclient.utility.EndpointURL;
import com.example.dinshwecloudclient.utility.ResponseCode;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class PostListingActivity extends Activity {
	private ListView mListView = null;
	private List<Post> mPosts = null;
	private ProgressBar spinningProgressBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listing_posts);
		spinningProgressBar = (ProgressBar)findViewById(R.id.spinning_progress);
		spinningProgressBar.setVisibility(View.GONE);

	}

	@Override
	protected void onResume() {
		super.onResume();
		retreivePosts();
	}
 private void retreivePosts(){
	 spinningProgressBar.setVisibility(View.VISIBLE);
	 RetreiveDataFromServerTask task = new RetreiveDataFromServerTask(new OnTaskCompletedCallback() {

			@Override
			public void onTaskCompleted(TaskResult result) {
				spinningProgressBar.setVisibility(View.GONE);
				if (result.responseCode.Code < 0) {
					handleError(result.responseCode);
				} else {
					parseJson(result);
				}
			}
		});
	 String url  = BuildSettings.isLocalHost?EndpointURL.LOCAL_GOOGLE_APPSPOT_URL.toString():EndpointURL.REMOTE_GOOGLE_APPSPOT_URL.toString();
	 task.execute(url);
 }
	private void handleError(ResponseCode code) {
		Toast.makeText(this, code.ErrorDescription, Toast.LENGTH_LONG).show();
	}

	private void parseJson(TaskResult result) {
		mPosts = new GsonBuilder().create().fromJson(result.result, new TypeToken<List<Post>>() {
		}.getType());
		PostAdapter postAdapter = new PostAdapter(this, mPosts);
		mListView = (ListView) findViewById(R.id.post_list_view);
		mListView.setAdapter(postAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				startPostDetailActivity(mPosts.get(position));
			}
		});

	}

	private void startPostDetailActivity(Post post) {
		Intent intent = new Intent(this, PostDetailActivity.class);
		intent.putExtra("Post", post);
		startActivity(intent);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
