package com.example.demo.order;

import java.util.List;

import com.example.demo.member.Member;
import com.example.demo.orderProduct.OrderProductDTO;

public interface OrderService {
	
	void register(OrderDTO dto, List<OrderProductDTO> productDTOList);
	
	List<OrderDTO> getOrderByUserId(String userId);
	
	
	default OrderDTO entityToDto(Order order) {
		String userId = order.getUser().getUserId();
		
		OrderDTO dto = OrderDTO.builder()
									.orderNo(order.getOrderNo())
									.orderName(order.getOrderName())
									.orderPrice(order.getOrderPrice())
									.zipCode(order.getZipCode())
									.streetAdr(order.getStreetAdr())
									.address(order.getAddress())
									.orderReq(order.getOrderReq())
									.orderDate(order.getOrderDate())
									.user(userId)
									.payment(order.getPayment())
									.build();
		return dto;
	}
	
	default Order dtoToEntity(OrderDTO dto) {
		
		Member member = Member.builder().userId(dto.getUser()).build();
		
		Order entity = Order.builder()
									.orderNo(dto.getOrderNo())
									.orderName(dto.getOrderName())
									.orderPrice(dto.getOrderPrice())
									.zipCode(dto.getZipCode())
									.streetAdr(dto.getStreetAdr())
									.address(dto.getAddress())
									.orderReq(dto.getOrderReq())
									.orderDate(dto.getOrderDate())
									.user(member)
									.payment(dto.getPayment())
									.build();
		return entity;
	}

	
}
