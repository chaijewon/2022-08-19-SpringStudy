package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
/*
 *   1. Spring MVC 
 *        = jsp:include 
 *        = tiles
 *      = 로그인 처리 = session / cookie 
 *      = 회원가입	 
 *      = 게시판  = 페이징 기법 ==> CURD
 *      = 목록 / 상세보기 
 *      = 댓글 
 *   2. 프로시저 
 *   ================================
 *   3. Vue,React
 *   ================================
 */
import org.apache.ibatis.annotations.Update;

import com.sist.vo.SeoulVO;
public interface SeoulMapper {
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT no,title,poster "
		 +"FROM ${table_name} ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<SeoulVO> seoulListData(Map map);
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
  public int seoulTotalPage(Map map);
  
  @Select("SELECT * FROM ${table_name} "
		 +"WHERE no=#{no}")
  public SeoulVO seoulDetailData(Map map);
  @Update("UPDATE ${table_name} SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(Map map);
  
  @Select("SELECT no,title,poster,hit,rownum "
		 +"FROM (SELECT no,title,poster,hit "
		 +"FROM ${table_name} ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
  public List<SeoulVO> seoulTop5(Map map);
}





