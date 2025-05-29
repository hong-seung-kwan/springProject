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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.OrderDTO;
import com.example.demo.order.OrderService;

@Controller
public class OrderProductController {

	@Autowired
	OrderProductService service;
	@Autowired
	OrderService orderService;

	@GetMapping("/orderInfo")
	public String orderInfo(Model model, Principal principal, OrderProductDTO orderProductDTO) {

		String userId = principal.getName();
		List<OrderDTO> orders = orderService.getOrderByUserId(userId);

		model.addAttribute("orders", orders);

		return "/orderInfo";

	}

}