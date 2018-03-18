package com.coupon.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coupon.issue.domain.Coupon;

/**
 * Coupon Repository
 * <pre>
 * com.coupon.issue.repository 
 *    |_ CouponRepository.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:30:14
 * @version : 
 * @author : jms
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {
  Coupon findByEmail(String email);

  Coupon findByCoupon(String coupon);
}
