package com.sist.web;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/*
 *    매개변수 : 내장 객체 사용 
 *            ------------ request,response,session,application,config,out....
 *            기타 : 사용자가 보내준 데이터 
 *                 ----------------- VO단위 (커맨드객체) 
 *                 ----------------- 각 데이터형으로 받을 지 여부 확인 
 *                 *** 순서는 없다 
 *                 *** request를 사용하지 않는 경우 : Model (전송 객체 이용)
 *     리턴형 : String , void 
 *            ------ 90% (값을 받아서 출력하는 JSP를 설정) : forward
 *            ------ 재전송 : redirect:~  : sendRedirect
 *            void : ajax , 다운로드 , axios(Vue,React) ....
 */
@Controller
public class MainController {
  @GetMapping("main/input")
  public String main_input()
  {
	  return "main/input";
  }
  // no=1&name=홍길동&avg=10.5&isadmin=true
  @GetMapping("main/output.do")
  //  ============> String no , String name, String avg , String isadmin => 데이터형이 다른 경우 (400)
  /*
   *     String page=request.getParameter("page");
   *     if(page==null)
   *         page="1";
   *     int curpage=Integer.parseInt(page);
   */
  // 400, 405 , 404 , 500 ==> 18~19page
  public String main_output(int no,String name,double avg,boolean isadmin,Model model)
  {
	  model.addAttribute("no", no);
	  model.addAttribute("name", name);
	  model.addAttribute("avg", avg);
	  model.addAttribute("isadmin", isadmin);
	  return "main/output";  
  }
  // 405 – 허용되지 않는 메소드
  @PostMapping("main/output1.do")
  public String main_output1(String id,String pwd,Model model)
  {
	  return "main/output1";
  }
}








