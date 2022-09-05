package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class SeoulController {
    @Autowired
    private SeoulDAO dao;
    
    @GetMapping("seoul/nature.do")
    public String seoul_nature(Model model)
    {
    	List<SeoulVO> list=dao.natureData();
    	model.addAttribute("list", list);
    	model.addAttribute("main_jsp", "../main/home.jsp");
    	return "main/main";
    }
    
    @GetMapping("seoul/hotel.do")
    public String seoul_hotel(Model model)
    {
    	List<SeoulVO> list=dao.hotelData();
    	model.addAttribute("list", list);
    	model.addAttribute("main_jsp", "../main/home.jsp");
    	return "main/main";
    }
    
    @GetMapping("seoul/shop.do")
    public String seoul_shop(Model model)
    {
    	List<SeoulVO> list=dao.shopData();
    	model.addAttribute("list", list);
    	model.addAttribute("main_jsp", "../main/home.jsp");
    	return "main/main";
    }
    
    @GetMapping("seoul/guest.do")
    public String seoul_guest(Model model)
    {
    	List<SeoulVO> list=dao.guestData();
    	model.addAttribute("list", list);
    	model.addAttribute("main_jsp", "../main/home.jsp");
    	return "main/main";
    }
}
