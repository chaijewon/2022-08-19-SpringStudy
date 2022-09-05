package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    Model 
 *    DAO
 *    Service 
 *    ====================== singleton
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
import java.util.*;
import java.io.*;
@Controller
@RequestMapping("databoard/") // 공통으로 적용되는 URI주소를 설정 
public class DataBoardController {
  @Autowired
  private DataBoardDAO dao;
  
  @GetMapping("list.do")
  public String databoard_list(String page,Model model)
  {
	  //Model 전송 객체 ==> request를 list.jsp로 전송 (가급적이면 request를 사용하지 않는다 (request안에 IP)
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  // 해당페이지의 데이터값 
	  Map map=new HashMap();
	  int rowSize=10;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  List<DataBoardVO> list=dao.boardListData(map);
	  // 총페이지 
	  int totalpage=dao.boardTotalPage();
	  // list.jsp로 받은 데이터 전송 ==> 화면에 출력
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  /*
	   *   서버 프로그램 : 소켓 (C언어) 
	   *   ***웹 프로그램 
	   *   모바일 프로그램 : Kotlin,스위프트
	   *   인공지능 프로그램 : 알고리즘 ,AL==> 데이터분석 (파이썬)
	   *   데이터베이스 프로그램 : 오라클 (어드민) => ERP
	   */
	  return "databoard/list";
  }
  
  @GetMapping("insert.do")
  public String databoard_insert()
  {
	  return "databoard/insert";
  }
  
  @PostMapping("insert_ok.do")
  public String databoard_insert_ok(DataBoardVO vo)
  {
	  List<MultipartFile> list=vo.getFiles();
	  String path="c:\\download\\";
	  try
	  {
		  if(list==null) // 업로드가 안된 경우 
		  {
			  vo.setFilename("");
			  vo.setFilesize("");
			  vo.setFilecount(0);
		  }
		  else // 업로드가 된 상태 
		  {
			  String temp1="";
			  String temp2="";
			  for(MultipartFile mf:list)
			  {
				  String filename=mf.getOriginalFilename();//사용자가 선택한 파일명
				  mf.transferTo(new File(path+filename));
				  // 업로드 
				  temp1+=filename+",";
				  File f=new File(path+filename);
				  long len=f.length();
				  temp2+=len+",";
			  }
			  temp1=temp1.substring(0,temp1.lastIndexOf(","));
			  temp2=temp2.substring(0,temp2.lastIndexOf(","));
			  vo.setFilename(temp1);
			  vo.setFilesize(temp2);
			  vo.setFilecount(list.size());
		  }
		  
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  return "redirect:list.do";
  }
}








