package com.jhb0430.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.ex.mybatis.domain.Review;
import com.jhb0430.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {

	
	// 멤버 변수로 만들어줄 객체 생성
	@Autowired	// 이제 밑에서 쓰자~ 
	private ReviewRepository reviewRepository;
	
	
	// 왜만들었어? id가 5인 리뷰 정보 얻어오려고
	/*public Review getReview() {
		//	new_review의 테이블의 id가 5인 행 조회
		// 근데 쿼리 수행 기능은 서비스 기능이 아님... 
//		Repository가 해야함
		
//											조회대상인 아이디를 인자로 전달해야 값을 리턴해줌
//												괄호에 뭘 조회할것인지 적어줘야함
//		Review review = reviewRepository.selectReview();
		Review review = reviewRepository.selectReview(3);
//											근데 이러면 또 하나하나 바꿔줘야하는건 똑같잖어..review.
		return review;
*/		
		
//		↓ 전달 받은 id와 대응되는 리뷰 정보 얻어오기 
		public Review getReview(int id) {
			// new_review 테이블의 id가 전달받은 값과 일치하는 행 조회
			Review review = reviewRepository.selectReview(id);
	
			return review;
		}
	
	
	// 근데 다른 id 조회하고 싶어지면 어캄???
	// -> xml 파일 가보십시오 
	
}
