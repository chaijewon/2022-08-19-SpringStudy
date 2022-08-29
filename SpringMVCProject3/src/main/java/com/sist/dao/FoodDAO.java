package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
   @Autowired  // 자동 주입
   private FoodMapper mapper;
   
   public List<FoodVO> foodListData(Map map)
   {
	   return mapper.foodListData(map);// 핵심 코딩 
   }
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
   public FoodVO foodDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
   
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
}
