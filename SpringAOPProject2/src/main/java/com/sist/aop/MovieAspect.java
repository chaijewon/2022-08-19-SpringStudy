package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.sist.dao.MovieVO;

import java.util.*;
// getConnection => Before
// disConenection => After
// 기능 수행시 시간 ==> Around ==> log , transaction , security
// 1. xml
// 2. 어노테이션
// 3. spring5
// XML을 대체 (Annotation)
public class MovieAspect {
    public Object around(ProceedingJoinPoint jp) throws Throwable
    {
    	Object obj=null;
    	long start=0;
    	long end=0;
    	try
    	{
    		start=System.currentTimeMillis(); // 시작 시간 
    		System.out.println("Client 요청 메소드:"+jp.getSignature().getName());// 메소드 (호출)
    		// 메소드 호출 
    		obj=jp.proceed(); // invoke()
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		end=System.currentTimeMillis();
    		System.out.println("수행 시간:"+(end-start));
    	}
    	
    	return obj;
    }
    public void afterReturning(Object obj) throws Throwable
    {
    	List<MovieVO> list=(List<MovieVO>)obj;
    	for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno()+"."+vo.getTitle()+"("+vo.getGenre()+")");
        }
    }
    // 통합 예외처리 
    public void afterThrowing(Throwable ex) throws Throwable
    {
    	System.out.println(ex.getMessage());
    }
}







