package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@RestController
// 데이터 전송 == JSON (JSONP,클로저) => async axios.get() await
public class BoardRestController {
     @Autowired
     private BoardDAO dao;
     //VueJS에서 전송 
     @GetMapping(value = "board/list_vue.do",produces = "text/plain;charset=utf-8")
     public String board_list_vue(String page)
     {
    	 if(page==null)
    		 page="1";
    	 int curpage=Integer.parseInt(page);
    	 Map map=new HashMap();
    	 int rowSize=10;
    	 int start=(rowSize*curpage)-(rowSize-1);
    	 int end=rowSize*curpage;
    	 
    	 map.put("start", start);
    	 map.put("end", end);
    	 
    	 List<BoardVO> list=dao.boardListData(map);
    	 int totalpage=dao.boardToalPage();
    	 
    	 // JavaScript로 데이터를 전송 
    	 /*
    	  *   List ==> Array ==> []  ====> JSONArray
    	  *   VO   ==> Object ==> {}  ===> JSONObject
    	  *   
    	  *   [{no:1,name:'',subject:''...},{},{},{},{}....]
    	  */
    	 String result="";
    	 try
    	 {
    		 JSONArray arr=new JSONArray();
    		 int k=0;
    		 for(BoardVO vo:list)
    		 {
    			 JSONObject obj=new JSONObject();
    			 obj.put("no", vo.getNo());
    			 obj.put("subject", vo.getSubject());
    			 obj.put("name", vo.getName());
    			 obj.put("dbday", vo.getDbday());
    			 obj.put("hit", vo.getHit());
    			 if(k==0)
    			 {
    				 obj.put("curpage", curpage);
        			 obj.put("totalpage", totalpage);
    			 }
    			 arr.add(obj);
    			 k++;
    		 }
    		 result=arr.toJSONString();
    	 }catch(Exception ex){}
    	 return result;
    	 
     }
     @GetMapping(value="board/insert_vue.do",produces = "text/plain;charset=utf-8")
     public String board_insert_vue(BoardVO vo)
     {
    	 dao.boardInsert(vo);
    	 return "OK";
     }
     @GetMapping(value="board/detail_vue.do",produces = "text/plain;charset=utf-8")
     public String board_detail_vue(int no)
     {
    	 String result="";
    	 BoardVO vo=dao.boardDetailData(no);
    	 JSONObject obj=new JSONObject();
    	 obj.put("no", vo.getNo());
    	 obj.put("name", vo.getName());
    	 obj.put("subject", vo.getSubject());
    	 obj.put("content", vo.getContent());
    	 obj.put("dbday", vo.getDbday());
    	 obj.put("hit", vo.getHit());
    	 result=obj.toJSONString();
    	 return result;
     }
     
}










