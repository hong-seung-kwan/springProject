package com.example.demo.order;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cart.CartRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;
	@Autowired
	CartRepository cartRepository;
	
	
	@Override
	public int register(OrderDTO dto) {
		
		
		Order order = dtoToEntity(dto);
		repository.save(order);
		int orderNo = order.getOrderNo();
		
		return orderNo;
	}

}
