package com.coupon.issue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CouponGenerator {

  public static final Logger LOG = LoggerFactory.getLogger(CouponGenerator.class);

  private StringBuilder sb;

  public String getGeneratorCoupon() {
    sb = new StringBuilder();
    String[] strArray = getNumbers().split("");
    //LOG.info(Arrays.toString(strArray));
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

  private String getNumbers() {
    return String.format("%d%d", System.nanoTime(), System.currentTimeMillis());
  }
}
