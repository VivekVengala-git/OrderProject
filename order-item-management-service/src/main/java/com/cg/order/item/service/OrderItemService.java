package com.cg.order.item.service;

import java.util.List;

import com.cg.order.item.entity.OrderItem;
import com.cg.order.item.model.OrderItemModel;

public interface OrderItemService {
	OrderItem createOrderItem(OrderItemModel order);

	
	List<OrderItem> getAllOrderItems();

	List<OrderItem> getOrderItemById(List<String> orderId);


}
