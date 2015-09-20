package com.din.shwe.home;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println("Welcome! This is a Servlet that created this Html page");
	 response.getWriter().println("Another line goes here");
	}
}
