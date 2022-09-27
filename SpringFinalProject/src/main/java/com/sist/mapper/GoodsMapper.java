package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
/*
 *  
 *      NO                NOT NULL NUMBER         
		GOODS_NAME        NOT NULL VARCHAR2(1000) 
		GOODS_SUB                  VARCHAR2(1000) 
		GOODS_PRICE       NOT NULL VARCHAR2(50)   
		GOODS_DISCOUNT             NUMBER         
		GOODS_FIRST_PRICE          VARCHAR2(20)   
		GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
		GOODS_POSTER               VARCHAR2(260)
 */

import com.sist.vo.GoodsVO;
public interface GoodsMapper {
  @Select("SELECT no,goods_name,goods_price,goods_poster,num "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<GoodsVO> goodsListData(Map map);
  /*
   *    rownum : mysql
   *    
   *    =>"SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC LIMIT #{start},#{end}
		 
		=> no int autoincrement()
   */
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
  public int goodsTotalPage(Map map);
  
  @Select("SELECT * FROM ${table_name} "
		 +"WHERE no=#{no}")
  public GoodsVO goodsDetailData(Map map); // VO에 존재 (GoodsVO) , VO에 없는 변수 포함 (Map map)
  
  @Select("SELECT no,goods_name,goods_price,goods_poster,rownum "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC) "
		 +"WHERE rownum<=6")
  public List<GoodsVO> goodsMainData(Map map);
}










