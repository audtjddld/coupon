package com.coupon.issue.web;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.issue.domain.Coupon;
import com.coupon.issue.exception.web.CouponException;
import com.coupon.issue.exception.web.ErrorCode;
import com.coupon.issue.service.CouponService;
import com.coupon.issue.service.CouponVO;

@RestController
@RequestMapping(value = "/rest/coupons")
public class CouponRestController {

	public static final Logger LOG = LoggerFactory.getLogger(CouponRestController.class);
	
	@Autowired
	private CouponService couponService;

	@PostMapping
	public ResponseEntity<Void> registerCoupon(@RequestBody @Valid CouponVO couponVO, BindingResult bindingResult) throws CouponException, URISyntaxException {
		URI uri = null;
		LOG.info(couponVO.toString());
		if (bindingResult.hasErrors()) {
			throw new CouponException(ErrorCode.INVALID_EMAIL);
		}
		
		Coupon coupon = couponService.insertCoupon(couponVO);
		uri = new URI("/rest/coupons/" + coupon.getId());
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public Page<Coupon> getList(Pageable pageable) {
		return couponService.getCouponList(pageable);
	}

	@GetMapping(value = "testData")
	public void createTestData() throws URISyntaxException, CouponException {
		CouponVO couponVO = new CouponVO();
		for (int i = 2 ; i < 200; i ++) {
			couponVO.setEmail(String.format("test%d@test.com", i));
			couponService.insertCoupon(couponVO); 
		}
	}
}