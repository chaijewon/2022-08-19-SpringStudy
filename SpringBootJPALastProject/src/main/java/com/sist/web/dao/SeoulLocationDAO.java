package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.vo.SeoulLocationEntity;
import java.util.*;

public interface SeoulLocationDAO extends JpaRepository<SeoulLocationEntity, Integer>{
   @Query(value="SELECT no,title,poster,msg,address,hit "
		 +"FROM seoul_location "
		 +"ORDER BY no ASC "
		 +"LIMIT :start,12",nativeQuery = true)
   public List<SeoulLocationEntity> seoulLocationListData(@Param("start") Integer start);
   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
   public int seoulLocationTotalPage();
}
