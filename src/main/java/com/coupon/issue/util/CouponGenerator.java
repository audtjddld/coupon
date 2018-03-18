package com.coupon.issue.util;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CouponGenerator {
	
	public static final Logger LOG = LoggerFactory.getLogger(CouponGenerator.class);
	
	private StringBuilder sb;

	public String getGeneratorCoupon() {
		sb = new StringBuilder();
		String[] strArray = (LocalDate.now().getYear() + "" + System.nanoTime()).split("");
		LOG.info("" + System.nanoTime());
		LOG.info(Arrays.toString(strArray));
		for (int i = 0; i < 16; i++) {
			int number = Integer.parseInt(strArray[i]);
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
