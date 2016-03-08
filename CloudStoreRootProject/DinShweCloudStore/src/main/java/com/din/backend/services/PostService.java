package com.din.backend.services;

import com.din.backend.data.PostDao;
import com.din.backend.data.model.Post;
import com.din.backend.utility.DinCryptoAndSecurity;
import com.google.gson.mm.Gson;
import com.google.gson.mm.GsonBuilder;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostService extends HttpServlet {
private String mRequestUri = null;
private String mUserAgent = null;
private String mQueryString = null;
private HttpServletRequest mHttpRequest = null;
private HttpServletResponse mHttpResponse = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mHttpRequest = request;
		mHttpResponse = response;
		mRequestUri = mHttpRequest.getRequestURI();
		mUserAgent = mHttpRequest.getHeader("User-Agent");
		mQueryString = mHttpRequest.getQueryString();
		
		mHttpResponse.setContentType("application/json");
		//response.getWriter().write("<h1>ServiceURI = /Services/V1/GetAllPosts</h1><Br/>");
		System.out.println("User-Agent:" + mUserAgent);
		System.out.println("Request URI=" + this.mRequestUri);
		System.out.println("Query String=" + mQueryString);
		String outputJson = null;
		if(mRequestUri==null || mRequestUri.isEmpty()){
			System.out.println("Request URI is null or Empty");
			mHttpResponse.getWriter().write("Request URI null or Empty");
			return;
		}
		if(mRequestUri.equals("/Services/V1/GetAllPosts")){
		 outputJson = getAllPosts();
		}
		else if (mRequestUri.equals("")){
			//TODO:
		}
		DinCryptoAndSecurity cryptoService = new DinCryptoAndSecurity();
		String encryptionKey, initVector, dataToBeEncrypted;
		encryptionKey = "dinesh@masthaiah";
		initVector = "RandomInitVector";
		dataToBeEncrypted = outputJson;
		String encrypted = cryptoService.encrypt(encryptionKey, initVector, dataToBeEncrypted);
		mHttpResponse.getWriter().write(encrypted);
		mHttpResponse.getWriter().close();
	}
 private String getAllPosts(){
	 PostDao postDao = new PostDao();
		List<Post> posts = postDao.getAll();
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(posts);
		return json;
 }
}
