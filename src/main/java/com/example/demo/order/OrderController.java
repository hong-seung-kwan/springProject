package com.example.demo.order;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.CartDTO;
import com.example.demo.cart.CartRepository;
import com.example.demo.cart.CartService;
import com.example.demo.orderProduct.OrderProductDTO;
import com.example.demo.orderProduct.OrderProductService;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	@Autowired
	CartService cartService;

	
	@GetMapping("/order")
	public String order(Model model, Principal principal) {
		
		String userId = principal.getName();
		List<CartDTO> list = cartService.getListByUserId(userId);
		
		int totalPrice = list.stream()
				.mapToInt(dto -> dto.getPrice() * dto.getProductQuantity())
				.sum();
		
		int delivery = 0;
		if(totalPrice < 30000) {
			delivery = 3000;
		} else {
			delivery = 0;
		}
		
		model.addAttribute("delivery",delivery);
		model.addAttribute("list",list);
		model.addAttribute("totalPrice",totalPrice);
				
		return "/order";
	}
	
	@PostMapping({"/order","/orderProduct"})
	public String orderItem(OrderDTO dto, OrderProductDTO orderProductDTO, Principal principal,@RequestParam("totalPrice") int totalPrice, @RequestParam("delivery") int delivery) {
		String id = principal.getName();
		int orderprice = totalPrice + delivery;
		dto.setUser(id);
		dto.setOrderPrice(orderprice);
		service.register(dto, orderProductDTO);
		
//		cartService.removeAll();

		return "redirect:/home";
	}
	
	
}
