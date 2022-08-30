package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsAllMapper;

@Repository
public class GoodsAllDAO {
   @Autowired
   private GoodsAllMapper mapper;
   
   public List<GoodsVO> goodsAllListData(Map map)
   {
	   return mapper.goodsAllListData(map);
   }
   public GoodsVO goodsAllDetailData(int no)
   {
	   return mapper.goodsAllDetailData(no);
   }
   
   public int goodsAllTotalPage()
   {
	   return mapper.goodsAllTotalPage();
   }
}
