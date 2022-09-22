package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
public interface FoodMapper {
   @Select("SELECT cno,title,subject,poster FROM food_category ORDER BY cno ASC")
   public List<CategoryVO> foodCategoryAllData();
   
   // 카테고리별 맛집 출력  
   @Select("SELECT fno,cno,name,tel,poster,type,address,score FROM food_house "
		  +"WHERE cno=#{cno}")
   public List<FoodVO> foodCategoryListData(int cno);
   
   @Select("SELECT title,subject FROM food_category WHERE cno=#{cno}")
   public CategoryVO categoryInfoData(int cno);
   
   // XML ==> <select id="categoryInfoData" resultType="CategoryVO" parameterType="int">SELECT title,subject FROM food_category WHERE cno=#{cno}</select>
   @Select("SELECT poster,rownum FROM recipe "
		  +"WHERE REGEXP_LIKE(title,#{type}) "
		  +"AND rownum<=12")
   public List<String> foodLikeRecipe(String type);
   // 상세보기 =========> Vue지도 출력 (Vue ==> Jquery) 
   @Select("SELECT * FROM food_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   // 명소 / 자연 / 쇼핑 
}
