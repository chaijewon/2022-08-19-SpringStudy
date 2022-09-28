package com.sist.web;

import org.springframework.stereotype.Controller;
/*
 *    요청 (.do) == DispatcherServlet 
 *                      |
 *                    @Controller , @RestController 
 *                    -----------------------------
 *                                | DAO,Service,Manager
 *                            ---------- Model
 *                                | ViewResolver
 *                                     | request,session
 *                                    JSP =======================> EL ${request} , ${session}
 *                    <input type="text" name="ss">
 *                    
 *                    (String ss)
 *                    
 *                    (MemberVO vo) ==> vo ==> setSs()
 */
@Controller
public class NewsController {

}
