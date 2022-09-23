package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *   기본 기술 
 *   자바
 *    객체지향 프로그램 (3대) 
 *      은닉화 VS 캡슐화 
 *      오버로딩 VS 오버라이딩 
 *      추상 클래스 VS 인터페이스 
 *      객체의 개념 
 *      인터페이스의 활용법 
 *    예외처리 
 *      예외처리 종류 / 예외의 정의,목적
 *    Collection
 *       종류 (List,Set,Map)
 *           => 제네릭스 
 *   오라클 
 *     = JOIN / SUBQUERY 
 *     = View 
 *     = Index 
 *     = Procedure VS Trigger
 *     = 데이터형 (BLOB VS BFILE)
 *   JSP
 *     = GET VS POST
 *     = MVC
 *     = Cookie VS Session
 *   스프링 
 *     = DI , AOP 
 *     = Transaction 
 *     = DAO VS Service
 *     = XML / Annotation
 *   기타 
 *     형상관리 => 협업 (Git)
 *   자바스크립트 
 *     Ajax , 동기화/비동기화 , JSONP , JSON , Rest , 클로저 
 *   인성 면접 
 *   면접 자세 => 일관성 
 *   
 *   ======> 프로젝트 (본인 담당) 
 */
/*
 *   NO     NOT NULL NUMBER         
	TITLE  NOT NULL VARCHAR2(1000) 
	POSTER NOT NULL VARCHAR2(260)  
	CHEF   NOT NULL VARCHAR2(300)  
	LINK   NOT NULL VARCHAR2(200)  
	HIT             NUMBER   
 */
public interface RecipeMapper {
  // 레시피 
  @Select("SELECT no,title,poster,chef,num "
		 +"FROM (SELECT no,title,poster,chef,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/no,title,poster,chef "
		 +"FROM recipe)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeListData(Map map);
  // 레시피 검색 => 동적 쿼리 
  @Select("SELECT no,title,poster,chef,num "
			 +"FROM (SELECT no,title,poster,chef,rownum as num "
			 +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)*/ no,title,poster,chef "
			 +"FROM recipe WHERE REGEXP_LIKE(title,#{ss}))) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<RecipeVO> recipeFindData(Map map);
  // 쉐프 
  /*
   *    NO        NOT NULL NUMBER        
		CHEF      NOT NULL VARCHAR2(300) 
		POSTER    NOT NULL VARCHAR2(260) 
		MEM_CONT1          VARCHAR2(20)  
		MEM_CONT2          VARCHAR2(20)  
		MEM_CONT3          VARCHAR2(20)  
		MEM_CONT7          VARCHAR2(20)
   */
  @Select("SELECT no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7,num "
		 +"FROM (SELECT no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(chef chef_no_pk) */no,chef,poster,mem_cont1,mem_cont2,mem_cont_3,mem_cont7 "
		 +"FROM chef)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<ChefVO> chefListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
  public int recipeTotalPage();
  
  @Select("SELECT CEIL(COUNT(*)/30.0) FROM chef")
  public int chefTotalPage();
  
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM chef WHERE REGEXP_LIKE(title,#{title})")
  public int recipeFindTotalPage(String title);
  // 쉐프 검색 
  // 레시피 => 재료별 레시피
}



























