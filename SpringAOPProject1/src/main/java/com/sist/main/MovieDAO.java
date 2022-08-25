package com.sist.main;
// 실제 서버 ==> 211.63.89.131
public class MovieDAO {
   // 공통으로 적용되는 부분
	private DataBase db;
	  
    public DataBase getDb() {
	  return db;
	}
	public void setDb(DataBase db) {
		this.db = db;
	}
   public void movieListData()
   {
	   db.getConnection();
	   System.out.println("영화 목록 가지고 오기..."); // 핵심코딩 
	   db.disConnection();
   }
   public void movieDetailData()
   {
	   db.getConnection();
	   System.out.println("영화 상세보기 데이터 가지고 오기...");
	   db.disConnection();
   }
   public void movieFindData()
   {
	   db.getConnection();
	   System.out.println("영화 검색 데이터 가지고 오기...");
	   db.disConnection();
	   
   }
}
