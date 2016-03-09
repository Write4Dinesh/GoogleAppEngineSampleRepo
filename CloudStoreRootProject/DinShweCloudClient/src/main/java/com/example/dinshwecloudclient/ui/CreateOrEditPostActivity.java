package com.example.dinshwecloudclient.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.dinshwecloudclient.Post;
import com.example.dinshwecloudclient.R;

import java.util.Date;

public class CreateOrEditPostActivity extends Activity {
 private EditText titleField;
 private Button addButton;
 private EditText messageField;
	private boolean mCreatePost = true;
	public static final String MODE_CREATE_POST = "mode_create_post";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creat_or_edit_post);
		titleField = (EditText)findViewById(R.id.title_field);
		addButton = (Button)findViewById(R.id.add_btn);

		messageField = (EditText)findViewById(R.id.message_field);
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addPost();
				
			}
		});
		mCreatePost = getIntent().getBooleanExtra(MODE_CREATE_POST,true);
		if(mCreatePost){
			editPost();
		}
	}

	private void addPost(){
		Post post = new Post();
		post.title = titleField.getText().toString();
		post.message = messageField.getText().toString();
		post.date = new Date().toString();
	}
	private void editPost(){
		Post post = (Post)getIntent().getSerializableExtra("Post");
		if(post!=null) {
			titleField.setText(post.title);
			addButton.setText(post.date);
			messageField.setText(post.message);
		}
	}
	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
