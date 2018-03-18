package com.coupon.issue.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Coupon Web Controller
 * <pre>
 * com.coupon.issue.web 
 *    |_ CouponController.java
 * > 쿠폰의 view template를 보여주기 위한 Controller 이다.
 * </pre>
 * @date : 2018. 3. 18. 오후 10:36:11
 * @version : 
 * @author : jms
 */
@Controller
@RequestMapping(value = "/coupon")
public class CouponController {

  @GetMapping
  public String listPage() {
    return "index";
  }
}
