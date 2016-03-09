package com.example.dinshwecloudclient.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dinshwecloudclient.Post;
import com.example.dinshwecloudclient.R;

public class PostDetailActivity extends Activity {
 private TextView titleView;
 private TextView dateView;
 private TextView messageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_detail);
		titleView = (TextView)findViewById(R.id.title_view);
		dateView = (TextView)findViewById(R.id.date_view);
		messageView = (TextView)findViewById(R.id.message_view);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Post post = (Post)getIntent().getSerializableExtra("Post");
		titleView.setText(post.title);
		dateView.setText(post.date);
		messageView.setText(post.message);
	}
	private void editPost(){
		Intent i = new Intent(this,CreateOrEditPostActivity.class);
		i.putExtra(CreateOrEditPostActivity.MODE_CREATE_POST, true);
		startActivity(i);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
