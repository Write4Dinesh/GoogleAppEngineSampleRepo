package com.din.shwe.data;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class DataStoreServlet extends HttpServlet {
	private DatastoreService mDataStore = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println("Welcome! This is a Servlet that created this Html page");
	 response.getWriter().println("Another line goes here");
	}
private void save(){
	Entity post = new Entity("Post");
	post.setProperty("post_title", "post_title1");
	post.setProperty("post_date", "post_date1");
	post.setProperty("post_id", "post_id1");
	post.setProperty("post_message", "post_message1");
	mDataStore = DatastoreServiceFactory.getDatastoreService();
	mDataStore.put(post);
}
}
