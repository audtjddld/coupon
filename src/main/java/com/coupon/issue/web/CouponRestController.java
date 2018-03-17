package com.coupon.issue.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.issue.domain.Coupon;
import com.coupon.issue.service.CouponService;

@RestController
@RequestMapping(value = "/rest/coupons")
public class CouponRestController {

	@Autowired
	private CouponService conponService;
	
	@PostMapping
	public ResponseEntity<Void> registerCoupon() {
		return null;
	}
	
	@GetMapping
	public Page<Coupon> getList() {
		return null;
	}
}