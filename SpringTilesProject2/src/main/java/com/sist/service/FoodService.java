package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface FoodService {
	public List<CategoryVO> categoryListData(Map map);
	public List<FoodVO> foodListData(int cno);
	public CategoryVO categoryInfoData(int cno);
	public FoodVO foodDetailData(int fno);
	public List<String> foodTop5();
	public List<FoodVO> foodFindData(Map map);
	public int foodLocationTotalPage(String address);
	public FoodVO foodDetailVueData(int fno);
}
