package com.cg.order.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ORDER_DETAILS")
@Data
public class OrderDetails {
	
	@Id
	@Column(name="ORDER_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="QUANTITY")
	private int quantity;	
	
	
}
