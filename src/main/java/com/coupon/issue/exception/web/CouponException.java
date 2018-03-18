package com.coupon.issue.exception.web;

/**
 * Coupon Server Exception
 * <pre>
 * com.coupon.issue.exception.web 
 *    |_ CouponException.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:29:20
 * @version : 
 * @author : jms
 */
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
