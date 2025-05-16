package com.example.demo.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	@Override
	public boolean register(MemberDTO dto) {
		
		String userId = dto.getUserId();
		
		Optional<Member> optional = repository.findById(userId);
		if(optional.isPresent()) {
			System.out.println("사용중인 아이디입니다. 다른 아이디를 입력해주세요");
			return false;
		} else {
			System.out.println("회원가입이 완료되었습니다");
			Member entity = dtoToEntity(dto);
			
			String password = entity.getUserPw();
			String enpw = passwordEncoder.encode(password);
			
			entity.setUserPw(enpw);
			
			repository.save(entity);
			return true;
		}	
	}



	@Override
	public MemberDTO read(String userId) {
		
		Optional<Member> optional = repository.findById(userId);
		if(optional.isPresent()) {
			Member member = optional.get();
			MemberDTO dto = entityToDto(member);
			return dto;
		}
		
		return null;
	}

	
	
	
}
