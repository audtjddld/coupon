package com.coupon.issue.exception.web;

/**
 * Coupon Error Message
 * <pre>
 * com.coupon.issue.exception.web 
 *    |_ ErrorMessage.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:29:45
 * @version : 
 * @author : jms
 */
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
