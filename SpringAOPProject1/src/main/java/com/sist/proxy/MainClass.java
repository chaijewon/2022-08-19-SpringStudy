package com.sist.proxy;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MovieDAO dao=new MovieDAO();
        dao.movieListData();
        
        Proxy p=new Proxy(dao);
        p.movieListData();
	}

}
