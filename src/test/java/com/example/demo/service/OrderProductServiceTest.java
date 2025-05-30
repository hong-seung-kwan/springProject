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
	
//	@Test
//	void 상태별조회() {
//		
//		List<OrderProductDTO> list = service.getByStatus("user1", "배송완료");
//		System.out.println(list);
//	}
//	
}