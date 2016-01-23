package com.example.dinshwecloudclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

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

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
