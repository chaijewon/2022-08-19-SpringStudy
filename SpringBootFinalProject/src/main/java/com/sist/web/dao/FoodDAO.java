package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.FoodEntity;
@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
     public List<FoodEntity> findByCno(int cno);
     // SELECT * FROM food_house WHERE cno=(매개변수)
     public FoodEntity findByFno(int fno);
     // SELECT * FROM food_house WHERE fno=(매개변수)
     // SELECT * FROM food_house WHERE name Like ''
     
}
