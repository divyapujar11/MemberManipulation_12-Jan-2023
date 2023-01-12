package com.cg.membermanipulation.MemberManipulation.exception;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class APIerror {

	private HttpStatus status;
	private String errors;
	private LocalDateTime timeStamp;
	private String uriPath;

	public APIerror() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APIerror(HttpStatus status, String errors, LocalDateTime timeStamp, String uriPath) {
		super();
		this.status = status;
		this.errors = errors;
		this.timeStamp = timeStamp;
		this.uriPath = uriPath;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUriPath() {
		return uriPath;
	}

	public void setUriPath(String uriPath) {
		this.uriPath = uriPath;
	}

}
