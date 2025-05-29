package com.example.demo.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	 @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT.NAME LIKE %:keyword%" , nativeQuery = true)
	 Page<Product> findByName(@Param("keyword") String keyword, PageRequest pageRequest);
}
