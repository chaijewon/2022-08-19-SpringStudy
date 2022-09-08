package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
// 의존성(결합성)이 약한 프로그램 => 결합성(다른 클래스에 영향) ==> POJO(독립적인 클래스)
// Mapper => DAO => Service => ServiceImpl
@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeDAO dao;
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeListData(map);
	}
	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return dao.recipeTotalPage();
	}
	@Override
	public List<RecipeVO> recipeFindData(String ss) {
		// TODO Auto-generated method stub
		return dao.recipeFindData(ss);
	}

}
