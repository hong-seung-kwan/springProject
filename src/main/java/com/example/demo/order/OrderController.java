package com.example.demo.order;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.cart.CartDTO;
import com.example.demo.cart.CartRepository;
import com.example.demo.cart.CartService;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	@Autowired
	CartService cartService;
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/order")
	public String order(Model model, Principal principal) {
		
		String userId = principal.getName();
		List<CartDTO> list = cartService.getListByUserId(userId);
		
		int totalPrice = list.stream()
				.mapToInt(dto -> dto.getPrice() * dto.getProductQuantity())
				.sum();
	
		model.addAttribute("list",list);
		model.addAttribute("totalPrice",totalPrice);
				
		return "/order";
	}
	@PostMapping("/order")
	public String orderItem(OrderDTO dto, Principal principal) {
		String id = principal.getName();
		dto.setUser(id);	
		service.register(dto);
		cartService.removeAll();
		
		return "/order";
	}
	
	
}
