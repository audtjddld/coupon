package com.coupon.issue.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coupon.issue.domain.Coupon;
import com.coupon.issue.exception.web.CouponException;

public interface CouponService {

	Coupon insertCoupon(CouponVO couponVO) throws CouponException;

	Page<Coupon> getCouponList(Pageable pageable);

}
