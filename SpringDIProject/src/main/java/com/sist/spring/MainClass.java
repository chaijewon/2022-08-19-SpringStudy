package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        Member mem1=(Member)app.getBean("mem1");
        mem1.print();
        
        Member mem2=(Member)app.getBean("mem2");
        mem2.print();
        
        Member mem3=(Member)app.getBean("mem3");
        mem3.print();
	}

}
