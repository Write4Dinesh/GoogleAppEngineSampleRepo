/**
 * 
 */
package com.din.shwe.businesslogic.blog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.din.shwe.data.PostDao;
import com.din.shwe.data.model.Post;

/**
 * @author Dinesh
 * 
 */
public class BlogPostReaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PostDao postDao = new PostDao();
		String operation = req.getParameter("operation");
		String id = req.getParameter("id");
		if(operation!=null &&id!=null&& operation.equals("delete")){
			postDao.removeById(id);
		}
		resp.getWriter().println("List Of Posts::");
		for(Post post : postDao.getAll()){
			resp.getWriter().println(post);
		}
	}

}
