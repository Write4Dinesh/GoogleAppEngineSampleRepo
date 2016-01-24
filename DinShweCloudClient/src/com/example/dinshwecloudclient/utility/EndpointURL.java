package com.example.dinshwecloudclient.utility;

public enum EndpointURL {
REMOTE_GOOGLE_APPSPOT_URL("http://dinshwecloudstore.appspot.com/Services/V1/GetAllPosts"),
LOCAL_GOOGLE_APPSPOT_URL("http://10.0.2.2:8888/Services/V1/GetAllPosts");
	
	private String mURL;
	private EndpointURL(String url){
	 mURL = url; 	
	}
  public String toString(){
	  return  mURL;
  }
}
