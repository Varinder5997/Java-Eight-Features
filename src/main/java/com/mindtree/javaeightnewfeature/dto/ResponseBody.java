package com.mindtree.javaeightnewfeature.dto;

public class ResponseBody<T> {
	
	
	private T body;
	private ErrorResponse error;
	private String message;
	private boolean success;
	
	
	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseBody(T body, ErrorResponse error, String message, boolean success) {
		super();
		this.body = body;
		this.error = error;
		this.message = message;
		this.success = success;
	}

	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
