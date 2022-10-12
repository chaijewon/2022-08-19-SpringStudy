package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
// Rest 
// 1차 > 2차 > 3차 
@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeRestController {
   @Autowired
   private RecipeDAO dao;
   // axios.get = @GetMapping
   // axios.post = @PostMapping
   @GetMapping("recipe/find_react")
   public List<RecipeEntity> recipeFindData(String ss,int page)
   {
	   List<RecipeEntity> list=new ArrayList<RecipeEntity>();
	   int rowSize=12;
	   int start=(rowSize*page)-rowSize;
	   list=dao.recipeFindData(ss, start);
	   for(RecipeEntity vo:list)
	   {
		   String title=vo.getTitle();
		   if(title.length()>27)
		   {
			   title=title.substring(0,27)+"...";
			   vo.setTitle(title);
		   }
		   vo.setTitle(title);
	   }
	   return list;
   }
   
   @GetMapping("/recipe/find_totalpage")
   public int recipeFindTotalPage(String ss)
   {
	   int total=dao.recipeTotalPage(ss);
	   return total;
   }
}
