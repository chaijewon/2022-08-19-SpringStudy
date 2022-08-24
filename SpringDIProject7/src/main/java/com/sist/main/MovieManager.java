package com.sist.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;



import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import java.io.*;
import java.net.*;
@Component
/*
 *   searchMainDailyBoxOffice.do 일일박스오피스
 *   searchMainRealTicket.do  실시간 예매율
 *   searchMainDailySeatTicket.do 좌석 점유율
 *   searchMainOnlineDailyBoxOffice.do 온라인 상영관
 *   
 *   https://www.kobis.or.kr/kobis/business/main/main.do
 *   
 *   [{},{},{}...] [] => List(배열)
 *    --- VO(JSON)
 */
public class MovieManager {
   public static void main(String[] args) {
	   MovieManager m=new MovieManager();
	   m.movieListData(1);
   }
   public List<MovieVO> movieListData(int no)
   {
	   List<MovieVO> list=new ArrayList<MovieVO>();
	   try
	   {
		   String strUrl="";
		   if(no==1)
			   strUrl="https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do";
		   else if(no==2)
			   strUrl="https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do";
		   else if(no==3)
			   strUrl="https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do";
		   else if(no==4)
			   strUrl="https://www.kobis.or.kr/kobis/business/main/searchMainOnlineDailyBoxOffice.do";
		   
		   //System.out.println(strUrl);
		   URL url=new URL(strUrl);
		   HttpURLConnection conn=(HttpURLConnection)url.openConnection(); // 웹 사이트 연결 
		   StringBuffer sb=new StringBuffer();
		   if(conn!=null) // 연결되었다면
		   {
			   BufferedReader in=
					   new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			   while(true)
			   {
				   String data=in.readLine();
				   if(data==null)
					   break;
				   //System.out.println(data);
				   sb.append(data);
			   }
			   in.close();
			   
		   }
		   System.out.println(sb.toString());
		   /*
		    *   {
		    *   "movieNm":"헌트",
		    *   
                "director":"이정재",
                
                "genre":"액션,드라마",
                "watchGradeNm":"15세이상관람가",
                
                [{},{}] => [] JSONArray
                           {} JSONObject
                
		    */
		   String json=sb.toString();
		   JSONParser jp=new JSONParser();
		   JSONArray arr=(JSONArray)jp.parse(json);
		   for(int i=0;i<arr.size();i++)
		   {
			   JSONObject obj=(JSONObject)arr.get(i);
			   System.out.println("제목:"+obj.get("movieNm"));
			   System.out.println("장르:"+obj.get("genre"));
			   System.out.println("등급:"+obj.get("watchGradeNm"));
			   System.out.println("감독:"+obj.get("director"));
			   System.out.println("===============================================");
			   MovieVO vo=new MovieVO();
			   vo.setTitle((String)obj.get("movieNm"));
			   vo.setGenre((String)obj.get("genre"));
			   vo.setGrade((String)obj.get("watchGradeNm"));
			   vo.setDirector((String)obj.get("director"));
			   list.add(vo);
			   
		   }
	   }catch(Exception ex){}
	   return list;
   }
}








