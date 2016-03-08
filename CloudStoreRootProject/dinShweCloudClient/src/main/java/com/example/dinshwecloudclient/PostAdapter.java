package com.example.dinshwecloudclient;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PostAdapter extends BaseAdapter {
    private List<Post> mPosts = null;
    private Context mContext;
	public PostAdapter(Context context, List<Post> posts){
		mPosts = posts;
		mContext = context;
	}
	@Override
	public int getCount() {
		return mPosts.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Post currentPost = mPosts.get(position);
		if(convertView==null)
			convertView = View.inflate(mContext, R.layout.post_list_item_template, null);
		TextView titleView = (TextView)convertView.findViewById(R.id.post_title);
		TextView dateView = (TextView)convertView.findViewById(R.id.post_date);
		titleView.setText(currentPost.title);
		dateView.setText(currentPost.date);
		
		return convertView;
	}

}
