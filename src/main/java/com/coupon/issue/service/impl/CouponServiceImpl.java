package com.coupon.issue.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static final Logger LOG = LoggerFactory.getLogger(CouponServiceImpl.class);

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private CouponGenerator couponGenerator;

	@Override
	@Transactional
	public Coupon insertCoupon(CouponVO couponVO) throws CouponException {
		LOG.info(couponVO.toString());
		// email 검증
		Coupon existCoupon = couponRepository.findByEmail(couponVO.getEmail());

		if (existCoupon != null) {
			throw new CouponException(ErrorCode.DUPLICATE_EMAIL);
		}

		// coupon 발행
		String issueCoupon = couponGenerator.getGeneratorCoupon();

		existCoupon = couponRepository.findByCoupon(issueCoupon);

		if (existCoupon != null) {
			this.insertCoupon(couponVO);
		}

		Coupon coupon = new Coupon(couponVO.getEmail(), issueCoupon);
		couponRepository.save(coupon);
		return coupon;
	}

	@Override
	public Page<Coupon> getCouponList(Pageable pageable) {
		LOG.info(pageable.toString());
		return couponRepository.findAll(pageable);
	}
}
