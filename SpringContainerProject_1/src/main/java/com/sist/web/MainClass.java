package com.sist.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        
        AModel a=(AModel)app.getBean("a");
        a.display();
        
        BModel b=(BModel)app.getBean("b");
        b.display();
	}

}
