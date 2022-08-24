package com.sist.main2;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		 */
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(EmpConfig.class);
        EmpDAO dao=(EmpDAO)app.getBean("empDAO");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc());
        }
	}

}
