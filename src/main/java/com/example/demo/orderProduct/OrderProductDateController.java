package com.example.demo.orderProduct;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OrderProductDateController {

	@Autowired
	OrderProductService service;
	
	@GetMapping("/orderInfo/date")
	public List<OrderProductDTO> orderInfoByDate(@RequestParam(value="startDate",required = false) LocalDate startDate,@RequestParam(value="endDate",required = false) LocalDate endDate,Principal principal) {
		
		String userId = principal.getName();
		List<OrderProductDTO> dto = service.getOrderProductByDate(userId,startDate, endDate);
				
		return dto;	
	}
	
	
}
