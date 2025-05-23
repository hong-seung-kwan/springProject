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
		model.addAttribute("accessoriesList", accessoriesList);
		return "/accessories";		
	}

}



/*
 * 주문이력 삭제 구현
 * 회원가입 아이디중복확인 창 띄우기
 * 상품등록,상품수정(관리자만 보이게 수정), 주문이력 url 연결 각 페이지마다 헤더 통일?
 * 주문이력에서 주문 상태 및 기간 별 검색
 * 주문이력, 장바구니 상품 없을경우 나타나는 뷰 처리
 * 장바구니 버튼 수량 표시
 * 회원 권한 처리
 * 주문이력, 장바구니 로그인 안했으면 로그인 후 이용가능 알림창 띄우고 로그인 페이지로 넘기기
 * 재고관리 구현
 * 페이징 처리,,,
 * */
