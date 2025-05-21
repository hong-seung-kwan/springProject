package com.example.demo.orderProduct;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	@Query(value = "SELECT * FROM ORDER_PRODUCT WHERE USER_USER_ID = :userId", nativeQuery = true)
	List<OrderProduct> findByUserId(@Param("userId") String userId);
}
