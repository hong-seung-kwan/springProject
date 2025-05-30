package com.example.demo.order;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderStatusController {

	@Autowired
	OrderService service;
	
//	@GetMapping("orderInfo/status")
//	public List<OrderDTO> orderInfoByStatus(@RequestParam(name = "status") String status, Principal principal){
//		
//		String userId= principal.getName();
//		List<OrderDTO> dto = service.getByStatus(userId, status);
//			
//		return dto;
//	}
	
}
