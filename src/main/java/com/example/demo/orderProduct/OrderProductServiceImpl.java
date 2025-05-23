package com.example.demo.orderProduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderProductServiceImpl implements OrderProductService {

	
	@Autowired
	OrderProductRepository repository;
	
	@Override
	public List<OrderProductDTO> getOrderProductByOrderNo(int orderNo) {
		
		List<OrderProduct> list = repository.findByOrderOrderNo(orderNo);
		List<OrderProductDTO> list2 = new ArrayList<>();
		
		for(OrderProduct orderProduct :list) {
			OrderProductDTO dto = entityToDto(orderProduct);
			list2.add(dto);
		}
		
		return list2;
	}

}
