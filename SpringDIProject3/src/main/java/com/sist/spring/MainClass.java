package com.sist.spring;
// 스프링에서 지정한 XML 태그 , 속성만 사용이 가능 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AppicationContext app=
        		new AppicationContext("app.xml");
        Sawon s=(Sawon)app.getBean("sa");
        s.print();
	}

}
