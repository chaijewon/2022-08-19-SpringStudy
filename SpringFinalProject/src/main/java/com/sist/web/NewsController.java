package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    요청 (.do) == DispatcherServlet 
 *                      |
 *                    @Controller , @RestController 
 *                    -----------------------------
 *                                | DAO,Service,Manager
 *                            ---------- Model
 *                                | ViewResolver
 *                                     | request,session
 *                                    JSP =======================> EL ${request} , ${session}
 *                    <input type="text" name="ss">
 *                    
 *                    (String ss)
 *                    
 *                    (MemberVO vo) ==> vo ==> setSs()
 *                    
 *                    => GET/POST 
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.manager.NewsManager;
import com.sist.vo.NewsVO;

import java.util.*;
@Controller
public class NewsController {
   @Autowired
   private NewsManager mgr;
   
   @RequestMapping("news/find.do")
   public String news_find(String ss,Model model)
   {
	   // 전송 객체 / forward : Model (request), redirect : RedirectAttributes
	   // return "경로명/파일명" => "main/main"  , "redirect:"
	   if(ss==null)
		   ss="상품";
	   
	   String json=mgr.newsFind(ss);
	   try
	   {
		   /*
		    *    {items:[{},{},{},{},{}...]} => JSONOject
		    *           ===================
		    *             JSONArray
		    */
		   JSONParser jp=new JSONParser();
		   JSONObject root=(JSONObject)jp.parse(json); // []=> JSONArray , {}=>JSONObject
		   JSONArray arr=(JSONArray)root.get("items");
		   List<NewsVO> list=new ArrayList<NewsVO>();
		   for(int i=0;i<arr.size();i++)
		   {
			   NewsVO vo=new NewsVO();
			   JSONObject obj=(JSONObject)arr.get(i);
			   vo.setTitle((String)obj.get("title"));
			   vo.setLink((String)obj.get("link"));
			   vo.setDescription((String)obj.get("description"));
			   list.add(vo);
		   }
		   model.addAttribute("list", list);
		   
	   }catch(Exception ex){}
	   model.addAttribute("main_jsp", "../news/find.jsp");
	   return "main/main";
   }
}







