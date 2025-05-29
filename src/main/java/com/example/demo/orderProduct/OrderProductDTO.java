package com.example.demo.orderProduct;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductDTO {
	
	int orderProductNo;
	int productId;
	String productName;
	int productQuantity;
	int productPrice;
	String imageUrl;
	LocalDateTime orderDate;
	int orderId;
	int orderPrice;
	 	
}
