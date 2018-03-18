/*
 * Copyright yysvip.tistory.com.,LTD. All rights reserved.
 * 
 * This software is the confidential and proprietary information of yysvip.tistory.com.,LTD.
 * ("Confidential Information").
 */
package com.coupon.issue.coupon.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <pre>
 * com.coupon.issue.coupon.api 
 *    |_ CouponApiTest.java
 * 
 * </pre>
 * 
 * @date : 2018. 3. 18. 오후 11:03:44
 * @version :
 * @author : jms
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CouponApiTest {
  public static final Logger LOG = LoggerFactory.getLogger(CouponApiTest.class);

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void before() {
    mockMvc = MockMvcBuilders
              .webAppContextSetup(this.wac)
              .alwaysDo(MockMvcResultHandlers.print())
              .build();
  }

  @Test
  public void test1InsertCoupon() throws Exception {
    JSONObject param = new JSONObject();
    param.put("email", "test@test.com");
    
    mockMvc.perform(post("/rest/coupons")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(param.toString())
            ).andExpect(status().is(201));
  }
  
  @Test
  public void test2SelectCoupon() throws Exception {
    mockMvc.perform(get("/rest/coupons"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
      .andExpect(jsonPath("$.content[0].email").value("test@test.com"))
      .andReturn()
      .getResponse();
  }
  
  @Test
  public void test3DuplicateEmail() throws Exception {
    JSONObject param = new JSONObject();
    param.put("email", "test@test.com");
    
    mockMvc.perform(post("/rest/coupons")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(param.toString())
            ).andExpect(status().is(400));
  }
}
