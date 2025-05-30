package com.example.demo.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.orderProduct.OrderProductDTO;

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
public class OrderDTO {
	
	int orderNo;
	String user; // 사용자 아이디
	LocalDateTime orderDate;
	int orderPrice;
	String zipCode;
	String streetAdr;
	String address;
	String orderName;
	String orderReq;
	String payment;
	String status;
	
	List<OrderProductDTO> orderProductDTO;
	
}
