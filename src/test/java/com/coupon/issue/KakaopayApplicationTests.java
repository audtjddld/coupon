package com.coupon.issue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.coupon.issue.service.CouponService;
import com.coupon.issue.service.CouponVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaopayApplicationTests {

	@Autowired
	private CouponService couponService;
	
	@Test
	public void contextLoads() throws InterruptedException {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		es.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0 ; i < 100000; i++) {
					String email = Thread.currentThread().getName() + "abc" + i + "@abc.com";
					CouponVO couponVO = new CouponVO();
					couponVO.setEmail(email);
					couponService.insertCoupon(couponVO);
				}
			}
		});
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0 ; i < 100000; i++) {
					String email = Thread.currentThread().getName() + "abcd" + i + "@abc.com";
					CouponVO couponVO = new CouponVO();
					couponVO.setEmail(email);
					couponService.insertCoupon(couponVO);
				}
			}
		});
		TimeUnit.MINUTES.sleep(1);
	}

}
