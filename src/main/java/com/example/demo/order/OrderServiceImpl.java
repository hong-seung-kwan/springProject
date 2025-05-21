package com.example.demo.order;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.CartRepository;
import com.example.demo.orderProduct.OrderProduct;
import com.example.demo.orderProduct.OrderProductDTO;
import com.example.demo.orderProduct.OrderProductService;
import com.example.demo.product.ProductRepository;

import lombok.Getter;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderProductService orderProductService;
	
	
	@Override
	public int register(OrderDTO dto) {
		
		
		Order order = dtoToEntity(dto);
		repository.save(order);
		int orderNo = order.getOrderNo();
		
//		List<OrderProductDTO> productDTO = dto.getOrderProductDTO();
//		for(OrderProductDTO orderProductDTO : productDTO) {
//			OrderProduct orderProduct = OrderProduct.builder()
//											.order(order)
//											.product(productRepository.findById(productDTO.get()))
//		}
		
		return orderNo;
	}


	@Override
	public List<OrderDTO> getOrderByUserId(String userId) {
		
		List<Order> list = repository.findByUserUserId(userId);
		
		List<OrderDTO> dtolist = new ArrayList<>();
		
		for(Order order : list) {
			OrderDTO dto = entityToDto(order);
			
			List<OrderProductDTO> productDTO = orderProductService.getOrderProductByOrderNo(order.getOrderNo());
			dto.setOrderProductDTO(productDTO);
			dtolist.add(dto);
		}
				
		return dtolist;
	}

}
