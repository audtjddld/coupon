package com.coupon.issue.exception.web;

public class CouponException extends RuntimeException {
	private static final long serialVersionUID = 9114358604053461536L;
	private ErrorCode ErrorCode;

	public CouponException(ErrorCode errorCode) {
		this.ErrorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return ErrorCode;
	}

}
