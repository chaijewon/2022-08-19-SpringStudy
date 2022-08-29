package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
  @Select("SELECT fno,name,poster,num "
		 +"FROM (SELECT fno,name,poster,rownum as num "
		 +"FROM (SELECT fno,name,poster "
		 +"FROM food_location ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location")
  public int foodTotalPage();
  
  // 상세보기 
  @Select("SELECT fno,name,poster,address,tel,type,menu,parking,price "
		 +"FROM food_location WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
  //     resultType   id      parameterType ==> Mybatis 자동 구현 
  
  // 검색 
  @Select("SELECT fno,name,poster,num "
		 +"FROM (SELECT fno,name,poster,rownum as num "
		 +"FROM (SELECT fno,name,poster "
		 +"FROM food_location WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
}
