package com.sist.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   4page 
 *     DI ==> 70~80% (Any Framework(대기업) , 전자정부 프레임워크(공기업)) => 스프링 기반 
 *            금융권 일반 스프링
 *            ================================================================ 금융권+공기업 (90%)
 *            컴포넌트  : 한개의 기능 (일부) , 게시판 , 공지사항 ....
 *            컨테이너 : 컴포넌트 여러개를 모아서 관리 
 *            ------------------------------ 스프링 (관계도) ==> 가급적이면 new를 사용하지 않는다 
 *            DI => 클래스와 클래스의 연관 관계도 
 *                  주입 
 *            ==> 컨테이너 (ApplicationContext:컴포넌트를 생성하고 관리)
 *            1. DI , 2. AOP , 3. MVC (DI+AOP)
 *            = Basic = Transaction/log/security
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. 컨테이너에 XML파일을 전송 ==> XML파싱후에 => 메모리 할당 => setter에 값을 주입 
		/*
		 *    컨테이너 => 클래스
		 *    BeanFactory : Core(DI)
		 *        |
		 *    ***ApplicationContext : Core+AOP
		 *        |                            |
		 *   WebApplicationContext        AnnotationConfigApplicationContext(5버전)
		 *      Core+AOP+MVC                 Core+AOP+Annotation
		 */
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		SawonVO sa1=(SawonVO)app.getBean("sa1"); //등록된 ID를 가지고 해당 객체를 찾아 온다 ==> DL
		sa1.print();
		
		SawonVO sa2=app.getBean("sa2",SawonVO.class);
		sa2.print();
		
		SawonVO sa3=(SawonVO)app.getBean("sa3");
		sa3.print();
		// 메모리 할당 => HashMap에 저장 (객체의 주소가 동일 => 싱글턴) 
		// DI(값 주입 ==> database,서버)
	}

}





