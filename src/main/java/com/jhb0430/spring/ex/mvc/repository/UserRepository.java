package com.jhb0430.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
			// xml에서 값을 활용할 수 있도록 파라미터를 준다
			@Param("name")String name
			,@Param("birthday") String birthday
			,@Param("email") String email
			,@Param("introduce") String introduce
			);
	
	
	public int insertUserByObject(User user);
	// 메소드 이름 , 정보 , 파라미터 
	
	public User selectLastUser();
	
	
	public int countByEmail(@Param("email") String email);
		// 조회 결과가 정수형태니까 int 가 리턴타입이 된다 . 
}
