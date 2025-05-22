package com.example.demo.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.member.Member;
import com.example.demo.orderProduct.OrderProduct;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ordertbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(value = { AuditingEntityListener.class })
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderNo;
	
	@ManyToOne
	Member user;
		
	@CreatedDate
	LocalDateTime orderDate;
	
	@Column
	int orderPrice;
	
	@Column(nullable = false)
	String zipCode;
	@Column(nullable = false)
	String streetAdr;
	@Column(nullable = false)
	String address;
	@Column(nullable = false)
	String orderName;
	@Column(nullable = false)
	String orderReq;	
	@Column
	String payment;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	List<OrderProduct> orderProduct = new ArrayList<>();

}
