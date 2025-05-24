package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO dto, Model model ) {	
		
		boolean duplication = service.userId(dto.getUserId());
		if (duplication) {
			model.addAttribute("errorMsg", "아이디가 중복되었습니다.");
			return "/register";
		}
		
		service.register(dto);
		return "/login";
	}
	
	@GetMapping("/login")
	public void login() {		
	}
}
