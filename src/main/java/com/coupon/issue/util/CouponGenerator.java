package com.coupon.issue.util;

import org.springframework.stereotype.Component;

@Component
public class CouponGenerator {
	private String[] strArray;

	private StringBuilder sb = new StringBuilder();

	public String getGeneratorCoupon() {
		strArray = ("1" + System.nanoTime()).split("");

		for (int i = 0; i < 16; i++) {
			int number = Integer.valueOf(strArray[i]);
			if (i > 0 && i % 4 == 0) {
				sb.append("-");
			}
			int mod = number % 3;
			switch (mod) {
			case 0:
				sb.append((char) (97 + number));
				break;
			case 1:
				sb.append(number);
				break;
			case 2:
				sb.append((char) (65 + number));
				break;
			default:
				break;
			}
		}

		return sb.toString();
	}
}
