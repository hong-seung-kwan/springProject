package com.example.demo.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductService;

@RestController
public class HomeRestController {

	@Autowired
	ProductService service; 
	
	@GetMapping("/home/search")
    public Page<ProductDTO> search(@RequestParam(name = "keyword") String keyword,
                                   @RequestParam(defaultValue = "0", name = "page") int page, Model model) {
		Page<ProductDTO> product = service.search(keyword, page);
		
		if (keyword != null && !keyword.trim().isEmpty()) {
	        
	        product = service.search(keyword, page);
	    } else {
	    	product = service.getList(page);
	    }
        return product;
    }
}
