package com.example.demo.orderProduct;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String orderInfo(Model model, Principal principal,OrderProductDTO orderProductDTO) {
		
		String userId = principal.getName();
		List<OrderDTO> orderList = orderService.getOrderByUserId(userId);
		
		
		for (OrderDTO order : orderList) {
	        int orderId = order.getOrderNo();
	        List<OrderProductDTO> orderProductList = service.getOrderProductByOrderNo(orderId);
	        order.setOrderProductDTO(orderProductList);
	    }
		int orderNo = orderProductDTO.getOrderId();
		List<OrderProductDTO> orderProductList = service.getOrderProductByOrderNo(orderNo);
		
		model.addAttribute("orders",orderList);
		model.addAttribute("orderProductList",orderProductList);
		
		
		return "/orderInfo";
	}
	

		
}
