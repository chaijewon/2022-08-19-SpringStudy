package com.sist.web.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.manager.*;
@Controller
public class SeoulController {
   @Autowired
   private LocationDAO dao;
   // [[${vo.address}]] ==> 자바스크립트에서 출력 
   
   @Autowired
   private NewsManager mgr;
   
   @GetMapping("/seoul/detail")
   public String seoul_detail(int no,Model model)
   {
	   System.out.println("detail");
	   LocationEntity vo=dao.findByNo(no);
	   String s=vo.getAddress();
	   s=s.substring(s.indexOf(" "));
	   int a=s.lastIndexOf("(");
	   if(a>=0)
	   {
	     s=s.substring(0,s.lastIndexOf("("));
	   }
	   System.out.println("addr="+s);
	   model.addAttribute("addr", s.trim());
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_content", "seoul/detail");
	   return "main";
   }
   
   @RequestMapping("/seoul/news")
   public String seoul_news(String ss,Model model)
   {
	   if(ss==null)
		   ss="서울여행";
	   String json=mgr.newsFind(ss);
	   List<NewsVO> list=new ArrayList<NewsVO>();
	   try
	   {
		   JSONParser jp=new JSONParser();
		   // { items:[{title: description},{},{}....]}
		   JSONObject root=(JSONObject)jp.parse(json);
		   JSONArray arr=(JSONArray)root.get("items");
		   for(int i=0;i<arr.size();i++)
		   {
			   JSONObject obj=(JSONObject)arr.get(i);
			   NewsVO vo=new NewsVO();
			   String desc=(String)obj.get("description");
			   desc=desc.replaceAll("[^가-힣 ]", "");
			   vo.setDescription(desc);
			   String title=(String)obj.get("title");
			   title=title.replaceAll("[^가-힣 ]", "");
			   vo.setTitle(title);
			   vo.setLink((String)obj.get("link"));
			   list.add(vo);
		   }
	   }catch(Exception ex) {}
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "seoul/news");
	   return "main";
   }
}
