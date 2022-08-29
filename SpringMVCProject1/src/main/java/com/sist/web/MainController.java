package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 모델 알림 
@Controller
@RequestMapping("main/") // 경로명 중복을 제거 
public class MainController {
	@RequestMapping("input.do")
	public String main_input(HttpServletRequest request,HttpServletResponse response)
	{
		return "main/input";
	}
    @RequestMapping("output.do")
    public String main_output(HttpServletRequest request,HttpServletResponse response)
    {
    	try
    	{
    		request.setCharacterEncoding("UTF-8");
    	}catch(Exception ex) {}
    	String name=request.getParameter("name");
    	String sex=request.getParameter("sex");
    	String loc=request.getParameter("loc");
    	String content=request.getParameter("content");
    	String[] hobby=request.getParameterValues("hobby");
    	
    	request.setAttribute("name", name);
    	request.setAttribute("sex", sex);
    	request.setAttribute("loc", loc);
    	request.setAttribute("content", content);
    	request.setAttribute("hobby", hobby);
    	return "main/output"; //.jsp를 생략한다 
    }
    @RequestMapping("output1.do") //.do는 처리 (요청 처리)
    public String main_output1(String name,String sex,String loc , String content,String[] hobby,Model model)
    {
    	// Model ==> 데이터 전송 객체 (request가 첨부)
    	// request를 사용하지 않고 매개변수를 이용해서 데이터를 DispatcherServlet으로부터 받을 수 있다 
    	// request,response는 사용하지 않고 => 매개변수를 이용해서 데이터값을 받는다 
    	/*
    	 *   request 사용   ====> Cookie 
    	 *   response 사용 ====> 파일 업로드 , Cookie 
    	 */
    	model.addAttribute("name", name); // request.setAttribute("name", name)
    	/*
    	 *    public void addAttribute(String key,Object obj)
    	 *    {
    	 *        request.setAttribute(key, obj);
    	 *    }
    	 */
    	// ==> 주로 매개변수를 이용한다 
    	model.addAttribute("sex", sex);
    	model.addAttribute("loc", loc);
    	model.addAttribute("content", content);
    	model.addAttribute("hobby", hobby);
    	return "main/output"; // 요청 처리에 대한 결과값 받기
    }
    @RequestMapping("output2.do")
    // 주의점 => 커맨드 객체 => 가장 만이 사용한다
    public String main_output2(MemberVO vo,Model model)
    {
    	model.addAttribute("vo", vo);
    	return "main/output1";
    }
    
    /*
     *   Spring 4.3 
     *   =========== 구분 
     *   @RequestMapping ==> GET/POST 동시에 처리 (검색,페이징)
     *      = @GetMapping ==> GET
     *      = @PostMapping ==> POST
     */
}












