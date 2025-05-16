package com.example.demo.cart;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
	
	@Autowired
	CartService service;
	
	@GetMapping("/cart")
	public String cart(Model model, Principal principal) {
		
		String userId = principal.getName();
		List<CartDTO> list = service.getListByUserId(userId);
		
		model.addAttribute("list",list);
		
		return "/cart";
	}
		
	@PostMapping("/cart/add")
	public String addToCart(@RequestParam("productNo") int productNo,
	                        @RequestParam("productQuantity") int productQuantity,
	                        Principal principal) {
	    String userId = principal.getName();

	    CartDTO cartDTO = CartDTO.builder()
	            .user(userId)
	            .product(productNo)
	            .productQuantity(productQuantity)
	            .build();

	    service.register(cartDTO);

	    return "redirect:/home";
	}
	
	@PostMapping("/cart")
	public String removeCart(@RequestParam("no") int cartNo) {
		
		service.remove(cartNo);
		return "/cart";
	}
}
