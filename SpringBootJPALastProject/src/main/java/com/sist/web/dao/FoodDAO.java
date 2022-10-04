package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.vo.CategoryEntity;
import com.sist.web.vo.FoodEntity;
import java.util.*;
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
	@Query(value="SELECT * FROM food_house "
	      +"WHERE cno=:cno",nativeQuery = true)
	public List<FoodEntity> categoryFoodListData(@Param("cno") Integer cno);
	
	public FoodEntity findByFno(int fno);
}
