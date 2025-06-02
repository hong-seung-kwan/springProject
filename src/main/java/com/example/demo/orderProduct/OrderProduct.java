package com.example.demo.orderProduct;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.cart.Cart;
import com.example.demo.order.Order;
import com.example.demo.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orderProduct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(value = { AuditingEntityListener.class })
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderProductNo;
	
	@ManyToOne
	@JoinColumn(name="orderNo")
	Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productNo")
	Product product;
	
	@Column
	int productQuantity;
	
	@Column
	int productPrice;

}
