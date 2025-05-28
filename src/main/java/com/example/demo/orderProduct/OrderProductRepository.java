package com.example.demo.orderProduct;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	List<OrderProduct> findByOrderOrderNo(int orderNo);
	
	void deleteByOrderOrderNo(int orderNo);
	
	@Query(value = "SELECT ORDER_PRODUCT.* FROM ORDER_PRODUCT JOIN ORDERTBL ON ORDER_PRODUCT.ORDER_NO = ORDERTBL.ORDER_NO	WHERE DATE(ORDERTBL.order_date) BETWEEN :startDate AND :endDate",nativeQuery = true)
	List<OrderProduct> findByOrderOrderDate(@Param("startDate")LocalDate startDate, @Param("endDate") LocalDate endDate);
		
}
