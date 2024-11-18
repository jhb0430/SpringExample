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
	
	// user 객체를 받아오는 기능 
	
	public int addUserByObject(User user){
		int count = userRepository.insertUserByObject(user);
	
		return count;
	}
	
	
	
	
	public User getLastUser() {
		// 셀렉트 쿼리 수행해야하네? -> 레파지토리 고고고 
		
		// 한 행만 조회할 것 이기 때문에 List아닌 엔티티 단독.
		
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public boolean isDuplicateEmail(String email) {
		// 이메일이 중복됐다 안됐다 
		// 특정 행이 일치하면 카운트 하는 기능을 이용한다. 
		
		int count = userRepository.countByEmail(email);
//		return count; -- > 무조건 count 리턴을 하는 게 아님!! 생각해야됨... ↓
		// 이메일 전달받아서 맞다 아니다 판단해야하니까, 중복이 됐다 안됐다를 직접 판단해서
		// T/F 로 리턴해줘야한다
		if(count > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
