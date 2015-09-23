package com.din.shwe.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.din.shwe.constants.TableColumn;
import com.din.shwe.data.model.Post;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {
	private DatastoreService mDataStore = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println(
				"Welcome! This is a Servlet that created this Html page");
		response.getWriter().println("Another line goes here");
		Post post = new Post();
		post.setTitle("post_title2");
		post.setDate("post_date1");
		post.setMessage("post_message1");
		post.setId("123");
		persistPost(post);
	}

	private void persistPost(Post post) {
		mDataStore = DatastoreServiceFactory.getDatastoreService();
		mDataStore.put(populateEntity(post));
	}
	private void persistPost(List<Post> posts){
		List<Entity> entities = new ArrayList<Entity>(posts.size());
		for(Post post : posts){
			entities.add(populateEntity(post));
		}
		mDataStore = DatastoreServiceFactory.getDatastoreService();
		mDataStore.put(entities);
	}
	private Entity populateEntity(Post post){
		Entity postEntity = new Entity(TableColumn.Post.ID, post.getId());
		postEntity.setProperty(TableColumn.Post.TITLE, post.getTitle());
		postEntity.setProperty(TableColumn.Post.DATE, post.getDate());
		postEntity.setProperty(TableColumn.Post.ID, post.getId());
		postEntity.setProperty(TableColumn.Post.MESSAGE, post.getMessage());
		return postEntity;
	}
}
