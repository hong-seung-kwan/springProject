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
	String name;
	int productQuantity;
	int productPrice;
	int orderPrice;
	LocalDateTime localDate;
	 
	
	
}
