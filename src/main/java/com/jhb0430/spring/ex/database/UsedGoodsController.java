package com.jhb0430.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.ex.database.domain.UsedGoods;
import com.jhb0430.spring.ex.database.service.UsedGoodsService;

// request, response 처리 담당
@Controller
public class UsedGoodsController {

//	usedGoodsService 객체를 생성해야하는데 -> 멤버변수 형태로 변수 먼저 선언하고 그 위에 Autowired 어노테이션 붙여줌
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	// used_goods 테이블의 모든 정보를 json으로 response에 담는다 
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// 중고 물품 게시글 정보 얻어 오기
		// 비즈니스 레이어를 수행할 클래스가 따로 만들어져야함 
		// 필요한 기능은 서비스를 통해 이루어져야한다 
		
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
	}

}
