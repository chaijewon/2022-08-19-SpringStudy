package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper {
   @Select("SELECT cno,title,poster,subject "
		  +"FROM food_category "
		  +"WHERE cno BETWEEN #{start} AND #{end}")
   public List<CategoryVO> categoryListData(Map map);
   // fno(맛집고유번호) => 상세보기  , cno(category번호) 분리
   @Select("SELECT fno,name,poster,address,tel,type,score "
		  +"FROM food_house "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> foodListData(int cno);
   
   @Select("SELECT cno,title,subject "
		  +"FROM food_category "
		  +"WHERE cno=#{cno}")
   public CategoryVO categoryInfoData(int cno);
}
