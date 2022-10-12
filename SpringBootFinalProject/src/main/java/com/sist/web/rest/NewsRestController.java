package com.sist.web.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.manager.*;
import java.util.*;
/*
 *   "items":[ 
 *   { "title":"로엘 보스 블렌더, 김장 위한 믹서기 가을맞이 후기 이벤트 진행", 
 *   "originallink":"http:\/\/www.ksilbo.co.kr\/news\/articleView.html?idxno=949338", 
 *   "link":"http:\/\/www.ksilbo.co.kr\/news\/articleView.html?idxno=949338", 
 *   "description":"다양한 레시피<\/b>로 활용할 수 있다. 이와 함께 2가지 종류의 용기를 제공해 상황에 맞는 8가지 블렌딩 모드로 용도별로 안전하게 사용할 수 있다. 8가지 레시피<\/b>로는 분쇄, 쉐이크, 스무디, 진공믹서, 스튜, 수프 등이 있다.... ", "pubDate":"Tue, 11 Oct 2022 14:10:00 +0900" }, { "title":"윤통섭 비전세미콘 대표 "대전·세종기반 세계적 기업 도약할 것""
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class NewsRestController {
   @Autowired
   private NewsManager mgr;
   
   @GetMapping("/news/find_react")
   public List<NewsVO> newsFindData(String ss)
   {
	   List<NewsVO> list=new ArrayList<NewsVO>();
	   try
	   {
	     String json=mgr.newsFind(ss);
	     JSONParser jp=new JSONParser();
	     JSONObject root=(JSONObject)jp.parse(json);
	     JSONArray arr=(JSONArray)root.get("items");
	     for(int i=0;i<arr.size();i++)
	     {
	    	 JSONObject obj=(JSONObject)arr.get(i);
	    	 String title=(String)obj.get("title");
	    	 String description=(String)obj.get("description");
	    	 String link=(String)obj.get("link");
	    	 NewsVO vo=new NewsVO();
	    	 vo.setTitle(title);
	    	 vo.setDescription(description);
	    	 vo.setLink(link);
	    	 list.add(vo);
	     }
	   }catch(Exception ex){}
	   
	   return list;
	   
	//   {} => JSONObject
	 //  [] => JSONArray
   }
  /* @GetMapping("/news/find")
   public String newsFindData(String ss)
   {
	   ss="레시피";
	   String json="";
	   try
	   {
	     json=mgr.newsFind(ss);
	     //JSONParser jp=new JSONParser();
	     //JSONObject root=(JSONObject)jp.parse(json);
	     
	   }catch(Exception ex){}
	   
	   return json;
   }*/
}
