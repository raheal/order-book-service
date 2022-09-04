package com.phoenix.orderbook.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.orderbook.model.OrderDto;
import com.phoenix.orderbook.model.OrderStatus;
import com.phoenix.orderbook.repository.OrderRepository;
import com.phoenix.orderbook.repository.dao.Order;
import com.phoenix.orderbook.service.OrderBookService;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderBookServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public List<OrderDto> getOrders(LocalDate dateFrom, LocalDate dateTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDto> getOrders(final String userId) {
		final List<Order> orders = orderRepository.findByUserId(userId);
		if (!orders.isEmpty()) {
			return orders.stream().map(s -> OrderDto.of(s)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public List<OrderDto> getOrders(final OrderStatus orderStatus) {
		final List<Order> orders = orderRepository.findByOrderStatus(orderStatus.name());
		if (!orders.isEmpty()) {
			return orders.stream().map(s -> OrderDto.of(s)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public Optional<OrderDto> getOrder(Integer orderId) {
		final Optional<Order> order = orderRepository.findOrderByOid(orderId);
		if (order.isPresent()) {
			final OrderDto orderDto = OrderDto.of(order.get());
			return Optional.of(orderDto);
		}
		return Optional.empty();
	}

	@Override
	public Optional<OrderDto> addOrder(OrderDto orderDto) {
		final Order newOrder = orderRepository.save(OrderDto.of(orderDto));
		if (newOrder != null) {
			return Optional.of(OrderDto.of(newOrder));
		}
		return Optional.empty();
	}

	@Override
	public Optional<OrderDto> updateOrder(OrderDto orderDto) {
		final Order updatedOrder = orderRepository.save(OrderDto.of(orderDto));
		if (updatedOrder != null) {
			return Optional.of(OrderDto.of(updatedOrder));
		}
		return Optional.empty();
	}

	
}
