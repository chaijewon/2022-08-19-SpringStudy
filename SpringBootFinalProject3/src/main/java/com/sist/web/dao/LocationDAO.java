package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
@Repository 
public interface LocationDAO extends JpaRepository<LocationEntity, Integer>{
   @Query(value="SELECT * FROM seoul_location "
		       +"ORDER BY no ASC "
		       +"LIMIT :start,12",nativeQuery = true)
   public List<LocationEntity> locationListData(@Param("start") Integer start);
   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location",nativeQuery = true)
   public int locationToalPage();
   
   public LocationEntity findByNo(int no);// 상세보기 
   // save , delete , findAll
   
}
