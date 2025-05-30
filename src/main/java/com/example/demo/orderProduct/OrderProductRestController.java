package com.example.demo.orderProduct;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.OrderDTO;
import com.example.demo.order.OrderService;
@RestController
public class OrderProductRestController {

	@Autowired
	OrderProductService service;
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orderInfo/date")
	public List<OrderDTO> orderInfoByDate(@RequestParam(value="startDate",required = false) LocalDate startDate,@RequestParam(value="endDate",required = false) LocalDate endDate,Principal principal) {
		
		String userId = principal.getName();
		List<OrderDTO> dto = orderService.getOrderByDate(userId,startDate, endDate);
		
		
		return dto;	
	}
	
	
	@GetMapping("orderInfo/status")
	public List<OrderDTO> orderInfoByStatus(@RequestParam(name = "status") String status, Principal principal){
		
		String userId= principal.getName();

		List<OrderDTO> dto = orderService.getOrderByStatus(userId, status);
			
		return dto;
	}
	
}
