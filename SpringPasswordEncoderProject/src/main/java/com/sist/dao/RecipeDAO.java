package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class RecipeDAO {
   // Resource(name="") ==> 1.8 
   @Autowired
   //@Qualifier("recipeMapper") => 특정 객체 
   private RecipeMapper mapper;
   
   /*
    *   @Select("SELECT no,title,poster,chef,num "
		 +"FROM (SELECT no,title,poster,chef,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)no,title,poster,chef "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
         public List<RecipeVO> recipeListData(Map map);
    */
   public List<RecipeVO> recipeListData(Map map)
   {
	   return mapper.recipeListData(map);
   }
   /*
    *   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
        public int recipeTotalPage();
    */
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
   
   /*
    *   @Select("SELECT no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7,num "
		 +"FROM (SELECT no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(chef chef_no_pk) no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7 "
		 +"FROM chef)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
         public List<ChefVO> chefListData(Map map);
    */
   public List<ChefVO> chefListData(Map map)
   {
	   return mapper.chefListData(map);
   }
   
   /*
    *   @Select("SELECT CEIL(COUNT(*)/30.0) FROM chef")
        public int chefTotalPage();
    */
   public int chefTotalPage()
   {
	   return mapper.chefTotalPage();
   }
   
   /*
    *   @Select("SELECT no,title,poster,chef,num "
			 +"FROM (SELECT no,title,poster,chef,rownum as num "
			 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) no,title,poster,chef "
			 +"FROM recipe WHERE REGEXP_LIKE(title,#{ss}))) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<RecipeVO> recipeFindData(Map map);
    */
   public List<RecipeVO> recipeFindData(Map map)
   {
	   return mapper.recipeFindData(map);
   }
   /*
    *   @Select("SELECT CEIL(COUNT(*)/12.0) FROM chef WHERE REGEXP_LIKE(title,#{title})")
         public int recipeFindTotalPage(String title)
    */
   public int recipeFindTotalPage(String title)
   {
	   return mapper.recipeFindTotalPage(title);
   }
}






