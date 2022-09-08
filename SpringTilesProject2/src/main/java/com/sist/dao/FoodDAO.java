package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.CategoryVO;
@Repository
public class FoodDAO {
   // 스프링에서 구현된 Mapper를 가지고 온다 
   @Autowired
   private FoodMapper mapper;
   
   public List<CategoryVO> categoryListData(Map map)
   {
	   return mapper.categoryListData(map);
   }
}
