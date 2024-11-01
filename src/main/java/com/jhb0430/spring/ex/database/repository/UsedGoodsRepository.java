package com.jhb0430.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jhb0430.spring.ex.database.domain.UsedGoods;

// 데이터베이스 관련 처리
// Mybatis FrameWork
@Mapper
//	src/main/resources/mappers/*Mapper.xml (어쩌구저쩌구 다 적어도 마지막은 Mapper.xml로 끝나야한다  )
public class UsedGoodsRepository {

	// used_goods 테이블 모든 행 조회
	public List<UsedGoods> selectUsedGoodsList();
	
}
