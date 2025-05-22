package com.example.demo.order;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cart.CartRepository;
import com.example.demo.orderProduct.OrderProduct;
import com.example.demo.orderProduct.OrderProductDTO;
import com.example.demo.orderProduct.OrderProductRepository;
import com.example.demo.orderProduct.OrderProductService;
import com.example.demo.product.Product;
import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository repository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderProductRepository orderProductRepository;
	@Autowired
	OrderProductService orderProductService;
	
	
	@Override
	public void register(OrderDTO dto, OrderProductDTO orderProductDTO) {
		
		
		Order order = dtoToEntity(dto);
		repository.save(order);
		
		Product product = productRepository.findById(orderProductDTO.getProductId()).orElseThrow();
			    
//		orderProductDTO.setOrderProductNo(0);
		
		OrderProduct orderProduct = orderProductService.dtoToEntity(orderProductDTO);
		orderProduct.setOrder(order);
		orderProduct.setProduct(product);

		orderProductRepository.save(orderProduct);

		

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
