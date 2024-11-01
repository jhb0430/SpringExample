package com.jhb0430.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.ex.database.domain.UsedGoods;
import com.jhb0430.spring.ex.database.repository.UsedGoodsRepository;

// 로직 (business) 담당
// 데이터를 수정/ 가공
// 그 외 복잡한 기능 수행
@Service
public class UsedGoodsService {

	// 싱글턴 
	@Autowired
	private UsedGoodsRepository UsedGoodsRepository;
	
	// 중고물품 게시글 모두 얻어 오기
	public List<UsedGoods> getUsedGoodsList() {
		
	
	// 데이터 베이스 조회 `used_goods` 테이블 조회 결과 얻어 오기
	// 테이블을 조회하는 기능은 Service의 역할이 아님... -> 그래서 또 만들어줘야함
	
	List<UsedGoods> usedGoodsList = UsedGoodsRepository.selectUsedGoodsList();
	
		return usedGoodsList;
	}
	
}
