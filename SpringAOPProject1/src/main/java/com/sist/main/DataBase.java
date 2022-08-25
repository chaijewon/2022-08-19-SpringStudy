package com.sist.main;
// 공통 모듈 ==> Aspect 
public class DataBase {
	   public void getConnection()
	   {
		   System.out.println("오라클 연결(211.63.89.131)");
	   }
	   public void disConnection()
	   {
		   System.out.println("오라클 연결 해제");
	   }
}
