package com.example.demo.order;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.cart.Cart;
import com.example.demo.orderProduct.OrderProduct;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	
	@Query(value = "SELECT * FROM CART WHERE USER_ID = :userId", nativeQuery = true)
	List<Cart> findByUserId(@Param("userId") String userId);
	
	List<Order> findByUserUserId(String userId);
	
	@Query(value = "SELECT * FROM ORDERTBL WHERE ORDERTBL.USER_USER_ID =:userId AND DATE(ORDERTBL.ORDER_DATE) BETWEEN :startDate AND :endDate",nativeQuery = true)
	List<Order> findByOrderOrderDate(@Param("userId") String userId,@Param("startDate")LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	@Query(value= "SELECT * FROM ORDERTBL WHERE ORDERTBL.USER_USER_ID = :userId AND ORDERTBL.STATUS = :status", nativeQuery = true)
	List<Order> findByUserAndStatus(@Param("userId") String userId, @Param("status") String status);
}
