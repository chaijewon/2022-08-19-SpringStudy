package com.sist.di;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");//Spring 셋팅 (MovieDAO 첨부)
        // MovieDAO dao=new MovieDAO() ==> null
		Scanner scan=new Scanner(System.in);
        System.out.print("페이지 입력:");
        int page=scan.nextInt();
        
        int rowSize=10;
        int start=(rowSize*page)-(rowSize-1);
        int end=rowSize*page;
        
        Map map=new HashMap();
        map.put("start",start);
        map.put("end",end);
        // WHERE num BETWEEN map.get("start") AND map.get("end")  => map.get("start") , map.get("end")
        MovieDAO dao=(MovieDAO)app.getBean("dao");
        List<MovieVO> list=dao.movieListData(map);
        // 출력 
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle());
        }
	}

}
