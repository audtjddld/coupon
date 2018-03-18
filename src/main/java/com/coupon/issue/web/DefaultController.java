package com.coupon.issue.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AngularJS에 따른 Default Controller.
 * <pre>
 * com.coupon.issue.web 
 *    |_ DefaultController.java
 * -> 404 페이지 일 때 Root Page로 이동시켜야 정상적으로 구동이 가능하다.
 *    때문에 해당 Controller를 작성.
 * </pre>
 * @date : 2018. 3. 18. 오후 10:33:49
 * @version : 
 * @author : jms
 */
@Controller
public class DefaultController implements ErrorController {

  @RequestMapping(value = "/error")
  public String redirectingInitalPage() {
    return "redirect:/coupon";
  }

  @Override
  public String getErrorPath() {
    // TODO Auto-generated method stub
    return "/error";
  }

}
