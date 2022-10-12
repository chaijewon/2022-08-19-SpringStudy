package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
/*
 *   Spring-Boot : Framework를 단순화 (셋팅을 자동 처리) 
 *   Spring4 (XML셋팅), String5(어노테이션) => 자바
 *   ======= SM 
 *      ================> DI/AOP/MVC
 *   ===> JSP ===> HTML
 *   
 */
import java.util.*;

@Repository
// WHERE 컬럼명=(값)
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
     public BoardEntity findByNo(@Param("no") Integer no);// 상세보기 
     
     @Query(value="SELECT no,name,subject,content,hit,regdate,pwd "
    	   +"FROM board ORDER BY no DESC LIMIT :start,10",nativeQuery = true)
     public List<BoardEntity> boardListData(@Param("start") Integer start);
     
     @Query(value="SELECT CEIL(COUNT(*)/10.0) FROM board")
     public int boardTotalPage();
     // 수정,삭제,추가 => 이미 제작 
     
     // ==> 메소드명으로 SQL문장이 가능하다 
}
















