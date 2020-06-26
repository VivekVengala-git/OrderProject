package com.cg.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
