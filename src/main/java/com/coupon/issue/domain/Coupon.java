package com.coupon.issue.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Coupon Entity
 * <pre>
 * com.coupon.issue.domain 
 *    |_ Coupon.java
 * 
 * </pre>
 * @date : 2018. 3. 18. 오후 10:29:03
 * @version : 
 * @author : jms
 */
@Entity
public class Coupon implements Serializable {

  private static final long serialVersionUID = -2702333829866847426L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true, name = "user_email")
  private String email;

  @Column(unique = true, name = "coupon")
  private String coupon;

  @Column(name = "reg_date")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date regDate;

  public Coupon() {

  }

  public Coupon(String email, String issueCoupon) {
    this.email = email;
    this.coupon = issueCoupon;
    this.regDate = new Date();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCoupon() {
    return coupon;
  }

  public void setCoupon(String coupon) {
    this.coupon = coupon;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

}
