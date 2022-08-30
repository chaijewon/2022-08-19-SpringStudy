package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsSpecialMapper;

@Repository
public class GoodsSpecialDAO {
   @Autowired
   private GoodsSpecialMapper mapper;
   
   public List<GoodsVO> goodsSpecialListData(Map map)
   {
	   return mapper.goodsSpecialListData(map);
   }
   
   public GoodsVO goodsSpecialDetailData(int no)
   {
	   return mapper.goodsSpecialDetailData(no);
   }
}
