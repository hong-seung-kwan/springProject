package com.example.demo.orderProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	List<OrderProduct> findByOrderOrderNo(int orderNo);
	
	void deleteByOrderOrderNo(int orderNo);

	
}
