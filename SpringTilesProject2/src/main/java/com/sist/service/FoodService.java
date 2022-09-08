package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface FoodService {
	public List<CategoryVO> categoryListData(Map map);
	public List<FoodVO> foodListData(int cno);
	public CategoryVO categoryInfoData(int cno);
	public FoodVO foodDetailData(int fno);
}
