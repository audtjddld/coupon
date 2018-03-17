package com.coupon.issue.exception.web;

public class ErrorMessage {
	private ErrorCode errorCode;

	public ErrorMessage(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
