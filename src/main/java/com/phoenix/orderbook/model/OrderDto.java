package com.phoenix.orderbook.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.phoenix.orderbook.repository.dao.Order;

public class OrderDto {

	private Integer orderId;
	
	private String userId;
	
	private LocalDateTime timestamp;
	
	private LocalDate bookingDate;
	
	private LocalTime bookingTime;
	
	private BigDecimal price;
	
	private String loc1;
	
	private String loc2;
	
	private OrderStatus orderStatus;

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
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public static final OrderDto of (final Order order) {
		final OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(order.getOid());
		orderDto.setUserId(order.getUserId());
		orderDto.setTimestamp(order.getTimestamp());
		orderDto.setPrice(order.getPrice());
		orderDto.setBookingDate(order.getBookingDate());
		orderDto.setBookingTime(order.getBookingTime());
		orderDto.setLoc1(order.getLoc1());
		orderDto.setLoc2(order.getLoc2());
		orderDto.setOrderStatus(OrderStatus.valueOf(order.getOrderStatus()));
		return orderDto;
	}
	
	public static final Order of (final OrderDto orderDto) {
		final Order order = new Order();
		order.setUserId(orderDto.getUserId());
		order.setTimestamp(orderDto.getTimestamp());
		order.setPrice(orderDto.getPrice());
		order.setBookingDate(orderDto.getBookingDate());
		order.setBookingTime(orderDto.getBookingTime());
		order.setLoc1(orderDto.getLoc1());
		order.setLoc2(orderDto.getLoc2());
		order.setOrderStatus(orderDto.getOrderStatus().name());
		return order;
	}
	
}
