package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
@Controller
public class GoodsController {
   @Autowired
   private GoodsDAO dao;
   
   //  사용자 요청 => 처리 
   //  전체목록 요청 ==> GetMapping ==> if
   @GetMapping("goods/list.do")
   /*
    *   매개변수 사용 
    *     1. 사용자 보낸 데이터형 (int , String , double ....)
    *     2. Servlet이 가지고 있는 내장 객체 
    *        requset,response,session,application,pageContext....
    *        ------------------------
    *        Coookie ==> request.getCookie()
    *     3. 기타 : Error , RedirectAttributes 
    *        JSP값을 전송 
    *        ----------
    *         Model ================== forward (request)
    *         RedirectAttributes ===== sendRedirect()
    *     
    */
   public String goods_list(String page,Model model,HttpServletRequest request)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1); // (curpage*12)-11
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<GoodsVO> list=dao.goodsListData(map);
	   for(GoodsVO vo:list)
	   {
		   String name=vo.getGoods_name();
		   if(name.length()>25)
		   {
			   name=name.substring(0,25)+"...";
			   vo.setGoods_name(name);
		   }
		   vo.setGoods_name(name);
	   }
	   int totalpage=dao.goodsTotalPage();
	   
	   // cookie 
	   Cookie[] cookies=request.getCookies();
	   List<GoodsVO> cList=new ArrayList<GoodsVO>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   if(cookies[i].getName().startsWith("goods"))
			   {
				   cookies[i].setPath("/");
				   String no=cookies[i].getValue();
				   // no에 해당되는 데이터를 읽어온다
				   GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no));
				   cList.add(vo);
			   }
		   }
	   }
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   model.addAttribute("cList", cList);
	   model.addAttribute("size", cList.size());
	   return "goods/list";
   }
   // 쿠키 저장 
   @GetMapping("goods/detail_before.do")
   public String goods_detail_before(int no,HttpServletResponse response,HttpServletRequest request)
   {
		/*
		 * Cookie[] cookies=request.getCookies(); if(cookies!=null) { for(int
		 * i=0;i<cookies.length;i++) { if(cookies[i].getName().equals("goods"+no)) {
		 * cookies[i].setMaxAge(0); response.addCookie(cookies[i]); break; } } }
		 */
	   Cookie cookie=new Cookie("goods"+no, String.valueOf(no)); // 단점 (클라이언트 브라우저에 저장) 문자열만 저장이 가능 
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   response.addCookie(cookie);
	   return "redirect:detail.do?no="+no;
   }
   //  상세보기 요청 
   @GetMapping("goods/detail.do")
   public String goods_detail(int no,Model model)
   {
	   GoodsVO vo=dao.goodsDetailData(no);
	   vo.setPrice(Integer.parseInt(vo.getGoods_price().replaceAll("[^0-9]", "").trim()));
	   // 20000
	   model.addAttribute("vo", vo);
	   return "goods/detail";
   }
   
   @GetMapping("goods/cookie_delete.do")
   public String goods_cookie_delete(int no,HttpServletRequest request,HttpServletResponse response)
   {
	   Cookie[] cookies=request.getCookies();
	   for(int i=cookies.length-1;i>=0;i--)
	   {
		   if(cookies[i].getName().equals("goods"+no))
		   {
			   cookies[i].setPath("/");
			   cookies[i].setMaxAge(0);
			   response.addCookie(cookies[i]);
			   break;
		   }
	   }
	   return "redirect:list.do";
   }
   
   @GetMapping("goods/cookie_all_delete.do")
   public String goods_cookie_all_delete(HttpServletRequest request,HttpServletResponse response)
   {
	   Cookie[] cookies=request.getCookies();
	   for(int i=cookies.length-1;i>=0;i--)
	   {
		   if(cookies[i].getName().startsWith("goods"))
		   {
			   cookies[i].setPath("/");
			   cookies[i].setMaxAge(0);
			   response.addCookie(cookies[i]);
		   }
	   }
	   return "redirect:list.do";
   }
   // session 관련 
   @GetMapping("goods/cart_list.do")
   public String good_cart_list(int no,HttpSession session,Model model)
   {
	   List<CartVO> list=(List<CartVO>)session.getAttribute("cart");
	   model.addAttribute("list", list);
	   model.addAttribute("no",no);
	   return "goods/cart_list";
   }
   @PostMapping("goods/session_insert.do")
   public String goods_session_insert(int no,int account,HttpSession session,Model model)
   {
	   List<CartVO> list=(List<CartVO>)session.getAttribute("cart");
	   
	   if(list==null)
	   {
		   list=new ArrayList<CartVO>();
	   }
	   // 세션에 저장된 데이터 
	   
	   GoodsVO vo=dao.goodsDetailData(no);
	   CartVO cvo=new CartVO();
	   cvo.setNo(no);
	   cvo.setName(vo.getGoods_name());
	   cvo.setPoster(vo.getGoods_poster());
	   cvo.setPrice(vo.getGoods_price());
	   cvo.setAccount(account);
	   
	   boolean bCheck=false;
	   for(CartVO avo:list)
	   {
		   if(avo.getNo()==cvo.getNo())
		   {
			   int acc=avo.getAccount()+cvo.getAccount();
			   avo.setAccount(acc);
			   bCheck=true;
			   break;
		   }
	   }
	   if(bCheck==false)
	   {
		   list.add(cvo);
		   session.setAttribute("cart", list);
	   }
	    
	   return "redirect:cart_list.do?no="+no;
   }
   
   @GetMapping("goods/cart_cancel.do")
   public String goods_cart_cancel(int no,HttpSession session)
   {
	   /*
	    *    rd.forward(request,esponse) ==> jsp파일 지정 
	    *    sendRedirect("cart_list.do"); => request가 초기화 .do
	    */
	   List<CartVO> list=(List<CartVO>)session.getAttribute("cart");
	   for(int i=0;i<list.size();i++)
	   {
		   CartVO vo=list.get(i);
		   if(vo.getNo()==no)
		   {
			   list.remove(i);
			   break;
		   }
	   }
	   return "redirect:cart_list.do?no="+no;
   }
   
   @GetMapping("goods/cart_total_delete.do")
   public String cart_total_delete(int no,HttpSession session)
   {
	   session.removeAttribute("cart");
	   return "redirect:cart_list.do?no="+no;
   }
   
}









