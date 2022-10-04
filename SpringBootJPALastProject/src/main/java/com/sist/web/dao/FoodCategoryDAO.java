package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.CategoryEntity;
/*
 *   SpringFramework => Mybatis => JSP (JSTL,EL)  ==> SM
 *   Spring-Boot  => JPA => HTML(ThymeLeaf,EL)  ==> 차세대 개발 
 *   ========================================================
 *      Model : 전송 객체 
 */
@Repository
public interface FoodCategoryDAO extends JpaRepository<CategoryEntity, Integer>{
    @Query(value="SELECT cno,title,poster,link,subject "
    	  +"FROM food_category "
    	  +"LIMIT :start,:end",nativeQuery = true)
    // LIMIT ==> 0  , rownum ==> 1
    public List<CategoryEntity> categoryListData(@Param("start") Integer start,@Param("end") Integer end);
}
