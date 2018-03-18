package com.coupon.issue.exception.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.coupon.issue.web.CouponController;

/**
 * Coupon Error Exception Mapping Controller
 * <pre>
 * com.coupon.issue.exception.web 
 *    |_ ExceptionController.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:29:56
 * @version : 
 * @author : jms
 */
@ControllerAdvice(basePackageClasses = CouponController.class)
public class ExceptionController {

  @ExceptionHandler(value = CouponException.class)
  public ResponseEntity<ErrorMessage> errorResovler(CouponException exception) {
    return new ResponseEntity<ErrorMessage>(new ErrorMessage(exception.getErrorCode()),
        HttpStatus.BAD_REQUEST);
  }
}
