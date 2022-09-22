package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainController {

	@Autowired
	private FoodDAO dao;
	// preHandle() 호출 
	@GetMapping("main/main.do")
	public String main_main(Model model)
	{
		List<CategoryVO> list=dao.foodCategoryAllData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}










