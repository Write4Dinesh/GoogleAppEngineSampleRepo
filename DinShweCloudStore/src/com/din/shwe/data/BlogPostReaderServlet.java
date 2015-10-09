/**
 * 
 */
package com.din.shwe.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.din.shwe.data.model.Post;

/**
 * @author Dinesh
 * 
 */
public class BlogPostReaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String postId = "1443025300483";
		PostDao pDao = new PostDao();
		PrintWriter respWriter = resp.getWriter();
		Post post = pDao.getPostByPostId(postId);
		
		System.out.println("Post with id = " + post);
		respWriter.println("POST with Id=[ " + post + " ]");
		pDao.remove(post);
		respWriter.println("****************All POST*****************");
        for(Post p :pDao.getAll() ){
        	respWriter.println(p);
        }
        resp.getWriter().println("*********************************");
        pDao.insertPost(post);
        
        respWriter.println("****************All POST*****************");
        for(Post p :pDao.getAll() ){
        	respWriter.println(p);
        }
        resp.getWriter().println("*********************************");
        
	}

}
