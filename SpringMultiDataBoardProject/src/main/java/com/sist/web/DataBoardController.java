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

import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URLEncoder;

import org.snu.ids.ha.index.*;
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
	  System.out.println("1111111");
	  List<MultipartFile> list=vo.getFiles();
	  System.out.println("size:"+list.size());
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
			  System.out.println(temp1);
			  System.out.println(temp2);
			  vo.setFilename(temp1);
			  vo.setFilesize(temp2);
			  vo.setFilecount(list.size());
		  }
		  dao.boardInsert(vo);
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  return "redirect:list.do";
  }
  
  @GetMapping("detail.do")
  // 파일명(크기 bytes)
  public String databoard_detail(int no,Model model)
  {
	  //DAO연동 ==> 다운로드 
	  DataBoardVO vo=dao.databoardDetailData(no);
	  model.addAttribute("vo", vo);
	  
	  if(vo.getFilecount()!=0) // 업로드된 파일이 있는 경우에만 전송 
	  {
	     List<String> fList=new ArrayList<String>();
	     List<String> sList=new ArrayList<String>();
	     StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
	     while(st.hasMoreTokens())
	     {
	    	 fList.add(st.nextToken());
	     }
	     
	     st=new StringTokenizer(vo.getFilesize(),",");
	     while(st.hasMoreTokens())
	     {
	    	 sList.add(st.nextToken());
	     }
	     
	     model.addAttribute("fList", fList);
	     model.addAttribute("sList", sList);
	  }
	  
	  String data=vo.getContent();
	  data=data.replaceAll("[0-9]", "");
	  data=data.replaceAll("[a-zA-Z]", "");
	  KeywordExtractor ke=new KeywordExtractor(); // R
	  KeywordList kl=ke.extractKeyword(data, true);
	  List<DataVO> list=new ArrayList<DataVO>();
	  for(int i=0;i<kl.size();i++)
	  {
		  Keyword kwrd=kl.get(i);
		  if(kwrd.getCnt()>1)
		  {
			  DataVO dvo=new DataVO();
			  dvo.setWord(kwrd.getString());
			  dvo.setCount(kwrd.getCnt());
			  list.add(dvo);
		  }
	  }
	  model.addAttribute("list", list);
	  return "databoard/detail";
  }
  /*
   *    Model ==> @Controller , @RestController 
   *    ----------------------------------------
   *    1. 매개변수 
   *        사용자 전송값  ==> ?page=1 , ?no=1
   *        form에서 전송된 데이터 => VO, String[]
   *        스프링에서 제공하는 내장 객체 
   *    2. 리턴형 : String , void
   *    3. 파일 => redirect: (sendRedirect) , 경로/파일 (forward)
   *               => request를 초기화 : 재전송     => JSP request전송 
   */
  @GetMapping("download.do")
  public void databoard_download(String fn,HttpServletResponse response)
  {
	  try
	  {
		  File file=new File("c:\\download\\"+fn);
		  response.setContentLength((int)file.length());
		  response.setHeader("Content-Disposition", "attachment;filename="
				                     +URLEncoder.encode(fn,"UTF-8"));
		  // 다운로드창을 보여준다 
		  BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));//서버
		  BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());//클라이언트 
		  byte[] buffer=new byte[1024];
		  int i=0; //읽은 바이트수 
		  while((i=bis.read(buffer,0, 1024))!=-1) //-1 (EOF)
		  {
			  bos.write(buffer, 0, i);
		  }
		  
		  bis.close();
		  bos.close();
		  
	  }catch(Exception ex){}
  }
  // 수정하기 
  @GetMapping("update.do")
  public String databoard_update(int no,Model model)
  {
	  DataBoardVO vo=dao.databoardUpdateData(no);
	  model.addAttribute("vo", vo);
	  return "databoard/update";
  }
  // 삭제하기 
}








