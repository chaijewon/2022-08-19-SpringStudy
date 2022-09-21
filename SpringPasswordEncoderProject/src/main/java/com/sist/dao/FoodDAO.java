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
}
