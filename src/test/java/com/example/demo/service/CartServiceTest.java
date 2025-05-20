package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.CartService;

@SpringBootTest
public class CartServiceTest {

	@Autowired
	CartService service;
	
	@Test
	void 전체삭제() {
		service.removeAll();
	}
}
