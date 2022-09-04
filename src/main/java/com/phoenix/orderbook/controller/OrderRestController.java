package com.phoenix.orderbook.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.orderbook.model.OrderDto;
import com.phoenix.orderbook.model.OrderStatus;
import com.phoenix.orderbook.service.OrderBookService;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderRestController.class);

	@Autowired
	private OrderBookService orderBookService;
	
	
	@GetMapping("/order/{orderId}")
	public OrderDto getOrder(@PathVariable("orderId") Integer orderId) throws Exception {
		final Optional<OrderDto> orderDto = orderBookService.getOrder(orderId);
		if (orderDto.isPresent()) {
			return orderDto.get();
		} else {
			throw new Exception("Did not receive an order");
		}
	}
	
	@GetMapping("/order/users/{userId}")
	public List<OrderDto> getOrdersByUserId (@PathVariable("userId") final String userId) {
		return orderBookService.getOrders(userId);
	}
	
	@GetMapping("/order/status/{orderStatus}")
	public List<OrderDto> getOrdersByOrderStatus (@PathVariable("orderStatus") final String orderStatus) {
		return orderBookService.getOrders(OrderStatus.valueOf(orderStatus.toUpperCase()));
	}
	
	@PostMapping("/order")
	public OrderDto addOrder(@RequestBody OrderDto orderDto) throws Exception {
		if (orderDto.getTimestamp() == null) {
			orderDto.setTimestamp(LocalDateTime.now());
		}
		final Optional<OrderDto> processedOrderDto = orderBookService.addOrder(orderDto);
		if (processedOrderDto.isPresent()) {
			return processedOrderDto.get();
		}
		throw new Exception ("Cannot add an order to the order book");
	}
	
	@PutMapping("/order")
	public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws Exception {
		final Optional<OrderDto> updatedOrderDto = orderBookService.updateOrder(orderDto);
		if (updatedOrderDto.isPresent()) {
			return updatedOrderDto.get();
		}
		throw new Exception ("Cannot update the order in the order book");
	}
	
}
