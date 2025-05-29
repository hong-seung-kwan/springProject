package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService service;
	@Test
	void 상품조회() {
		ProductDTO result = service.read(1);
		System.out.println(result);
	}
	@Test
	void 상품수정() {
		ProductDTO dto = service.read(5);
		dto.setPrice(25000);
		service.modify(dto);
	}
	@Test
	void 검색() {
		Page<ProductDTO> result = service.search("test", 0);
		System.out.println(result);
	}
}
