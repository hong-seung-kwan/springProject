package com.example.demo.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.Member;
import com.example.demo.order.Order;
import com.example.demo.order.OrderRepository;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository repository;
	@Test
	void 리파지토리확인() {
		System.out.println(repository);
	}
}
