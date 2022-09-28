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
import org.apache.ibatis.annotations.Update;

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
		let sum=0;
		for(let i=0;arr.length;i++)
		{
		   sum+=i
		}
		document.write(sum)
   */
  @Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
  public int goodsTotalPage(Map map);
  
  @Select("SELECT * FROM ${table_name} "
		 +"WHERE no=#{no}")
  public GoodsVO goodsDetailData(Map map); // VO에 존재 (GoodsVO) , VO에 없는 변수 포함 (Map map)
  
  @Update("UPDATE ${table_name} SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void goodsHitIncrement(Map map);
  
  
  @Select("SELECT no,goods_name,goods_price,goods_poster,rownum "
		 +"FROM (SELECT no,goods_name,goods_price,goods_poster "
		 +"FROM ${table_name} ORDER BY no ASC) "
		 +"WHERE rownum<=6")
  public List<GoodsVO> goodsMainData(Map map);
  
  @Select("SELECT no,goods_name,goods_poster,rownum "
		 +"FROM (SELECT no,goods_name,goods_poster "
		 +"FROM goods_all ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
  public List<GoodsVO> goodsFooterData();
  
}










