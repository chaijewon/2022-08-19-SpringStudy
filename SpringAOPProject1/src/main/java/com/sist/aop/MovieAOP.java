package com.sist.aop;

public class MovieAOP {
    public void getConnection()
    {
    	System.out.println("오라클 연결");
    }
    public void disConnection()
    {
    	System.out.println("오라클 연결 해제");
    }
}
