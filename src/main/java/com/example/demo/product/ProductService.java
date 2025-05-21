package com.example.demo.product;

import java.util.List;

public interface ProductService {
	
	int register(ProductDTO dto);
	
	ProductDTO read(int productNo);
	
	List<ProductDTO> getList();
	
	void modify(ProductDTO dto);
	
	void remove(int productNo);
		
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
