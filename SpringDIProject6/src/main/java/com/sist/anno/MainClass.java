package com.sist.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
@Component("mc")
public class MainClass {
    @Autowired
    private MovieDAO dao;// 스프링에 생성된 dao의 주소값을 주입(스프링에서 getBean() 대신 처리)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        Map map=new HashMap();
        map.put("start", 1);
        map.put("end", 10);
        List<MovieVO> list=mc.dao.movieListData(map);
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle());
        }
	}

}
