package com.cg.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.order.entity.OrderEntity;
import com.cg.order.model.OrderModel;
import com.cg.order.model.OrderModelResponse;
import com.cg.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderservice;

	@GetMapping("/getOrders")
	public ResponseEntity<List<OrderEntity>> getAllOrder() {
		return ResponseEntity.ok().body(orderservice.getAllOrders());
	}

	@GetMapping("/getOrders/{id}")
	public ResponseEntity<OrderModelResponse> getOrderById(@PathVariable long id) {
		return ResponseEntity.ok().body(orderservice.getOrderById(id));
	}

	@PostMapping("/createOrders")
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderModel order) {
		return ResponseEntity.ok().body(this.orderservice.createOrder(order));
	}

	
}
