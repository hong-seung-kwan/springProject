package com.example.demo.orderProduct;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.order.OrderDTO;
import com.example.demo.order.OrderService;

@Controller
public class OrderProductController {

	
	@Autowired
	OrderProductService service;
	@Autowired
	OrderService orderService; 
	
	@GetMapping("/orderInfo")
	public String orderInfo(Model model, Principal principal) {
		
		String userId = principal.getName();
		List<OrderDTO> orderList = orderService.getOrderByUserId(userId);
		
		model.addAttribute("orders",orderList);
		
		
		return "/orderInfo";
	}
	
	
	
}
