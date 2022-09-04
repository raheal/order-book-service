package com.phoenix.orderbook.repository.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.phoenix.orderbook.model.OrderStatus;

@Entity
@Table(name="tbl_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	
	@Column(name = "booking_time")
	private LocalTime bookingTime;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "loc_1")
	private String loc1;
	
	@Column(name = "loc_2")
	private String loc2;
	
	@Column(name = "order_status")
	private String orderStatus;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLoc1() {
		return loc1;
	}

	public void setLoc1(String loc1) {
		this.loc1 = loc1;
	}

	public String getLoc2() {
		return loc2;
	}

	public void setLoc2(String loc2) {
		this.loc2 = loc2;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
