package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
public interface FoodMapper {
   @Select("SELECT cno,title,poster,subject "
		  +"FROM food_category "
		  +"WHERE cno BETWEEN #{start} AND #{end}")
   public List<CategoryVO> categoryListData(Map map);
}
