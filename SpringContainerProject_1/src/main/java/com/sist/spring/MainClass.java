package com.sist.spring;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ApplicationContext();
        AModel a=(AModel)app.getBean("a");
        a.display();
	}

}
