package com.example.demo.orderProduct;

import java.util.List;

import com.example.demo.order.Order;
import com.example.demo.product.Product;

public interface OrderProductService {
	
	int register(OrderProductDTO dto);
	
	List<OrderProductDTO> getOrderProductByOrderNo(int orderNo);
	
	default OrderProduct dtoToEntity(OrderProductDTO dto) {
		
		
		Order order = Order.builder()
							.orderNo(dto.getOrderId()).build();
		
		
		Product product = Product.builder()
				  					.productNo(dto.getProductId())
				  					.build();
		
		OrderProduct entity = OrderProduct.builder()
											.orderProductNo(dto.getProductId())
											.order(order)
											.product(product)
											.productQuantity(dto.getProductQuantity())
											.productPrice(dto.getProductPrice())
											.build();
		
		return entity;
	}
	
	default OrderProductDTO entityToDto(OrderProduct entity) {
		
		OrderProductDTO dto = OrderProductDTO.builder()
											.orderProductNo(entity.getOrderProductNo())
											.orderId(entity.getOrder().getOrderNo())
											.orderProductNo(entity.getProduct().getProductNo())
											.productQuantity(entity.getProductQuantity())
											.productPrice(entity.getProductPrice())
											.build();
		
		return dto;
	}
	
}
