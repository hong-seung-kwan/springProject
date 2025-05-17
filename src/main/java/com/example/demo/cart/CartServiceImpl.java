package com.example.demo.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<CartDTO> getListByUserId(String userId) {
		
		List<Cart> list = repository.findByUserId(userId);
		
		List<CartDTO> dtolist = new ArrayList<>();
		
		for(Cart cart : list) {
			CartDTO dto = entityToDto(cart);
			dtolist.add(dto);
		}
		
		return dtolist;
	}

	@Override
	public int register(CartDTO dto) {
				
		Optional<Cart> cartItem = repository.UserUserIdAndProductProductNo(dto.getUser(), dto.getProduct());

		
		if(cartItem.isPresent()) {
			Cart cart = cartItem.get();
			cart.setProductQuantity(cart.getProductQuantity() + dto.getProductQuantity());
			repository.save(cart);
			return cart.getCartNo();
		} else {
			Cart cart2 = dtoToEntity(dto);
			repository.save(cart2);
			return cart2.getCartNo();
		}
	}

	@Override
	public boolean remove(int cartNo) {
		
		Optional<Cart> optional = repository.findById(cartNo);
		if(optional.isPresent()) {
			repository.deleteById(cartNo);
			return true;
		}
		
		return false;
	}
	
	public CartDTO entityToDto(Cart cart) {
			
		int productNo = cart.getProduct().getProductNo();
			
		String userId = cart.getUser().getUserId();
		
		Product product = cart.getProduct();
			
		CartDTO dto = CartDTO.builder()
										.cartNo(cart.getCartNo())
										.user(userId)
										.product(productNo)
										.productQuantity(cart.getProductQuantity())
										.name(product.getName())
										.price(product.getPrice())
										.imageUrl(product.getImageUrl())
										.build();
	
			return dto;
		}
	public Cart dtoToEntity(CartDTO dto) {
		
				
		Product product = productRepository.findById(dto.getProduct()).orElseThrow();
		Member id = memberRepository.findById(dto.getUser()).orElseThrow();
								
		Cart cart = Cart.builder()
								.cartNo(0)
								.user(id)
								.product(product)
								.productQuantity(dto.getProductQuantity())
								.build();
			return cart;
		}

	@Override
	public void increaseQuantity(int cartNo) {
		
		Cart cart = repository.findById(cartNo).orElseThrow();
		
		cart.setProductQuantity(cart.getProductQuantity() + 1);
		repository.save(cart);
		
	}

	@Override
	public void decreaseQuantity(int cartNo) {
		Cart cart = repository.findById(cartNo).orElseThrow();
		
		if(cart.getProductQuantity() > 1) {
			cart.setProductQuantity(cart.getProductQuantity() -1);
			repository.save(cart);
		} else {
			repository.deleteById(cartNo);
		}		
	}
}
