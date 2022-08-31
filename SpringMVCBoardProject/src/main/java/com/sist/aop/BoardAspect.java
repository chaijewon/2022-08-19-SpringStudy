package com.sist.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardAspect {
    // 시점 => 메소드를 적용한 위치 => JoinPoint 
	// 어떤 메소드 => PointCut
	// JoinPoint+PointCut = Weaving
	@Before("execution(* com.sist.web.*Controller.*(..))")//메소드에 진입 
	public void before(JoinPoint jp)
	{
		String name=jp.getSignature().getName();
		System.out.println(name+"진입...");
	}
	@After("execution(* com.sist.web.*Controller.*(..))")//메소드 => finally ==> 사이트에서 공통 출력부분 
	public void after(JoinPoint jp)
	{
		String name=jp.getSignature().getName();
		System.out.println(name+"정상적으로 수행 완료...");
	}
	@AfterReturning(value="execution(* com.sist.web.*Controller.*(..))",returning = "obj")//=> 정상 수행 => return값을 받아서 처리  
    public void afterReturning(String obj)
    {
		System.out.println(obj+".jsp로 이동 완료...");
    }
}
