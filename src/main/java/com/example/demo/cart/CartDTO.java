package com.example.demo.cart;

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
public class CartDTO {
	
	int cartNo; 
	
	String user; // 사용자 아이디
	
	int product; // 상품 번호 
	
	int productQuantity;
	
	String name;
	
	int price;
	
	String imageUrl;
	
}
