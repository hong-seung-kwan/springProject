package com.example.demo.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.product.Product;
import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService service;

	@GetMapping("/home")
	public void home(Model model) {

		List<ProductDTO> product = service.getList();
		model.addAttribute("product", product);

	}
	
	@GetMapping("/bottom")
	public String categoryBottom(Model model) {
		
		List<ProductDTO> list = service.getList();
		List<ProductDTO> bottomList = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("bottom")) {
				bottomList.add(productDTO);
				
			}			
		}
		model.addAttribute("bottomlist", bottomList);
		return "/bottom";		
	}
	@GetMapping("/top")
	public String categoryTop(Model model) {
		
		List<ProductDTO> list = service.getList();
		List<ProductDTO> topList = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("top")) {
				topList.add(productDTO);
				
			}			
		}
		model.addAttribute("topList", topList);
		return "/top";		
	}
	@GetMapping("/accessories")
	public String categoryAccessories(Model model) {
		
		List<ProductDTO> list = service.getList();
		List<ProductDTO> accessoriesList = new ArrayList<>();
		
		for(ProductDTO productDTO : list) {
			if(productDTO.getCategory().equals("accessories")) {
				accessoriesList.add(productDTO);
				
			}			
		}
		model.addAttribute("bottomList", accessoriesList);
		return "/accessories";		
	}

}
