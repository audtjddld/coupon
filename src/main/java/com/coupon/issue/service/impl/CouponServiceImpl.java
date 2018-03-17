package com.coupon.issue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coupon.issue.domain.Coupon;
import com.coupon.issue.exception.web.CouponException;
import com.coupon.issue.exception.web.ErrorCode;
import com.coupon.issue.repository.CouponRepository;
import com.coupon.issue.service.CouponService;
import com.coupon.issue.service.CouponVO;
import com.coupon.issue.util.CouponGenerator;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private CouponGenerator couponGenerator;

	@Transactional
	public void insertCoupon(CouponVO couponVO) throws CouponException {
		// email 검증
		boolean isExist = couponRepository.existByEmail(couponVO.getEmail());

		if (!isExist) {
			throw new CouponException(ErrorCode.DUPLICATE_EMAIL);
		}

		// coupon 발행
		String issueCoupon = couponGenerator.getGeneratorCoupon();
		Coupon coupon = new Coupon(couponVO.getEmail(), issueCoupon);
		couponRepository.save(coupon);
	}

	public Page<Coupon> getCouponList(Pageable pageable) {
		return couponRepository.findAll(pageable);
	}
}
