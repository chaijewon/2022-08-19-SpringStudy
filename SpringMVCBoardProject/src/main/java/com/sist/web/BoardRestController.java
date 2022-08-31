package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// JavaScript , 일반 데이터 , JSON
// update.do , update_ok.do(X) ==> Boot 
import com.sist.dao.*;
@RestController
public class BoardRestController {
    @Autowired
    private BoardDAO dao;
    /*
     *   HTML (JavaScript) : text/html
     *   JSON              : text/plain
     */
    @PostMapping(value="board/update_ok.do",produces = "text/html;charset=UTF-8")
    // 단점 => 크롬에서만 사용이 가능 
    public String board_update_ok(BoardVO vo)
    {
    	// 자바 스크립트 전송 
    	String result="";
    	boolean bCheck=dao.boardUpdate(vo);
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
    		//result="redirect:detail.do?no="+vo.getNo();
    	}
    	return result;
    }
}










