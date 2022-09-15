package com.sist.recommand;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 루씬 
@Component
public class RecommandManager {
  public List<String> jsonParser(String json)
  {
	  List<String> list=new ArrayList<String>();
	  try
	  {
		  // {} , []
		  JSONParser jp=new JSONParser();
		  JSONObject root=(JSONObject)jp.parse(json);
		  JSONArray arr=(JSONArray)root.get("items");
		  for(int i=0;i<arr.size();i++)
		  {
			  JSONObject obj=(JSONObject)arr.get(i);
			  String desc=(String)obj.get("description");
			  list.add(desc);
		  }
	  }catch(Exception ex) {}
	  return list;
  }
  /*public static void main(String[] args) {
	 Scanner scan=new Scanner(System.in);
	 System.out.print("계절 입력(봄,여름,가을,겨울):");
	 String fd=scan.next();
	 String json=NaverDataClass.recommandData(fd);
	 List<String> jList=jsonParser(json);
	
	 FoodRecommandDAO dao=new FoodRecommandDAO();
	 List<String> list=dao.foodAllData();
	 
	 
	 
	 try
	 {
		 Pattern[] p=new Pattern[list.size()]; //[A-Z] 단어패턴 (이름)
		 
		 for(int i=0;i<p.length;i++)
		 {
			 p[i]=Pattern.compile(list.get(i));
		 }
		 
		 Matcher[] m=new Matcher[list.size()];
		 List<RecommandVO> rList=new ArrayList<RecommandVO>();
		 int[] count=new int[list.size()];
		 for(String s:jList)
		 {
			 for(int i=0;i<m.length;i++)
			 {
				 m[i]=p[i].matcher(s);
				 if(m[i].find())
				 {
					 String ss=m[i].group();
					 //System.out.println(ss);
					 //RecommandVO vo=new RecommandVO();
					 //vo.setName(ss);
					 //vo.setCount(vo.getCount()+1);
					 //rList.add(vo);
					 count[i]++;
				 }
			 }
		 }
		 // 실제 추천할 데이터 출력 
		 for(int i=0;i<list.size();i++)
		 {
			 String name=list.get(i);
			 if(count[i]>=2)
			 {
				 System.out.println(name+":"+count[i]);
			 }
		 }
	 }catch(Exception ex){}
  }*/
}









