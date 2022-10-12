package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    MVC : 자바/HTML분리  => 확장성 , 재사용 (Model2)
 *    순서 
 *     USER(JSP) ======= Controller(Front Controller) ========= 위임 (요청처리)   =========== JSP로 결과값 전송 
 *                           요청 (DispatcherServlet)                Model                   Model, RedirectAttributes
 *                                                              @Controller
 *                                                              @RestController
 *     *** Annotation : 구분자 (Index)
 *     
 *     DI : 클래스와 클래스의 연관 관계 (setter,constructer) ==> 자동 처리 @Autowired
 *     AOP : 페이지에서 공통으로 사용되는 부분 (공통모듈) 
 *     인터셉트 : @RequestMapping,@GetMapping,@PostMapping 수행전 , 수행후 
 *             => 자동 ID
 *     ===================================================================
 *     forward / redirect 
 *     
 *     Rest => @GetMapping , @PostMapping , @PutMapping , @DeleteMapping
 *                                         -------------  ---------------삭제
 *                                           수정 
 *            ---------------------------- @RequestMapping
 *            Error : 405
 *            -----------
 *             <a> , sendRedirect() , location.href ==> GET
 *             <form>, ajax , axios ==> GET/POST
 *             -------------------- 전송방식을 선택이 가능 
 *             <form method="post"> <form method="get">
 *             ajax => type:'post' , type:'get'
 *             axios.get() , axios.post()
 *     사용자 요청 데이터 ====> 매개변수가 반드시 일치 
 *     a.do?name=aaa&id=admin&pwd=1234
 *          --------------------------    (String name,String id,String pwd) => (MemberVO vo)
 */
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller  // 1. 요청된 데이터를 전송 , 2. 화면 변경 
// @RestController ==> 1. 요청(출력) 데이터만 전송 (일반 데이터 , JSON)
public class MainConroller {

   @Autowired
   private LocationDAO dao;
   
   @GetMapping("/main")
   public String main_main(String page,Model model)
   {
	   // Model => 전송 객체 (request를 대신 처리)
	   /*
	    *    public void addAttribute(String key,Object obj)
	    *    {
	    *        request.setAttribute(key,obj)
	    *    }
	    */
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<LocationEntity> list=dao.locationListData((curpage*12)-12);
	   int totalpage=dao.locationToalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "main/home");
	   return "main";
   }
}






