package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//client 
/*
 *     MovieDAO dao=new MovieDAO();
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MovieDAO dao=(MovieDAO)app.getBean("dao");
        dao.movieDetailData();
        dao.movieFindData();
        dao.movieListData();
        
        MusicDAO dao1=(MusicDAO)app.getBean("dao1");
        dao1.musicDetailData();
        dao1.musicFindData();
        dao1.musicListData();
	}

}
