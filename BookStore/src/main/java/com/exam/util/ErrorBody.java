package com.exam.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(content = Include.NON_NULL)
public class ErrorBody {
	private int errorCode;
	private String message;
	private String cause;
	
	public ErrorBody(int errorCode, String message, String cause) {
		this.errorCode = errorCode;
		this.message = message;
		this.cause = cause;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getCause() {
		return cause;
	}

}
