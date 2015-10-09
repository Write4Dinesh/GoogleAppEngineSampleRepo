package com.din.shwe.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.din.shwe.constants.AppConstants;
import com.din.shwe.constants.TableColumn;
import com.din.shwe.data.UserDao;
import com.din.shwe.data.model.Post;
import com.din.shwe.data.model.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
/**
 * This class retrieves blog post details from the http request and saves the blog information
 * to data store.once the data has been saved, the acknowledgment will be sent to client by creating 
 * html content putting the same into http response
 * @author dinesh.k.masthaiah
 *
 */
@SuppressWarnings("serial")
public class BlogPostServlet extends HttpServlet {
	private DatastoreService mDataStore = null;
	private User mCurrentUser;
	private HttpServletRequest mHttpRequest;
	private HttpServletResponse mHttpResponse;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		mHttpRequest = request;
		mHttpResponse = response;
		checkIfSessionValid();
		Post post = populatePost(mHttpRequest);
		response.setContentType("text/plain");
		savePost(post);
		response.getWriter().println("Your post:" + post + " is saved");
	}

	private void savePost(Post post) {
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
		UserDao dao = new UserDao();
		Entity userEntity = dao.getUserEntityByUserName(mCurrentUser.getUserName());
		Entity postEntity = new Entity(TableColumn.Post.TABLE_NAME, post.getId(),userEntity.getKey());
		postEntity.setProperty(TableColumn.Post.TITLE, post.getTitle());
		postEntity.setProperty(TableColumn.Post.DATE, post.getDate());
		postEntity.setProperty(TableColumn.Post.ID, post.getId());
		postEntity.setProperty(TableColumn.Post.MESSAGE, post.getMessage());
		return postEntity;
	}
	private Post populatePost(HttpServletRequest request){
		Post post = new Post();
		post.setTitle(request.getParameter(TableColumn.Post.TITLE.toLowerCase()));
		post.setMessage(request.getParameter(TableColumn.Post.MESSAGE.toLowerCase()));
		post.setDate(new Date().toString());
		post.setId(System.currentTimeMillis() + "");
		return post;
	}
	private void checkIfSessionValid() throws ServletException, IOException{
		HttpSession session = mHttpRequest.getSession();
		if(session==null){
			//TODO: not logged in.. redirect them to login page
			RequestDispatcher rd = mHttpRequest.getRequestDispatcher("login_screen.html");
			rd.forward(mHttpRequest, mHttpResponse);
		}
		mCurrentUser = (User) session.getAttribute(TableColumn.User.TABLE_NAME);
		if(mCurrentUser==null){
			//TODO: problem with user log in..logout and then... redirect them to login page
			session.invalidate();
			RequestDispatcher rd = mHttpRequest.getRequestDispatcher("login_screen.html");
			rd.forward(mHttpRequest, mHttpResponse);
		}
		if(session.isNew()){
			//TODO: session just got created and did not send yet to client.. i.e this is the first request from client
		System.out.println(AppConstants.LoG_TAG + " New Session");
		}
		
		
		
	}
}
