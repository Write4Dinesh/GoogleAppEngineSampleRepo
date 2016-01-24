package com.example.dinshwecloudclient.utility;

public enum ResponseCode {
	SUCCESS(0, ""),
	NO_NETWORK(-1, "No Network Connectivity"),EXCEPTION(-2, "Thrown Exception"),HTTP_ERROR(-3, "Http Error")
	;
	public int Code;
	public String ErrorDescription;

	private ResponseCode(int code, String description) {
		this.Code = code;
		this.ErrorDescription = description;
	}
}
