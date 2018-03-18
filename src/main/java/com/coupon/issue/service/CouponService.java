package com.coupon.issue.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.coupon.issue.domain.Coupon;
import com.coupon.issue.exception.web.CouponException;

/**
 * Coupon Service interface
 * <pre>
 * com.coupon.issue.service 
 *    |_ CouponService.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:31:27
 * @version : 
 * @author : jms
 */
public interface CouponService {
  
  /**
   * 쿠폰 등록 
   * <pre>
   * 1. 개요 : 이메일 별 쿠폰을 발행하여 등록시킨다.
   * 2. 처리내용 : 1. 이메일 중복 검사, 2. 쿠폰 발행, 3. 쿠폰 중복검사, 이메일, 쿠폰 등록 
   * </pre>
   * @Method Name : insertCoupon
   * @date : 2018. 3. 18.
   * @author : jms
   * @history : 
   *	-----------------------------------------------------------------------
   *	변경일				작성자						변경내용  
   *	----------- ------------------- ---------------------------------------
   *	2018. 3. 18.		jms				최초 작성 
   *	-----------------------------------------------------------------------
   * 
   * @param couponVO
   * @return
   * @throws CouponException
   */
  Coupon insertCoupon(CouponVO couponVO) throws CouponException;

  /**
   * 쿠폰 리스트 조회
   * <pre>
   * 1. 개요 : 쿠폰 리스트를 조회 할 수 있다. 
   * 2. 처리내용 : 등록된 쿠폰 리스트를 page 파라미터를 이용하여 조회할 수 있다.
   * </pre>
   * @Method Name : getCouponList
   * @date : 2018. 3. 18.
   * @author : jms
   * @history : 
   *	-----------------------------------------------------------------------
   *	변경일				작성자						변경내용  
   *	----------- ------------------- ---------------------------------------
   *	2018. 3. 18.		jms				최초 작성 
   *	-----------------------------------------------------------------------
   * 
   * @param pageable
   * @return
   */
  Page<Coupon> getCouponList(Pageable pageable);

}
