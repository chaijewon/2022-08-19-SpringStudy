package com.sist.goods.dao;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.goods.vo.GoodsVO;

@Repository
@Mapper
public interface GoodsMapper {
   public List<GoodsVO> goodsMainData(Map map);
   public List<GoodsVO> goodsListData(Map map);
   public int goodsTotalPage(Map map);
}
