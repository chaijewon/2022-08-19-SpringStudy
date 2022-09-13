package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodDAO dao;
	
	@Override
	public List<CategoryVO> categoryListData(Map map) {
		// TODO Auto-generated method stub
		return dao.categoryListData(map);
	}

	@Override
	public List<FoodVO> foodListData(int cno) {
		// TODO Auto-generated method stub
		return dao.foodListData(cno);
	}

	@Override
	public CategoryVO categoryInfoData(int cno) {
		// TODO Auto-generated method stub
		return dao.categoryInfoData(cno);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

	@Override
	public List<String> foodTop5() {
		// TODO Auto-generated method stub
		return dao.foodTop5();
	}
   
}
