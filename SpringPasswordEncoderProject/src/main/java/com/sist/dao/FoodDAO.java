package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  /*
   *   @Select("SELECT cno,title,subject,poster FROM food_category")
       public List<CategoryVO> foodCategoryAllData();
   */
  public List<CategoryVO> foodCategoryAllData()
  {
	  return mapper.foodCategoryAllData();
  }
  /*
   *   @Select("SELECT fno,cno,name,tel,poster,type FROM food_house "
		  +"WHERE cno=#{cno}")
       public FoodVO foodCategoryListData(int cno);
   */
  public List<FoodVO> foodCategoryListData(int cno)
  {
	  return mapper.foodCategoryListData(cno);
  }
  /*
   *   @Select("SELECT title,subject FROM food_category WHERE cno=#{cno}")
       public CategoryVO categoryInfoData(int cno);
   */
  public CategoryVO categoryInfoData(int cno)
  {
	  return mapper.categoryInfoData(cno);// JSP전송 (Controller) => DispatcherServlet에서 제어할 수 없다 
  }
  
  /*
   *   @Select("SELECT poster,rownum FROM recipe "
		  +"WHERE REGEXP_LIKE(title,#{type}) "
		  +"AND rownum<=12")
       public List<String> foodLikeRecipe(String type);
   */
  public List<String> foodLikeRecipe(String type)
  {
	  return mapper.foodLikeRecipe(type);
  }
  /*
   *  @Select("SELECT * FROM food_house "
		  +"WHERE fno=#{fno}")
      public FoodVO foodDetailData(int fno);
   */
  public FoodVO foodDetailData(int fno)
  {
	  return mapper.foodDetailData(fno);
  }
}
  
