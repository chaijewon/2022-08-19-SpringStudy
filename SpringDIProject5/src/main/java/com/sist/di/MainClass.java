package com.sist.di;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.EmpConfig;
//@Component
public class MainClass {//mainClass empMapper
	//@Autowired
    //private EmpDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //String[] xml= {"app-context.xml","app-datasource.xml"};
        //ApplicationContext app=
        		//new ClassPathXmlApplicationContext("app-context.xml");
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(EmpConfig.class);
        EmpDAO dao=(EmpDAO)app.getBean("empDAO");
		//MainClass mc=(MainClass)app.getBean("mainClass");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
        }
	}

}
