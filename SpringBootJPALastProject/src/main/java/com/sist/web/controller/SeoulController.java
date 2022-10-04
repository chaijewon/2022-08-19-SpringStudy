package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {
   @GetMapping("/seoul/location")
   public String seoul_location(Model model)
   {
	   model.addAttribute("main_content", "seoul/location");
	   return "main";
   }
   @GetMapping("/seoul/nature")
   public String seoul_nature(Model model)
   {
	   model.addAttribute("main_content", "seoul/nature");
	   return "main";
   }
   @GetMapping("/seoul/shop")
   public String seoul_shop(Model model)
   {
	   model.addAttribute("main_content", "seoul/shop");
	   return "main";
   }
}
