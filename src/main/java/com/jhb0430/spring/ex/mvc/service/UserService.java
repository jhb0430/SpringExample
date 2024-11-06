package com.jhb0430.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.ex.mvc.domain.User;
import com.jhb0430.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
				return count;
	}
	
	
	public User getLastUser() {
		// 셀렉트 쿼리 수행해야하네? -> 레파지토리 고고고 
		
		// 한 행만 조회할 것 이기 때문에 List아닌 엔티티 단독.
		
		User user = userRepository.selectLastUser();
		
		return user;
	}
}
