package com.cooory.spring.ex.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cooory.spring.ex.database.domain.UsedGoods;

// Mybatis 프레임워크
// 데이터베이스 사용 담당
// 쿼리 수행
@Repository
public interface UsedGoodsRepository {
	
	// used_goods 테이블 모든 행 조회
	public List<UsedGoods> selectUsedGoodsList();
		
	
}
