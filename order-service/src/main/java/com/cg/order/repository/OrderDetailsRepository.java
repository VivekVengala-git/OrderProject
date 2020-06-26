package com.cg.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.order.entity.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> { 
	 List<OrderDetails> findAllByOrderId(Long orderId);	
}
