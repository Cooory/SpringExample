package com.cooory.spring.ex.database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// request, response를 담당한다.
@Controller
public class UsedGoodsController {

	// used goods 데이터 조회 결과 json으로 response에 채운다.
	@RequestMapping("/db/usedgoods/list")
	public usedGoodsList() {
		
		
	}
}
