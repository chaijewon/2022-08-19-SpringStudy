package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.GoodsVO;
public interface GoodsAllMapper {
  @Select("SELECT no,goods_name as name,goods_poster as poster,goods_price as price,num "
		 +"FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(goods_all ga_no_pk)*/no,goods_name,goods_poster,goods_price "
		 +"FROM goods_all)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<GoodsVO> goodsAllListData(Map map);
  /*
   *   GOODS_NAME        NOT NULL VARCHAR2(1000) 
	GOODS_SUB                  VARCHAR2(1000) 
	GOODS_PRICE       NOT NULL VARCHAR2(50)   
	GOODS_DISCOUNT             NUMBER         
	GOODS_FIRST_PRICE          VARCHAR2(20)   
	GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
	GOODS_POSTER               VARCHAR2(260)
   */
  @Results({
	  @Result(property = "name",column = "goods_name"),
	  @Result(property = "sub",column = "goods_sub"),
	  @Result(property = "price",column = "goods_price"),
	  @Result(property = "discount",column = "goods_discount"),
	  @Result(property = "first_price",column = "goods_firest_price"),
	  @Result(property = "delivery",column = "goods_delivery"),
	  @Result(property = "poster",column = "goods_poster")
  })
  @Select("SELECT * FROM goods_all "
		 +"WHERE no=#{no}")
  public GoodsVO goodsAllDetailData(int no);
}
