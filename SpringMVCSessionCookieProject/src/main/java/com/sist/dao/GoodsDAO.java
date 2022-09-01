package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;

@Repository
public class GoodsDAO {
  @Autowired
  private GoodsMapper mapper;
  
  /*@Select("SELECT no,goods_name,goods_price,goods_poster,num "
		  +"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(goods_all ga_no_pk)/no,goods_name,goods_price,goods_poster "
		  +"FROM goods_all))")*/
   public List<GoodsVO> goodsListData(Map map)
   {
	   return mapper.goodsListData(map);
   }
   //@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
   public int goodsTotalPage()
   {
	   return mapper.goodsTotalPage();
   }
   
   /*@Select("SELECT * FROM goods_all "
		  +"WHERE no=#{no}")*/
   public GoodsVO goodsDetailData(int no)
   {
	   return mapper.goodsDetailData(no);
   }
}
