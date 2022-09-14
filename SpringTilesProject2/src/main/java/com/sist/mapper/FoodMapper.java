package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
   
   // 상세보기 
   @Select("SELECT fno,name,poster,address,score,tel,type,time,parking,menu,price "
		  +"FROM food_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   // 명소 , 쇼핑 , 자연 , 레시피
   
   @Update("UPDATE food_house SET "
		  +"hit=hit+1 "
		  +"WHERE fno=#{fno}")
   public void hitIncrement(int fno);
   
   @Select("SELECT name,rownum "
		  +"FROM (SELECT name FROM food_house ORDER BY hit DESC) "
		  +"WHERE rownum<=5")
   public List<String> foodTop5();
   
   @Select("SELECT fno,name,poster,num "
		  +"FROM (SELECT fno,name,poster,rownum as num "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM food_location WHERE address LIKE '%'||#{address}||'%')) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodFindData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
		  +"WHERE address LIKE '%'||#{address}||'%'")
   public int foodLocationTotalPage(String address);
   
   @Select("SELECT fno,name,poster,address,score,tel,type,time,parking,menu,price "
			  +"FROM food_location "
			  +"WHERE fno=#{fno}")
	public FoodVO foodDetailVueData(int fno);
}







