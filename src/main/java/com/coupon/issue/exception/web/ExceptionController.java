package com.coupon.issue.exception.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coupon.issue.web.CouponController;

@ControllerAdvice(basePackageClasses = CouponController.class)
public class ExceptionController {

	@ExceptionHandler(value = CouponException.class)
	public ResponseEntity<ErrorMessage> errorResovler(CouponException exception) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(exception.getErrorCode()), HttpStatus.BAD_REQUEST);
	}
}
