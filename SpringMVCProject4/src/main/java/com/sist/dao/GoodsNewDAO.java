package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsNewMapper;

@Repository
public class GoodsNewDAO {
   @Autowired
   private GoodsNewMapper mapper;
   
   public List<GoodsVO> goodsNewListData(Map map)
   {
	   return mapper.goodsNewListData(map);
   }
   
   public GoodsVO goodsNewDetailData(int no)
   {
	   return mapper.goodsNewDetailData(no);
   }
}
