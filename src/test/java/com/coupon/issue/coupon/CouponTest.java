/*
 * Copyright yysvip.tistory.com.,LTD. All rights reserved.
 * 
 * This software is the confidential and proprietary information of yysvip.tistory.com.,LTD.
 * ("Confidential Information").
 */
package com.coupon.issue.coupon;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.coupon.issue.domain.Coupon;
import com.coupon.issue.exception.web.CouponException;
import com.coupon.issue.exception.web.ErrorCode;
import com.coupon.issue.service.CouponService;
import com.coupon.issue.service.CouponVO;
import static org.junit.Assert.*;

/**
 * <pre>
 * com.coupon.issue.coupon 
 *    |_ CouponTest.java
 * 
 * </pre>
 * 
 * @date : 2018. 3. 18. 오후 10:37:55
 * @version :
 * @author : jms
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CouponTest {
  public static final Logger LOG = LoggerFactory.getLogger(CouponTest.class);

  @Autowired
  private CouponService couponService;

  @Test
  public void test1InsertCoupon() {
    CouponVO couponVO = new CouponVO();
    String email = "a@a.a";
    couponVO.setEmail(email);
    Coupon coupon = couponService.insertCoupon(couponVO);
    assertNotNull(coupon);
    assertSame(email, coupon.getEmail());
    LOG.info("test1 end");
  }

  @Test(expected = CouponException.class)
  public void test2DuplicateEmail() throws CouponException {
    CouponVO couponVO = new CouponVO();
    String email = "a@a.a";
    couponVO.setEmail(email);
    Coupon coupon = couponService.insertCoupon(couponVO);
  }
}
