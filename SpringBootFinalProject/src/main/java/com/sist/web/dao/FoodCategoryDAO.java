package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.FoodCategoryEntity;
// *** <> 제네릭스 (형변환을 자동) ==> 클래스형 (Wrapper) => 형변환 , 데이터형의 기능을 쉽게 사용 (메소드)
@Repository
public interface FoodCategoryDAO extends JpaRepository<FoodCategoryEntity, Integer>{
   @Query(value="SELECT * FROM food_category "
		 +"ORDER BY cno ASC "
		 +"LIMIT :start,:end",nativeQuery = true)
   public List<FoodCategoryEntity> foodCategoryListData(@Param("start") Integer start,@Param("end") Integer end);
   
   public FoodCategoryEntity findByCno(int cno);
}
