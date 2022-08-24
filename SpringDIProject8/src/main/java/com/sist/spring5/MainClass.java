package com.sist.spring5;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ApplicationContext app= new ClassPathXmlApplicationContext("app1.xml");
		 */
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(MovieConfig.class);
        MovieDAO dao=(MovieDAO)app.getBean("dao");
        /*List<MovieVO> list=dao.movieListData();
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle());
        }*/
        Scanner scan=new Scanner(System.in);
        System.out.println("======== Menu =======");
        System.out.println("1. 제목");
        System.out.println("2. 장르");
        System.out.println("3. 출연");
        System.out.println("4. 제목+장르");
        System.out.println("5. 제목+출연");
        System.out.println("6. 출연+장르");
        System.out.println("7. 제목+장르+출연");
        System.out.println("=====================");
        System.out.print("메뉴 선택:");
        int menu=scan.nextInt();
        Map map=new HashMap();
        List<MovieVO> list=new ArrayList<MovieVO>();
        ArrayList<String> nList=new ArrayList<String>();
        if(menu==1)
        {
        	nList.add("T");
        }
        else if(menu==2)
        {
        	nList.add("G");
        }
        else if(menu==3)
        {
        	nList.add("A");
        }
        else if(menu==4)
        {
        	nList.add("T");
        	nList.add("G");
        }
        else if(menu==5)
        {
        	nList.add("T");
        	nList.add("A");
        }
        else if(menu==6)
        {
        	nList.add("A");
        	nList.add("G");
        }
        else if(menu==7)
        {
        	nList.add("T");
        	nList.add("G");
        	nList.add("A");
        }
        Object[] fsArr=nList.toArray();
        System.out.print("검색어 입력:");
        String ss=scan.next();
        map.put("fsArr", fsArr);
        map.put("ss", ss);
        
        list=dao.movieFindData(map);
        
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getGenre());
        	System.out.println(vo.getActor());
        	System.out.println("==============================================");
        }
	}

}









