package com.example.demo.product;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ProductService {
	
	int register(ProductDTO dto);
	
	ProductDTO read(int productNo);
		
	Page<ProductDTO> getList(int pageNumber);
		
	void modify(ProductDTO dto);
	
	void remove(int productNo);
	
	Page<ProductDTO> search(String keyword, int pageNumber);
		
	default ProductDTO entityToDto(Product product) {
		
		ProductDTO dto = ProductDTO.builder()
										.productNo(product.getProductNo())
										.name(product.getName())
										.price(product.getPrice())
										.content(product.getContent())
										.imageUrl(product.getImageUrl())
										.category(product.getCategory())
										.build();
		
		return dto;
	}
	default Product dtoToEntity(ProductDTO dto) {
		
		Product product = Product.builder()
										.productNo(dto.getProductNo())
										.name(dto.getName())
										.price(dto.getPrice())
										.content(dto.getContent())
										.category(dto.getCategory())
										.build();
		
		return product;
	}
	
}
