package com.jhb0430.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.ex.mybatis.domain.Review;
import com.jhb0430.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {

	// 서비스에서 만들었으면 다시 여기로 오자...
//	여기서도 써줄 멤버 변수 생성
	@Autowired
	private ReviewService reviewService;
	
	
	// 목적 : id가 5인 리뷰 정보를 json으로 response에 담는다
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) { //이제  "/mybatis/review?id=##" 으로 전달받게됨
//		public Review review() {
		
		
		// id가 5인 리뷰 정보 얻어오기.=>  테이블 정보 가져오는건 서비스가 해야할 기능임
		// 위에서 멤버 변수 생성했어? 그럼 가져다 쓰자
//		Review review = reviewService.getReview(id);
		
		// 클라이언트가 원하는 id에 대응하는 review를 보여주려면...? 
//		Request로부터 전달되는 데이터
//		원래라면 int id = Integer.parseInt(request.getParameter("id")); 이렇게 써서 활용함
//		그치만 그 과정이 너무 번거로우니까 스프링에 사용법을 넣어놩ㅆ음
		// 메소드 파라미터처럼public Review review(int id) {  <- 이렇게 추가해주면 됨 
		//	근데 또 그냥 하면 안되고 @RequestParam() 을 써줘야함
		
		Review review = reviewService.getReview(id);
		
		
		return review;
	}
	
	
}
