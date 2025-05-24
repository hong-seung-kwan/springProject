package com.example.demo.order;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

}
