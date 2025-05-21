package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.orderProduct.OrderProduct;
import com.example.demo.orderProduct.OrderProductRepository;

@SpringBootTest
public class OrderProductTest {

	@Autowired
	OrderProductRepository repository;
	
	@Test
	void 확인() {
		System.out.println(repository);
	}
	@Test
	void 데이터() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		List<OrderProduct> list = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(0, localDateTime,"모자", 2, 15000, 30000, null);
		OrderProduct orderProduct2 = new OrderProduct(0, localDateTime,"모자", 2, 15000, 30000, null);
		OrderProduct orderProduct3 = new OrderProduct(0, localDateTime,"모자", 2, 15000, 30000, null);
		OrderProduct orderProduct4 = new OrderProduct(0, localDateTime,"모자", 2, 15000, 30000, null);
		list.add(orderProduct);
		list.add(orderProduct2);
		list.add(orderProduct3);
		list.add(orderProduct4);
		repository.saveAll(list);
	}
	@Test
	void 데이터조회() {
		
		List<OrderProduct> list = repository.findByUserId("user1");
		for(OrderProduct product : list) {
			System.out.println(product);
		}
				
	}
}
