package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *    1. 스프링 : 클래스를 모아서 관리 (의존성이 낮은 프로그램 = 유지 보수시에 다른 클래스에 영향이 없는 프로그램)
 *              =========== 사용자 정의 , 라이브러리 (컨테이너)
 *              클래스 : 컴포넌트 (기능을 가지고 있는 클래스) 
 *       컨테이너에 대한 종류 , 하는 역할 (*******) 
 *             BeanFactory 
 *                |
 *            ApplicationContext - AnnotationConfigApplicationContext(자바로 환경 설정)
 *                |
 *          WebApplicationContext - AnnotationConfigWebApplicationContext
 *    2. 클래스를 모아서 관리
 *       사용자가 요청을 하면 => 클래스 찾기 (DL) => getBean()
 *       클래스 관리를 하기 위해 필요한 데이터를 첨부 => DI 
 *    3. MVC (스프링 라이브러리)
 *    ==================================================================================
 *      ==> 자바 / 오라클 / JSP / 스프링 / AWS
 *      스프링 생명주기 (객체 생명주기 관리 : 생성 ~ 소멸)
 *                                ====== 필요한 데이터가 있을 수 있다(DI)
 *         *** IoC (제어의 역전) : 스프링을 통해서 객체를 가지고 온다 
 *                              =========== 지금은 DI로 통합 (객체와 객체의 연관 관계 설계)
 *         1. 클래스 메모리 할당 (모든 클래스)  ==> 생성자를 통해서 필요한 데이터를 주입
 *            1) 한개씩 생성 
 *               <bean id="구분자" class="패키지.클래스명">
 *            2) 패키지 단위로 생성 
 *               <context:component-scan base-package="패키지명">
 *                                       ----------------------
 *                                        메모리 할당 대상 (선택) 
 *                                        @Controller : 웹 화면 변경 / 사용자 요청 처리 / JSP에 출력할 데이터 전송 
 *                                                      ---------
 *                                                      forward (request를 유지하면서 새로운 데이터를 추가)
 *                                                      ==> request대신 Model(전송객체)
 *                                                          ==> addAttribute()
 *                                                          ==> return "경로명/파일명"
 *                                                      redirect : request를 초기화 기존에 만든 파일로 이동 
 *                                                          ==> Model을 사용 할 수 없다 (재전송) 
 *                                                          ==> return "redirect:~.do";
 *                                             *** 핵심 : 매개변수 (사용자가 요청한 데이터)
 *                                             *** 웹 : C/S (Client/Server) ==> 리턴형 (String , void)
 *                                                요청 / 응답 
 *                                                
 *                                             *** 매개변수  ?no=10 ==> (int no)
 *                                             *** [] , List , 일반 변수 (모든 데이터를 String)
 *                                               checkbox , 파일이 여러개 업로드
 *                                             *** 커맨드 객체 ==> ~VO
 *                                        @RestController : 사용자 요청 처리 / 다른 프로그램에 데이터 전송 
 *                                                          => 자바스크립트 , Kotlin 
 *                                                             Vue,Ajax,React....
 *                                                          => JSON (자바스크립트 객체 표현법)
 *                                                          => {키:값,키:값....} => 키는 멤버변수
 *                                                          => let sa={"sabun":1,"name":"홍길동"}
 *                                                          => sa.sabun , sa.name
 *                                                          => 일반 데이터 , VO단위(JSONObject) ,  List단위(JSONArray) 
 *                                                                       ======{} ======== [{},{},{}...]
 *                                                          => Spring-Boot는 자동으로 JSON
 *                                            ========== Get / Post
 *                                                Get => @GetMapping
 *                                                Post => @PostMapping
 *                                                Get+Post => @RequestMapping 
 *                                                @DeleteMapping (삭제), @PutMapping (Update) 
 *                                        @Component : 일반 클래스 (AOP,Intercepter,MainClass,~Manager)
 *                                        @Repository : DAO(데이터베이스)
 *                                        @Service : BI(DAO통합)
 *                                        @ControllerAdvice : 통합 예외처리 
 *                                        
 *                                        ==> 메모리 할당 제외 
 *                                            ~VO : 사용자 정의 데이터형 
 *                                            ~Mapper : 인터페이스 
 *         2. Setter DI 
 *            어노테이션으로 메모리 할당시 DI를 사용 할 수 없다 
 *            ------------------------------------
 *              DI)
 *                  = 일반 데이터 주입(X) => properties파일을 만들어서 사용이 가능 
 *                  = 객체 주소 주입 => @Autowired
 *                  <bean id="" class="" p:~="">
 *                  일반 변수 : p:name=""
 *                  주소값    : p:ds-ref="id명"
 *         3. 대기 
 *         --------------------- 객체 생성 (사용자가 호출시)
 *         4. 사용자가 필요한 위치에서 객체 요청 
 *         ------------------------------------------
 *         5. 객체 소멸
 *         
 *      기능 
 *       1) DI  : setterDI , constructor DI 
 *                method DI (객체 생성시 : init-method ===> 트위터 
 *                           객체 소멸시 : destory-method)
 *       2) AOP : 공통모듈 (모든 Web에서 사용) => 자동 호출
 *                ================
 *                Join Point : 첨부할 위치 
 *                  Before
 *                  After
 *                  After-Returning
 *                  After-Throwing
 *                  Around
 *                Point Cut : 메소드 대상 
 *                ================ + Advice
 *                ========================== Aspect
 *       3) MVC :                                       HandlerMapping
 *          사용자 요청  ~.do  =======> DispatcherServlet ======== @Controller,@RestController 
 *                                                             == 구분자 (GetMapping, PostMapping)
 *                                                             | 사용자가 보내준 요청데이터를 매개변수로 받을 수 있다
 *                                                             | 처리 결과값을 보낸다 
 *                                                           ViewResolver : JSP를 찾는 역할 
 *                                                               ==> 경로명/파일명 
 *                                                             |
 *                                                            JSP
 *       4) ORM (MyBatis)
 *           = XML버전이 많이 사용 
 *           = 어노테이션 버전으로 변경 
 *           = 4버전 (혼합) , 5버전(순수 자바)
 */
// MyBatis
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class SeoulDAO {
  // 스프링에서 구현된 Mapper 주소값 주입 요청 
  @Autowired
  private SeoulMapper mapper;
  
  /*
   *   @Select("SELECT no,poster,name,num "
		  +"FROM (SELECT no,poster,name,rownum as num "
		  +"FROM (SELECT no,poster,name "
		  +"FROM ${table_name} ORDER BY no ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
  */
	   public List<SeoulVO> seoulListData(Map map)
	   {
		   return mapper.seoulListData(map);
	   }
  /*   
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
  */
	   public int seoulTotalPage(Map map)
	   {
		   return mapper.seoulTotalPage(map);
	   }
	   
	/*   @Update("UPDATE ${table_name} SET "
			  +"hit=hit+1 "
			  +"WHERE no=#{no}")
	   public void hitIncrement(Map map);
	   
	   @Select("SELECT * FROM ${table_name} "
			  +"WHERE no=#{no}")
   */
	   public SeoulVO seoulDetailData(Map map)
	   {
		   mapper.hitIncrement(map);
		   return mapper.seoulDetailData(map);
	   }
  
}







