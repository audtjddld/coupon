package com.coupon.issue.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/coupon")
public class CouponController {

	@GetMapping
	public String listPage() {
		return "index";
	}
}
