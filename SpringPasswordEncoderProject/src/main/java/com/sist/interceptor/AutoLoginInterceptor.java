package com.sist.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 *    .do  ==> DispatcherServlet ==> 인터셉트 (preHandle()) ===> @GetMapping() ===> 인터셉트(postHandle())
 *         ==> ViewResolver  =====> JSP
 *                           request
 */
public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
    // 자동 로그인 처리 , Update...
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		/*
		 * String sid=(String)session.getAttribute("id"); if(sid!=null) {
		 * session.invalidate(); }
		 */
		Cookie[] cookies=request.getCookies();
		String id="",name="",role="";
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				String temp=cookies[i].getName();
				if(temp!=null)
				{
					if(cookies[i].getName().equals("id"))
					{
						id=cookies[i].getValue();
					}
					if(cookies[i].getName().equals("name"))
					{
						name=cookies[i].getValue();
					}
					if(cookies[i].getName().equals("role"))
					{
						role=cookies[i].getValue();
					}
					
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("role", role);
					
					//response.sendRedirect("../main/main.do");
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
   
}
