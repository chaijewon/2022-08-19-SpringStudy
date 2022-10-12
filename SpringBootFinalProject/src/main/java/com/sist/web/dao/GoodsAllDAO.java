package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.GoodsEntity;
import java.util.*;
@Repository
/*
 *   private int no;
  private String goods_name,goods_sub,goods_first_price,goods_poster;
  private int goods_discount,hit;
 */
public interface GoodsAllDAO extends JpaRepository<GoodsEntity, Integer>{
    @Query(value="SELECT * "
    	        +"FROM goods_all ORDER BY no ASC "
    	        +"LIMIT :start,12",nativeQuery = true)
    public List<GoodsEntity> goodsListData(@Param("start") Integer start);
    
    @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM goods_all",nativeQuery = true)
    public int goodsAllTotalpage();
    
    public GoodsEntity findByNo(int no); // 상세보기 
    
    // save():insert/update , delete(): 삭제 
}
