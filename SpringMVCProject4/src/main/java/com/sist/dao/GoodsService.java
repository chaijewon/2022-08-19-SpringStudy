package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//BI => DAO여러개 통합해서 사용 
@Service
public class GoodsService {
   @Autowired
   private GoodsAllDAO aDao;
   
   @Autowired
   private GoodsBestDAO bDao;
   
   @Autowired
   private GoodsSpecialDAO sDao;
   
   @Autowired
   private GoodsNewDAO nDao;
   
   public List<GoodsVO> goodsAllListData(Map map)
   {
	   return aDao.goodsAllListData(map);
   }
   
   public GoodsVO goodsAllDetailData(int no)
   {
	   return aDao.goodsAllDetailData(no);
   }
   
   public List<GoodsVO> goodsBestListData(Map map)
   {
	   return bDao.goodsBestListData(map);
   }
   
   public GoodsVO goodsBestDetailData(int no)
   {
	   return bDao.goodsBestDetailData(no);
   }
   
   public List<GoodsVO> goodsSpecialListData(Map map)
   {
	   return sDao.goodsSpecialListData(map);
   }
   
   public GoodsVO goodsSpecialDetailData(int no)
   {
	   return sDao.goodsSpecialDetailData(no);
   }
   
   public List<GoodsVO> goodsNewListData(Map map)
   {
	   return nDao.goodsNewListData(map);
   }
   
   public GoodsVO goodsNewDetailData(int no)
   {
	   return nDao.goodsNewDetailData(no);
   }
   
   public int goodsAllTotalPage()
   {
	   return aDao.goodsAllTotalPage();
   }
   
}
