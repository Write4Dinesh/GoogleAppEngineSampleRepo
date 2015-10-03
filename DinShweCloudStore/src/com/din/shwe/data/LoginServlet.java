package com.din.shwe.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.din.shwe.constants.TableColumn;
import com.din.shwe.data.model.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	private User mCurrentUser;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet: Got request");
		createDummyUser();
		response.setContentType("text/html");
		PrintWriter respWriter = response.getWriter();
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		if (validate(userName, password)) {
			createSession(request);
			RequestDispatcher rd = request.getRequestDispatcher("login_success.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login_fail.html");
			rd.include(request, response);
		}

		respWriter.close();
		// Create a session object if it is already not created.
		HttpSession session = request.getSession(true);
		// Get session creation time.
		Date createTime = new Date(session.getCreationTime());
		// Get last access time of this web page.
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		String title = "Welcome Back to my website";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("ABCD");

		// Check if this is new comer on your web page.
		if (session.isNew()) {
			title = "Welcome to my website";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount = visitCount + 1;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
				+ "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<h2 align=\"center\">Session Infomation</h2>\n"
				+ "<table border=\"1\" align=\"center\">\n"
				+ "<tr bgcolor=\"#949494\">\n"
				+ "  <th>Session info</th><th>value</th></tr>\n" + "<tr>\n"
				+ "  <td>id</td>\n" + "  <td>" + session.getId()
				+ "</td></tr>\n" + "<tr>\n" + "  <td>Creation Time</td>\n"
				+ "  <td>" + createTime + "  </td></tr>\n" + "<tr>\n"
				+ "  <td>Time of Last Access</td>\n" + "  <td>"
				+ lastAccessTime + "  </td></tr>\n" + "<tr>\n"
				+ "  <td>User ID</td>\n" + "  <td>" + userID + "  </td></tr>\n"
				+ "<tr>\n" + "  <td>Number of visits</td>\n" + "  <td>"
				+ visitCount + "</td></tr>\n" + "</table>\n" + "</body></html>");
	}

	private boolean validate(String userName, String password) {
		UserDao userDao = new UserDao();
		this.mCurrentUser = userDao.getUserByUserName(userName);
		if (mCurrentUser != null
				&& mCurrentUser.getPassword().trim().equals(password.trim())) {
			return true;
		}
		return false;
	}

	private void createSession(HttpServletRequest request) {
		// Create a session object if it is already not created.
		HttpSession session = request.getSession(true);
		if (mCurrentUser != null) {
			String sessionId = calculateSessionId(mCurrentUser.getUserName());
			mCurrentUser.setSessionId(sessionId);
			UserDao userDao = new UserDao();
			userDao.updateUser(mCurrentUser);
			session.setAttribute(TableColumn.User.SESSION_ID,
					mCurrentUser.getSessionId());
		} else {
			System.out.println("PrintLog:currentUser object is null");
		}

	}

	private String calculateSessionId(String userName) {
		String sessionId = userName + System.currentTimeMillis();
		sessionId = sessionId.hashCode() + "";
		return sessionId;
	}
	
	private void createDummyUser(){
		User dummy = new User();
		dummy.setIsActive(true);
		dummy.setIsLoggedIn(false);
		dummy.setName("Dummy");
		dummy.setUserName("dUserName");
		dummy.setPassword("dPassword");
		UserDao userDao =  new UserDao();
		userDao.addUser(dummy);
	}
}
