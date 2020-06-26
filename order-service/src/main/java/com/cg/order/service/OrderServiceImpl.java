package com.cg.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.order.entity.OrderDetails;
import com.cg.order.entity.OrderEntity;
import com.cg.order.exception.ResourceNotFoundException;
import com.cg.order.feign.OrderItemClient;
import com.cg.order.model.OrderItemModel;
import com.cg.order.model.OrderItemsModel;
import com.cg.order.model.OrderModel;
import com.cg.order.model.OrderModelResponse;
import com.cg.order.repository.OrderDetailsRepository;
import com.cg.order.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OrderItemClient orderItemClient;

	@Override
	public OrderEntity createOrder(OrderModel orderDto) {
		// TODO Auto-generated method stub
		BigDecimal sum;
		OrderEntity order = new OrderEntity();

		// order.setShippingAddress(orderDto.get);
		// sum = orderDto.getOrderItems().stream().map(x -> x.getPrice()).reduce(BigDecimal::add).get();

	//	orderDto.setTotalPrice(sum);
		BeanUtils.copyProperties(orderDto, order);

		// return orderRepository.save(order);
		orderRepository.save(order);
		for (OrderItemsModel od : orderDto.getOrderItems()) {
			OrderDetails orddetails = new OrderDetails();
			BeanUtils.copyProperties(od, orddetails);
			orddetails.setOrderId(order.getOrderId());

			orderDetailsRepository.save(orddetails);

		}
		order.getOrderId();

		System.out.println("order  :: " + order.toString());
		return order;
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}

	@Override
	public OrderModelResponse getOrderById(long orderId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<String> orderList = new ArrayList<String>();

		Optional<OrderEntity> order = orderRepository.findById(orderId);
		Optional<List<OrderDetails>> orderDetails = Optional.ofNullable(orderDetailsRepository.findAllByOrderId(orderId));
//OrderItem orderItem=new OrderItem();
		OrderModelResponse orderModel = new OrderModelResponse();
		// order.get().getOrderItems().stream().map(x ->
		// x.getProductCode()).collect(Collectors.toList());
//orderItem=orderItemClient.getOrderItem(orderId);
		orderList = orderDetails.get().stream().map(x -> x.getProductCode()).collect(Collectors.toList());
		// orderItemModelList= orderItemClient.getOrderItem(orderList);
		Optional<List<OrderItemModel>> orderItemModelList = Optional
				.ofNullable(orderItemClient.getOrderItem(orderList));
		if (order.isPresent()) {
			BeanUtils.copyProperties(order.get(), orderModel);
			if (orderItemModelList.isPresent()) {
				orderModel.setOrderItems(orderItemModelList.get());
			}
			return orderModel;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + orderId);
		}
	}

}
