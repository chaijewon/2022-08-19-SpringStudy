package com.sist.spring1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericXmlApplicationContext gc=
        		new GenericXmlApplicationContext("app2.xml");
        Student s=(Student)gc.getBean("std");
        // s.init() => 자동로그인 , 드라이버 등록
        s.print();
        gc.close(); 
        // s.destory() ==> 자동 로그아웃  , 데이터베이스 연결 해제 
	}

}
