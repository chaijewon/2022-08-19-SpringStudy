package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
   @Select("SELECT no,title,poster,chef,num "
		 +"FROM (SELECT no,title,poster,chef,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,poster,chef "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
   public int recipeTotalPage();
   /*
    *     기호 
    *      * : 0이상 포함 
    *      + : 1이상 포함 
    *      | : 선택 (OR)  A|B|C  LIEK '%A%' OR LIKE '%B%' OR LIKE
    *      ^ : 제외 , 시작 
    *          [^A-Z] 알파벳 대문자 제외
    *          ^[A-Z] 알파벳으로 시작      A%
    *      $ : 마지막 글자                         %A
    *      . : 임의의 1글자 
    *      
    *      범위 :  [0-9] , [A-Z] , [a-z] , [A-Za-z] , [가-힣]
    *      갯수 :  {3} [0-9]{3} , [0-9]{1,3} 
    *      REGEXP_LIKE() ==> 패턴을 이용해서 찾는 방식 
    *      
    */
   @Select("SELECT no,title,poster,rownum "
		  +"FROM recipe "
		  +"WHERE REGEXP_LIKE(title,#{ss}) "
		  +"AND rownum<=6")
   public List<RecipeVO> recipeFindData(String ss);
}
