package com.example.demo.cart;

import java.util.List;

public interface CartService {
			
	List<CartDTO> getListByUserId(String userId);

	int register(CartDTO cartDTO);

	boolean remove(int cartNo);
	
	void increaseQuantity(int cartNo);
	
	void decreaseQuantity(int cartNo);
	
}
