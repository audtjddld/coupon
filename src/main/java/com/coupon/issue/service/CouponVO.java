package com.coupon.issue.service;

import org.hibernate.validator.constraints.Email;

public class CouponVO {
	@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
