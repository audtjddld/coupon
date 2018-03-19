package com.coupon.issue.util;

import java.security.SecureRandom;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Coupon Generator
 * <pre>
 * com.coupon.issue.util 
 *    |_ CouponGenerator.java
 * 
 * </pre>
 * @date : 2018. 3. 19. 오전 10:56:53
 * @version : 
 * @author : jms
 */
@Component
public class CouponGenerator {

  public static final Logger LOG = LoggerFactory.getLogger(CouponGenerator.class);

  private StringBuilder sb;

  public String getGeneratorCoupon() {
    sb = new StringBuilder();
    String[] strArray = getNumbers().split("");
    Random ran = new SecureRandom();
    int ranNumber = ran.nextInt(16) + 1;
    for (int i = 0; i < 16; i++) {
      int number = Integer.parseInt(strArray[i]);
      if (i > 0 && i % 4 == 0) {
        sb.append("-");
      }
      int mod = number % 3;
      switch (mod) {
        case 0:
          sb.append((char) (97 + number + ranNumber));
          break;
        case 1:
          sb.append((number + ranNumber) % 9);
          break;
        case 2:
          sb.append((char) (65 + number + ranNumber));
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
