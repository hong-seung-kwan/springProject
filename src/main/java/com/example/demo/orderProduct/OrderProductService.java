package com.example.demo.orderProduct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.cart.Cart;
import com.example.demo.order.Order;
import com.example.demo.order.OrderDTO;
import com.example.demo.product.Product;

public interface OrderProductService {
		
	List<OrderProductDTO> getOrderProductByOrderNo(int orderNo);
	
	List<OrderProductDTO> getOrderProductByDate(String userId,LocalDate startDate,LocalDate endDate);
				
	default OrderProduct dtoToEntity(OrderProductDTO dto) {
		
		
		Order order = Order.builder()
							.orderNo(dto.getOrderId()).build();
		
		
		Product product = Product.builder()
				  					.productNo(dto.getProductId())
				  					.build();
				
		OrderProduct entity = OrderProduct.builder()											
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
											.productQuantity(entity.getProductQuantity())
											.productPrice(entity.getProductPrice())
											.imageUrl(entity.getProduct().getImageUrl())	
											.productName(entity.getProduct().getName())
											.orderDate(entity.getOrder().getOrderDate())
											.orderPrice(entity.getOrder().getOrderPrice())
											.status(entity.getOrder().getStatus())
											.productId(entity.getProduct().getProductNo())
											.build();
		
		return dto;
	}
	
}
