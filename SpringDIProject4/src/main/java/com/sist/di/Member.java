package com.sist.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
/*
 *    순서  
 *     메모리 할당 => Setter DI (X)
 *     
 *     == bean으로 등록된 모든 클래스를 메모리 할당 
 *     == Setter
 *     
 *     생명주기 
 */
public class Member implements BeanFactoryAware,InitializingBean{
   private int mno;
   private String name;
   public Member()
   {
	   System.out.println("객체 생성!!");
   }
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
		System.out.println("setter DI 수행:setMno()");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setter DI 수행:setName()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setXxx() => DI 완료");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory : 클래스를 저장 관리할 클래스 호출");
	}
	public void display()
	{
		System.out.println("프로그래머가 호출");
	}
	/*
	 *    1. XML 읽기 
	 *    2. XML 파서
	 *       2-1. <bean>에 등록된 모든 클래스 할당 
	 *       2-2. setter DI 
	 *       2-3. init-method에 등록된 메소드 
	 *    ---------------------------------------------
	 *    3. 사용자 메소드 호출 (프로그래머 영역)
	 *    ---------------------------------------------
	 *    4. 스프링에서 메모리 해제
	 */
   
}
