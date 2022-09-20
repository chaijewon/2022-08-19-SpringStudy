package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.vo.*;
// 자바스크립트로 값 전송 
@RestController
public class SeoulRestController {
    @Autowired
    private SeoulDAO sDao;
    
    @GetMapping(value="seoul/list_vue.do",produces = "text/plain;charset=utf-8")
    // text/html (Ajax) , text/xml (XML), text/plain (JSON)
    public String seoul_list_vue(String page,String type,Model model)
    {
 	   if(page==null)
 		   page="1";
 	   if(type==null)
 		   type="1";
 	   
 	   int index=Integer.parseInt(type);
 	   String[] table_name={"","seoul_location","seoul_nature","seoul_shop"};
 	   
 	   int curpage=Integer.parseInt(page);
 	   Map map=new HashMap();
 	   int rowSize=12;
 	   int start=(rowSize*curpage)-(rowSize-1);
 	   int end=rowSize*curpage;
 	   
 	   map.put("start", start);
 	   map.put("end", end);
 	   map.put("table_name", table_name[index]);
 	   
 	   List<SeoulVO> list=sDao.seoulListData(map);
 	   int totalpage=sDao.seoulTotalPage(map);
 	   
 	   String result="";
 	   JSONArray arr=new JSONArray();//[] => {no,poster,title,curpage,totalpage},{no,poster,title}.....
 	   int k=0;
 	   for(SeoulVO vo:list)
 	   {
 		   JSONObject obj=new JSONObject();
 		   obj.put("no", vo.getNo());
 		   obj.put("title", vo.getTitle());
 		   obj.put("poster", vo.getPoster());
 		   
 		   if(k==0)
 		   {
 			   obj.put("curpage", curpage);
 	 		   obj.put("totalpage", totalpage);
 	 		   obj.put("type", type);
 		   }
 		   
 		   arr.add(obj);
 		   k++;
 	   }
 	   result=arr.toJSONString();
 	   return result;
    }
    
    @GetMapping(value="seoul/detail_vue.do",produces = "text/plain;charset=utf-8")
    public String seoul_detail_vue(int no,int type)
    {
    	String result="";
    	try
    	{
    		String[] table_name={"","seoul_location","seoul_nature","seoul_shop"};
    		Map map=new HashMap();
    		map.put("table_name", table_name[type]);
    		map.put("no", no);
    		
    		SeoulVO vo=sDao.seoulDetailData(map);
    		
    		JSONObject obj=new JSONObject();
    		obj.put("no",vo.getNo());
    		obj.put("title",vo.getTitle());
    		obj.put("address",vo.getAddress().substring(vo.getAddress().indexOf(" ")).trim());
    		obj.put("msg",vo.getMsg());
    		obj.put("poster",vo.getPoster());
    		
    		result=obj.toJSONString();
    		
    	}catch(Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    	return result;
    }
    
    @GetMapping(value="seoul/cook_list.do" , produces = "text/plain;charset=utf-8")
    public String seoul_cook_list(String type,HttpServletRequest request)
    {
    	if(type==null)
    	{
    		type="1";
    	}
    	int t=Integer.parseInt(type);
    	String[] cook_name={"","location","nature","shop"};
    	String result="";
    	Cookie[] cookies=request.getCookies();
    	List<SeoulVO> list=new ArrayList<SeoulVO>();
    	if(cookies!=null)
    	{
    		for(int i=cookies.length-1;i>=0;i--)
    		{
    			if(cookies[i].getName().startsWith(cook_name[t]))
    			{
    				Map map=new HashMap();
    				String no=cookies[i].getValue();
    				map.put("no", no);
    				map.put("table_name", "seoul_"+cook_name[t]);
    				SeoulVO vo=sDao.seoulDetailData(map);
    				list.add(vo);
    			}
    		}
    	}
    	// list => JSON
    	return result;
    }
    // 로그인 처리 
    @GetMapping(value="member/login_vue.do",produces = "text/plain;charset=utf-8")
    public String login_vue(String id,String pwd)
    {
    	String result="";
    	
    	return result;
    }
}









