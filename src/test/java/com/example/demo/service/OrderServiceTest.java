package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.order.OrderDTO;
import com.example.demo.order.OrderService;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	OrderService service;
	
	@Test
	void 상태조회() {
		LocalDate date = LocalDate.of(2025, 05, 26);
		List<OrderDTO> list = service.getOrderByDate("user1", date, date);
		System.out.println(list);
	}
}
