package com.coupon.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coupon.issue.domain.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{
	Coupon findByEmail(String email);
	
	Coupon findByCoupon(String coupon);
}