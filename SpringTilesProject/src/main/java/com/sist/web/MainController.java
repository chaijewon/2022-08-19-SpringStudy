package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
  @RequestMapping("main/main.do")
  public String main_main()
  {
	  return "main";
  }
  @RequestMapping("main/main2.do")
  public String main_main2()
  {
	  return "main2";
  }
  @RequestMapping("mypage/mypage.do")
  public String mypage()
  {
	  return "mypage/mypage";
  }
}
