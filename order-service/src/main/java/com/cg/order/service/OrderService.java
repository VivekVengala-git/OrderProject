package com.cg.order.service;

import java.util.List;

import com.cg.order.entity.OrderEntity;
import com.cg.order.model.OrderModel;
import com.cg.order.model.OrderModelResponse;

public interface OrderService {
	OrderEntity createOrder(OrderModel order);

	
	List<OrderEntity> getAllOrders();

	OrderModelResponse getOrderById(long orderId);


}
