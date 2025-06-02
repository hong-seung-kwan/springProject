package com.example.demo.order;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.cart.Cart;
import com.example.demo.cart.CartDTO;
import com.example.demo.member.Member;
import com.example.demo.orderProduct.OrderProductDTO;

public interface OrderService {
	
	void register(OrderDTO dto, List<OrderProductDTO> productDTOList);
	
	List<OrderDTO> getOrderByUserId(String userId);
	
	void remove(int orderNo);
	
	List<OrderDTO> getOrderByDate(String userId,LocalDate startDate,LocalDate endDate);
	
	List<OrderDTO> getOrderByStatus(String userId, String status);
	
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
									.status(order.getStatus())
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
									.status("결제완료")
									.build();
		return entity;
	}

	
}
