package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
   // 스프링에서 구현된 Mapper를 가지고 온다 
   @Autowired
   private FoodMapper mapper;
   
   public List<CategoryVO> categoryListData(Map map)
   {
	   return mapper.categoryListData(map);
   }
   
   public List<FoodVO> foodListData(int cno)
   {
	   return mapper.foodListData(cno);
   }
   
   public CategoryVO categoryInfoData(int cno)
   {
	   return mapper.categoryInfoData(cno);
   }
   
   public FoodVO foodDetailData(int fno)
   {
	   mapper.hitIncrement(fno);
	   return mapper.foodDetailData(fno);
   }
   public List<String> foodTop5()
   {
	   return mapper.foodTop5();
   }
   /*
    *   @Select("SELECT fno,name,poster,num "
		  +"FROM (SELECT fno,name,poster,rownum as num "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM food_location WHERE address LIKE '%'||#{address}||'%')) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
		   public List<FoodVO> foodFindData(Map map);
		   
		   @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
				  +"WHERE address LIKE '%'||#{address}||'%'")
		   public int foodLocationTotalPage(String address);
    */
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
   public int foodLocationTotalPage(String address)
   {
	   return mapper.foodLocationTotalPage(address);
   }
   
   public FoodVO foodDetailVueData(int fno)
   {
	   return mapper.foodDetailVueData(fno);
   }
}
