package com.example.demo.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.cart.Cart;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	
	@Query(value = "SELECT * FROM CART WHERE USER_ID = :userId", nativeQuery = true)
	List<Cart> findByUserId(@Param("userId") String userId);
	
	List<Order> findByUserUserId(String userId);
}
