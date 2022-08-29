package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
/*
 *   모델 제작 (요청에 처리)
 *   
 *   사용자 요청 ============= DispatcherServlet  ============ HandlerMapping 
 *                                                             | Model클래스를 찾아 준다 (요청처리=프로그래머)
 *                               |
 *                           ViewResolver (경로명 , 확장자)
 *                           ============= View(JSP) : 화면 출력 
 *                           
 *   1. @Controller : Model을 못찾거나 (404) 일 경우
 *                    @Controller유무 확인 
 *                    return => 설정된 JSP가 있는 확인 
 *   2. 요청 처리에 필요한 모든 객체를 스프링으로 받아서 저장 
 *      ======================================= @Autowired
 *   3. 요청 URI를 받는다 => 405
 *      @RequestMapping 
 *      @GetMapping
 *      @PostMapping
 *   4. 요청 처리 메소드를 만든다 
 *      ==================
 *        1) 리턴형 (String) , void 
 *        2) 매개변수 (사용자 보내준 모든 데이터형 처리) , VO단위 , List단위 , []단위 
 *           ========================================================= 내장 객체를 요청 
 *                          request,response,session,Model,RedirectAttributes
 *        3) 매개변수로 등록된 모든 데이터는 DispatcherServlet에서 값을 주입해준다 
 *        4) 순서는 관계없다 
 *        5) 잘못된 데이터형을 입력했을 경우 => 400
 *   ========================== spring-boot
 */
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   // 필요한 객체를 멤버로 생성해서 주소값을 받는다 
   // 스프링에서 생성된 객체를 받아서 사용 => 자동으로 주소값을 얻어 온다 
   @GetMapping("food/list.do")
   public String food_list(String page,Model model)
   {
	   //                  ============
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<FoodVO> list=dao.foodListData(map);
	   int totalpage=dao.foodTotalPage();
	   ////////////////////////////////////////////////////////
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("list", list);
	   model.addAttribute("totalpage", totalpage);
	   ///////////////////////////////////////////////////////
	   return "list";
   }
   // detail.do?fno=${vo.fno }
   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model)
   {
	   FoodVO vo=dao.foodDetailData(fno);
	   model.addAttribute("vo", vo);
	   return "detail";
   }
   
   @GetMapping("food/find.do")
   public String food_find()
   {
	  
	   return "find";
   }
   
}












