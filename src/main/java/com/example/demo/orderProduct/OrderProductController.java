package com.example.demo.orderProduct;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.order.OrderDTO;
import com.example.demo.order.OrderService;

@Controller
public class OrderProductController {

	
	@Autowired
	OrderProductService service;
	@Autowired
	OrderService orderService; 
	
	@GetMapping("/orderInfo")
	public String orderInfo(Model model, Principal principal,OrderProductDTO orderProductDTO,
							@RequestParam(value = "page",defaultValue = "1") int page,
							@RequestParam(value="startDate",required = false) LocalDate startDate,
							@RequestParam(value="endDate",required = false) LocalDate endDate) {
		
		String userId = principal.getName();
		Page<OrderDTO> orders = orderService.getOrderByUserId(userId, page);
		
		model.addAttribute("orders",orders);
		
		if(startDate != null && endDate != null) {
			List<OrderProductDTO> dto = service.getOrderProductByDate(startDate, endDate);
			model.addAttribute("dto",dto);
		}
		System.out.println("startDate: " + startDate);
		System.out.println("endDate: " + endDate);
		return "/orderInfo";
				
	}

		
}
