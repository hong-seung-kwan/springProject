package com.example.demo.orderProduct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.order.OrderRepository;


@Service
public class OrderProductServiceImpl implements OrderProductService {

	
	@Autowired
	OrderProductRepository repository;
	@Autowired
	OrderRepository orderRepository;
	
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
	
	@Transactional
	@Override
	public List<OrderProductDTO> getOrderProductByDate(String userId,LocalDate startDate, LocalDate endDate) {
				
		List<OrderProduct> list = repository.findByOrderOrderDate(userId,startDate, endDate);
		
		List<OrderProductDTO> list2 = new ArrayList<>();
		
		for(OrderProduct orderProduct :list) {
			OrderProductDTO dto = entityToDto(orderProduct);
			list2.add(dto);
		}		
		return list2;
	}


	
}
