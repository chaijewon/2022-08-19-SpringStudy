package com.sist.proxy;

public class Proxy {
    private MovieDAO dao;
    public Proxy(MovieDAO dao)
    {
    	this.dao=dao;
    }
    public void movieListData()
    {
    	System.out.println("오라클 연결");//before
    	dao.movieListData();
    	System.out.println("오라클 연결 해제");//after
    }
}
