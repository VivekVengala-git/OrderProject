package com.cg.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "ORDER_ENTITY")
@Data
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "shippingaddress")
	private String shippingAddress;

	@Column(name = "totalprice")
	private BigDecimal totalPrice;

	@CreationTimestamp
	private Date orderDate;

}
