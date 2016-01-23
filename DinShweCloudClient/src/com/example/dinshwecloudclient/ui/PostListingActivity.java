package com.example.dinshwecloudclient.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.dinshwecloudclient.Post;
import com.example.dinshwecloudclient.PostAdapter;
import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.RetreivePostsTask;
import com.example.dinshwecloudclient.TaskCompletedCallback;
import com.example.dinshwecloudclient.R.id;
import com.example.dinshwecloudclient.R.layout;
import com.google.gson.mm.GsonBuilder;
import com.google.gson.mm.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PostListingActivity extends Activity {
private ListView mListView = null;
private List<Post> mPosts = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listing_posts);
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		new RetreivePostsTask(new TaskCompletedCallback() {
			
			@Override
			public void onTaskCompleted(String result) {
				parseData(result);
				
			}
		}).execute("");
	}
private void parseData(String result){
	mPosts = new GsonBuilder().create().fromJson(result, new TypeToken<List<Post>>(){}.getType());
	PostAdapter postAdapter = new PostAdapter(this, mPosts);
	mListView = (ListView)findViewById(R.id.post_list_view);
	mListView.setAdapter(postAdapter);
	mListView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			startPostDetailActivity(mPosts.get(position));
		}
	});
	
	
}

private void startPostDetailActivity(Post post){
	Intent intent = new Intent(this,PostDetailActivity.class);
	intent.putExtra("Post",post);
	startActivity(intent);
}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
