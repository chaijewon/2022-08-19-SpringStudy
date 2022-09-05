package com.sist.web;

import java.io.File;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.DataBoardVO;
import com.sist.dao.DataBoardDAO;
// 파일명(X) => JavaScript , JSON , 일반데이터 전송 ==> Ajax , VueJS , React , Redux , Kotlin
@RestController  // @ResponseBody => 승격 (클래스형 변경) => RestFul
// OpenApi 
public class DataBoardRestController {
   @Autowired
   private DataBoardDAO dao;
   
   @PostMapping(value="databoard/update_ok.do",produces = "text/html;charset=UTF-8")
   public String databoard_update_ok(DataBoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.databoardUpdate(vo);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"detail.do?no="+vo.getNo()+"\";"
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @PostMapping(value="databoard/delete_ok.do",produces = "text/html;charset=utf-8")
   public String databoard_delete_ok(int no,String pwd)
   {
	   String result="";
	   DataBoardVO vo=dao.databoardInfoData(no);
	   boolean bCheck=dao.databoardDelete(no, pwd);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"list.do\";"
				 +"</script>";
		   
		   try
		   {
			   if(vo.getFilecount()>0)
			   {
				   StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
				   while(st.hasMoreTokens())
				   {
					   File file=new File("c:\\download\\"+st.nextToken());
					   file.delete();
				   }
			   }
		   }catch(Exception ex){}
	   }
	   else
	   {
		     result="<script>"
					 +"alert(\"비밀번호가 틀립니다!!\");"
					 +"history.back();"
					 +"</script>";
	   }
	   return result;
   }
}










