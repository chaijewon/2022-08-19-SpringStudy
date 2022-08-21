package com.sist.spring1;
// 1. new를 사용하지 않는다 
// new를 사용하면 결합성이 높은 프로그램 
// Class.forName()
public class Hello {
   public void sayHello(String name)
   {
	   System.out.println(name+"님 안녕하세요!!");
   }
}
