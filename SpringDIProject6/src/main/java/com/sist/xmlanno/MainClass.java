package com.sist.xmlanno;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("mc")
public class MainClass {
	@Autowired
    private MovieDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app3.xml");
        Map map=new HashMap();
        map.put("start", 1);
        map.put("end", 20);
        //MovieDAO dao=(MovieDAO)app.getBean("movieDAO");
        MainClass mc=(MainClass)app.getBean("mc");
        List<MovieVO> list=mc.dao.movieListData(map);
        for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle());
        }
	}

}
