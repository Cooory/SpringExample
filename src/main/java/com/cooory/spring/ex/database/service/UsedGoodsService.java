package com.cooory.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooory.spring.ex.database.domain.UsedGoods;
import com.cooory.spring.ex.database.repository.UsedGoodsRepository;

// 로직 (business) 담당
@Service
public class UsedGoodsService {
	
	@Autowired // 객체 관리를 스프링이 대신 해줌
	private UsedGoodsRepository usedGoodsRepository;
	
	// used_goods 모든 데이터 조회
	public List<UsedGoods> getUsedGoodsList() {
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		return usedGoodsList;
		
		
	}
}
