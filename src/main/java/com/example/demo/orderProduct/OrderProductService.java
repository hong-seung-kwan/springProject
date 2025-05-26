package com.example.demo.orderProduct;

import java.util.List;
import com.example.demo.order.Order;
import com.example.demo.product.Product;

public interface OrderProductService {
		
	List<OrderProductDTO> getOrderProductByOrderNo(int orderNo);
	
	
			
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
		
		// 상품가격 상품수량 상품가격 총가격 이미지url 
		OrderProductDTO dto = OrderProductDTO.builder()
											.orderProductNo(entity.getOrderProductNo())
											.orderId(entity.getOrder().getOrderNo())											
											.productQuantity(entity.getProductQuantity())
											.productPrice(entity.getProductPrice())
											.imageUrl(entity.getProduct().getImageUrl())	
											.productName(entity.getProduct().getName())
											.build();
		
		return dto;
	}
	
}
