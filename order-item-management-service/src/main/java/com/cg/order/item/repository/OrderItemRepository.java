package com.cg.order.item.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.order.item.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
		List<OrderItem> findAllByProductCodeIn(List<String> ids);	 	
}
