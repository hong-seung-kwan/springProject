package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.order.OrderRepository;
import com.example.demo.orderProduct.OrderProductRepository;
import com.example.demo.util.FileUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	@Autowired
	OrderProductRepository orderProductRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	FileUtil util;
	
	@Override
	public int register(ProductDTO dto) {
		
		Product product = dtoToEntity(dto);
		
		String filename = util.fileUpload(dto.getUploadFile());
		product.setImageUrl(filename);
		repository.save(product);
		int newNo = product.getProductNo();
		
		return newNo;
	}

	@Override
	public ProductDTO read(int productNo) {
		
		Optional<Product> optional = repository.findById(productNo);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			ProductDTO productDTO = entityToDto(product);
			return productDTO;
		} else {
			return null;
		}		
	}

	@Override
	public void modify(ProductDTO dto) {
		
		MultipartFile file = dto.getUploadFile();
		Optional<Product> optional = repository.findById(dto.getProductNo());
		
		if(optional.isPresent()) {
			Product product = optional.get();
			
			product.setName(dto.getName());
			product.setPrice(dto.getPrice());
			product.setContent(dto.getContent());

	        if (file != null && !file.isEmpty()) {
	            String filename = util.fileUpload(file);
	            product.setImageUrl(filename);
	        }
			
			
			repository.save(product);
		}
		
	}
	@Transactional
	@Override
	public void remove(int productNo) {
		
		Optional<Product> optional = repository.findById(productNo);
		if(optional.isPresent()) {			
			repository.deleteById(productNo);
		}
	}

	@Override
	public Page<ProductDTO> getList(int pageNumber) {
		
		int pageNum = (pageNumber == 0) ? 0 : pageNumber -1;
		
		Pageable pageable = PageRequest.of(pageNum, 8, Sort.by("productNo").descending());
		
		Page<Product> entityPage = repository.findAll(pageable);
		
		Page<ProductDTO> page = entityPage.map(entity -> entityToDto(entity));
		
		return page;
				
	}
	
	@Override
	public Page<ProductDTO> search(String keyword, int pageNumber) {
		
		PageRequest pageRequest = PageRequest.of(pageNumber, 8);
		
			Page<Product> product = repository.findByName(keyword, pageRequest);
			Page<ProductDTO> productDTO = product.map(entity -> entityToDto(entity));
			return productDTO;
	}
}
