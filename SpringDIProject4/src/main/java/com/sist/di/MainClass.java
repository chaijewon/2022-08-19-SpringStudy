package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. XML 파일 전송 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		Member mem=(Member)app.getBean("mem");
		mem.display();
	}

}
