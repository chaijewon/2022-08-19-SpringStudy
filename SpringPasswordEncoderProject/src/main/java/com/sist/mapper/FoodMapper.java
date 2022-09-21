package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
import com.sist.vo.CategoryVO;
public interface FoodMapper {
   @Select("SELECT cno,title,subject,poster FROM food_category ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryAllData();
}
