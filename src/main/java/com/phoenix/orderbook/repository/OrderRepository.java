package com.phoenix.orderbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phoenix.orderbook.repository.dao.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

	Optional<Order> findOrderByOid(Integer oid);
	
	List<Order> findByUserId (String userId);
	
	List<Order> findByOrderStatus (String orderStatus);
	
}
