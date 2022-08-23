package com.sist.spring5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MainClass {
	@Autowired
    private MovieDAO dao;// 클래스와 클래스의 관계도 ==> 메뉴얼
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(MovieConfig.class);
        //MovieDAO dao=app.getBean("movieDAO",MovieDAO.class);
        Map map=new HashMap();
        map.put("start", 1);
        map.put("end", 100);
        MainClass mc=(MainClass)app.getBean("mainClass");
        List<MovieVO> list=mc.dao.movieListData(map);
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle());
        }
	}

}
