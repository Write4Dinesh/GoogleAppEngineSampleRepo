package com.example.dinshwecloudclient.ui;

import java.util.Date;

import com.example.dinshwecloudclient.Post;
import com.example.dinshwecloudclient.R;
import com.example.dinshwecloudclient.R.id;
import com.example.dinshwecloudclient.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddPostActivity extends Activity {
 private EditText titleField;
 private Button addButton;
 private EditText messageField;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_post);
		titleField = (EditText)findViewById(R.id.title_field);
		addButton = (Button)findViewById(R.id.add_btn);
		messageField = (EditText)findViewById(R.id.message_field);
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addPost();
				
			}
		});
	}

	private void addPost(){
		Post post = new Post();
		post.title = titleField.getText().toString();
		post.message = messageField.getText().toString();
		post.date = new Date().toString();
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		Post post = (Post)getIntent().getSerializableExtra("Post");
		titleField.setText(post.title);
		addButton.setText(post.date);
		messageField.setText(post.message);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
