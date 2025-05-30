package com.example.demo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/productRegister")
	public void register() {

	}

	@PostMapping("/productRegister")
	public String registerPost(ProductDTO dto) {
		service.register(dto);
		
		return "redirect:/home";
	}

	@GetMapping("/productInfo")
	public void productInfo(Model model,@RequestParam(name = "no") int productNo) {
		ProductDTO product = service.read(productNo);

		model.addAttribute("product", product);
	}
	
	@GetMapping("/productModify")
	public void modify(Model model,@RequestParam(name = "no") int productNo) {
		ProductDTO product = service.read(productNo);

		model.addAttribute("product", product);
	}
	

	@PostMapping("/productModify")
	public String modifyPost(@RequestParam("action") String action,ProductDTO dto, @RequestParam("originFile") String originFile, @RequestParam("uploadFile") MultipartFile uploadFile) {
						
		if(uploadFile.isEmpty()) {
			dto.setImageUrl(originFile);
		}

		
		if ("modify".equals(action)) {
			service.modify(dto);
		} else if ("remove".equals(action)) {
			service.remove(dto.getProductNo());
		}
		
		return "redirect:/home";
	}
		
}
