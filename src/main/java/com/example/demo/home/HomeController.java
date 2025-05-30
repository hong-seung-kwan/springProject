package com.example.demo.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService service;
	
	@GetMapping("/home")
	public void home(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {
		
		
			Page<ProductDTO> product = service.getList(page);		
			model.addAttribute("product",product);
		
	}		
	@GetMapping("/bottom")
	public String categoryBottom(Model model,@RequestParam(defaultValue = "0", name = "page") int page) {
		
		Page<ProductDTO> list = service.getList(page);
		List<ProductDTO> bottomProduct = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("bottom")) {
				bottomProduct.add(productDTO);				
			}			
		}
		Pageable pageable = PageRequest.of(page, list.getSize());
	    Page<ProductDTO> bottomList = new PageImpl<>(bottomProduct, pageable, bottomProduct.size());
	    
		model.addAttribute("bottomlist", bottomList);
		return "/bottom";		
	}
	@GetMapping("/top")
	public String categoryTop(Model model,@RequestParam(defaultValue = "0", name = "page") int page) {
		
		Page<ProductDTO> list = service.getList(page);
		List<ProductDTO> topProduct = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("top")) {
				topProduct.add(productDTO);
				
			}			
		}
		
		Pageable pageable = PageRequest.of(page, list.getSize());
	    Page<ProductDTO> topList = new PageImpl<>(topProduct, pageable, topProduct.size());
		
		model.addAttribute("toplist", topList);
		return "/top";		
	}
	@GetMapping("/accessories")
	public String categoryAccessories(Model model,@RequestParam(defaultValue = "0", name = "page") int page) {
		
		Page<ProductDTO> list = service.getList(page);
		List<ProductDTO> accessoriesProduct = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("accessories")) {
				accessoriesProduct.add(productDTO);
				
			}			
		}
		
		Pageable pageable = PageRequest.of(page, list.getSize());
	    Page<ProductDTO> accessoriesList = new PageImpl<>(accessoriesProduct, pageable, accessoriesProduct.size());
		
		model.addAttribute("accessoriesList", accessoriesList);
		return "/accessories";		
	}

}

/* 
 * 기획의도 및 주제
	db 구조
	사용기술
	기능설명
	비즈니스 로직
 * */
