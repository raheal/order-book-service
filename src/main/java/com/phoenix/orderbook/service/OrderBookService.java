package com.phoenix.orderbook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.phoenix.orderbook.model.OrderDto;
import com.phoenix.orderbook.model.OrderStatus;

public interface OrderBookService {

	/**
	 * Get orders from within a date range
	 * @param dateFrom			date from
	 * @param dateTo			date to
	 * @return					a collection or orders
	 */
	List<OrderDto> getOrders (final LocalDate dateFrom, final LocalDate dateTo);
	
	/**
	 * Get orders based on a userId
	 * @param userId			userId
	 * @return					a collection of orders
	 */
	List<OrderDto> getOrders (final String userId);
	
	
	/**
	 * Get orders based on the order status
	 * @param orderStatus		the order status
	 * @return					a collection of orders
	 */
	List<OrderDto> getOrders (final OrderStatus orderStatus);
	
	/**
	 * Get a specific order
	 * @param orderId			the order id
	 * @return					an order object (if it exists)
	 */
	Optional<OrderDto> getOrder (final Integer orderId);
	
	
	/**
	 * Add an order to the service
	 * @param order				the order
	 * @return					a copy of the order that has been added
	 */
	Optional<OrderDto> addOrder (final OrderDto order);
	
	/**
	 * Update an existing order
	 * @param order				the updated order
	 * @return					a copy of the order that has been updated
	 */
	Optional<OrderDto> updateOrder (final OrderDto order);
	
	
	
}
