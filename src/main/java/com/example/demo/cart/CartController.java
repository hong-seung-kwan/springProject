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
		
		
		int totalPrice = list.stream()
	            .mapToInt(dto -> dto.getPrice() * dto.getProductQuantity())
	            .sum();
		int delivery = 0;
				
		if(0 < totalPrice && totalPrice < 30000) {
			delivery = 3000;
		} else {
			delivery = 0;
		}
		
		
		model.addAttribute("delivery",delivery);
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("list",list);
		
		return "/cart";
	}
		
	@PostMapping("/cart/add")
	public String addToCart(@RequestParam("productNo") int productNo,
	                        @RequestParam("productQuantity") int productQuantity,
	                        @RequestParam("size") String size,
	                        Principal principal) {
	    String userId = principal.getName();

	    CartDTO cartDTO = CartDTO.builder()
	            .user(userId)
	            .product(productNo)
	            .productQuantity(productQuantity)
	            .size(size)
	            .build();

	    service.register(cartDTO);

	    return "redirect:/home";
	}
	
	@PostMapping("/cart")
	public String removeCart(@RequestParam("no") int cartNo) {
		
		service.remove(cartNo);
		return "redirect:/cart";
	}
	
	@PostMapping("/cart/increase")
	public String increase(@RequestParam("no") int cartNo) {
		service.increaseQuantity(cartNo);
		return "redirect:/cart";
	}
	@PostMapping("/cart/decrease")
	public String decrease(@RequestParam("no") int cartNo) {
		service.decreaseQuantity(cartNo);
		return "redirect:/cart";
	}
}
