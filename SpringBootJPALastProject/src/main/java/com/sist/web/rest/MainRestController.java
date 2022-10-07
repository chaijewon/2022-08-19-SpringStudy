package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
import java.util.*;
@RestController
@CrossOrigin("http://localhost:3000")
public class MainRestController {
   @Autowired
   private FoodCategoryDAO cdao;
   
   @RequestMapping("/react/main")
   // JSON 자동 변환 
   public List<CategoryEntity> react_main(String cate)
   {
	      if(cate==null)
			  cate="1";
		  int c=Integer.parseInt(cate);
		  
		  int start=0;
		  int end=0;
		  if(c==1)
		  {
			  start=0;
			  end=12;
		  }
		  else if(c==2)
		  {
			  start=12;
			  end=6;
		  }
		  else if(c==3)
		  {
			  start=18;
			  end=12;
		  }
		  
		  List<CategoryEntity> list=cdao.categoryListData(start, end);
		  return  list;
   }
}
