package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.SeoulVO;
/*
 *   1. @Controller 
 *   2. @RestController
 *   -----------------------------------
 *   3. @Repository
 *   4. @Service ===> BI (DAO를 통합)
 *   -----------------------------------
 *   5. @Component
 *   ------------------------------
 *   6. @ControllerAdvice : 통합 예외처리 
 *   ------------------------------------------
 *   DI 
 *   @Autowired
 *   ------------------------------------------
 *   @Inject
 *   
 */
import com.sist.dao.*;
@Service
public class SeoulServiceImpl implements SeoulService{

	@Autowired
	private SeoulDAO dao;
	
	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulListData(map);
	}

	@Override
	public SeoulVO seoulDetailData(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulDetailData(map);
	}

	@Override
	public int seoulTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulTotalPage(map);
	}

	@Override
	public List<SeoulVO> seoulTop5(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulTop5(map);
	}

}
