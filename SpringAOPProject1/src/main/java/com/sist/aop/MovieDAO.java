package com.sist.aop;

public class MovieDAO {
   public void movieListData()
   {
	   //Before
	   System.out.println("movie 목록 출력...");
	   //After
   }
   public void movieDetailData()
   {
	   System.out.println("movie 상세보기 출력...");
   }
   public void movieFindData()
   {
	   System.out.println("movie 검색 출력...");
   }
}
