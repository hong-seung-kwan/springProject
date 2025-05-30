package com.example.demo.orderProduct;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.Order;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	List<OrderProduct> findByOrderOrderNo(int orderNo);
	
	void deleteByOrderOrderNo(int orderNo);
	
	List<OrderProduct> deleteByProductProductNo(int productNo);
	
	@Query(value = "SELECT ORDER_PRODUCT.* FROM ORDER_PRODUCT JOIN ORDERTBL ON ORDER_PRODUCT.ORDER_NO = ORDERTBL.ORDER_NO WHERE ORDERTBL.USER_USER_ID = :userId AND DATE(ORDERTBL.order_date) BETWEEN :startDate AND :endDate",nativeQuery = true)
	List<OrderProduct> findByOrderOrderDate(@Param("userId") String userId,@Param("startDate")LocalDate startDate, @Param("endDate") LocalDate endDate);
	
//	@Query(value = "SELECT ORDER_PRODUCT.* FROM ORDER_PRODUCT JOIN ORDERTBL ON ORDER_PRODUCT.ORDER_NO = ORDERTBL.ORDER_NO WHERE ORDERTBL.USER_USER_ID = :userId AND ORDERTBL.STATUS = :status", nativeQuery = true)
//	List<OrderProduct> findbyUserIdAndStatus(@Param("userId")String userId, @Param("status") String status);
		
}
