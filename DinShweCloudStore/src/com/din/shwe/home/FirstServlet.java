package com.din.shwe.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Post post = populatePost(request);
		response.getWriter().println("Post posted:" + post);
		response.setContentType("text/plain");
		response.getWriter().println(
				"Welcome! This is a Servlet that created this Html page");
		response.getWriter().println("Another line goes here");
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
		Entity postEntity = new Entity("Post", post.getId());
		postEntity.setProperty(TableColumn.Post.TITLE, post.getTitle());
		postEntity.setProperty(TableColumn.Post.DATE, post.getDate());
		postEntity.setProperty(TableColumn.Post.ID, post.getId());
		postEntity.setProperty(TableColumn.Post.MESSAGE, post.getMessage());
		return postEntity;
	}
	private Post populatePost(HttpServletRequest request){
		Post post = new Post();
		post.setTitle(request.getParameter("title"));
		post.setMessage(request.getParameter("message"));
		String currentDateTime = System.currentTimeMillis() + "";
		post.setDate(new Date().toString());
		post.setId(currentDateTime);
		return post;
	}
}
