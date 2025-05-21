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
	
	
	
}
