package com.jhb0430.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jhb0430.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

		// id가 5인 행 조회
//		public Review selectReview();
		// 조회할거니까 select
		// 전체가 아니라 한개만 조회할거니까 리스트가 아니라 클래스만 제네릭으로 쓴다 
		
		// xml까지 만들었으면 서비스로 돌아가자~ 
		
		
		// 전달된 id와 일치하는 리뷰 행 조회 
//									@Param("전달된 값을 어떤 형태로 적어줄것인지. 주로 변수값과 똑같이 쓴다")
		public Review selectReview(@Param("id")int id); // 뒤의 int id는 자바문법으로써의 변수.
//						수행하는 과정에서 전달된 값이 xml에서 쓰여야한다ㄴ
		

		
		// 전달받은 리뷰 정보를 기반으로 insert 한다
		// 행의 갯수가 리턴되기때문에 리턴타입이 int다
		public int insertReview(
				@Param("storeId")int storId
				,@Param("menu") String menu
				, @Param("userName")String userName
				,@Param("point")double point
				, @Param("review")String review
				
				);
		
		// 전달 받은 Review 객체로 insert 한다
		public int insertReviewByObject(Review review);
			
	}

	
	
