package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.orderProduct.OrderProductDTO;
import com.example.demo.orderProduct.OrderProductService;

@SpringBootTest
public class OrderProductServiceTest {
	@Autowired
	OrderProductService service;
	@Test
	void 날짜조회() {
		LocalDate startDate = LocalDate.parse("2025-05-28");
		LocalDate endDate = LocalDate.parse("2025-05-28");
		
		List<OrderProductDTO> result = service.getOrderProductByDate(startDate, endDate);
		
		System.out.println(result);
	}
	
	
}
