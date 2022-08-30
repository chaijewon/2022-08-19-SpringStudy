package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsBestMapper;
// 스프링에 Mapper를 구현 클래스를 가지고 있다 
/*
 *    1. 클래스 메모리 할당 요청 
 *       @Repository
 *    2. 스프링에서 생성된 클래스중에 사용해야하는 클래스의 주소값을 받는다 
 *       @Autowired
 */
@Repository
public class GoodsBestDAO {
   @Autowired
   private GoodsBestMapper mapper;
   
   public List<GoodsVO> goodsBestListData(Map map)
   {
	   return mapper.goodsBestListData(map);
   }
   public GoodsVO goodsBestDetailData(int no)
   {
	   return mapper.goodsBestDetailData(no);
   }
}
