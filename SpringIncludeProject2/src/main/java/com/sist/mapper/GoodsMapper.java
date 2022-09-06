package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface GoodsMapper {
   @Select("SELECT no,goods_name,goods_price,goods_poster,num "
		  +"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
		  +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		  +"FROM ${table_name} ORDER BY no ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<GoodsVO> goodsListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/5.0) FROM ${table_name}")
   public int goodsTotalPage(Map map);
   /*
    *   $ => 테이블,컬럼 => 변환 ''(X)
    *   # => 일반 데이터 => 변환  ''
    */
   @Select("SELECT * FROM ${table_name} "
		  +"WHERE no=#{no}")
   public GoodsVO goodsDetailData(Map map);
   
   // 로그인 처리 
   //1. ID 체크
   @Select("SELECT COUNT(*) FROM project_member "
		  +"WHERE id=#{id}")
   public int idCount(String id);
   //2. 비밀번호 비교 
   @Select("SELECT pwd,name FROM project_member "
		 +"WHERE id=#{id}")
   public MemberVO memberGetPassword(String id);
   
}
