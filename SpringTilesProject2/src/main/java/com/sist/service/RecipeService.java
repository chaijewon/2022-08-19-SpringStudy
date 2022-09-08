package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeTotalPage();
	public List<RecipeVO> recipeFindData(String ss);
}
