package com.exam.resource;

import javax.ws.rs.core.Response.Status;

import com.exam.util.ErrorBody;


public class BaseResource {
	protected ErrorBody getResponseFromError(Throwable th, Status status) {
		ErrorBody errorBody = new ErrorBody(status.getStatusCode(), status.toString(), th.getMessage());
		return errorBody;
	}
}
