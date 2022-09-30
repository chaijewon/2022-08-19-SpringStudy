package com.sist.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.board.entity.BoardEntity;
// <> 제네릭스 (형변환) ==> 클래스형 
/*
 *   Back-end
 *     Spring / Java / DB (MySQL,오라클) ==> MyBatis/JPA
 *   Front-end 
 *     Node.js/Vue,React / Typescript 
 *     ==============================
 *   HTML/CSS 
 */
@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
   // 상세보기 
   public BoardEntity findByNo(@Param("no") Integer no);
   // SELECT * FROM board WHERE no=1;
   // 수정 , 삭제 , 추가 ==> save() , save() , delete()
   @Query(value = "SELECT no,name,subject,content,pwd,regdate,hit "
		 +"FROM board ORDER BY no DESC "
		 +"LIMIT :start,10",nativeQuery = true)
   public List<BoardEntity> boardListData(@Param("start") int start);
   
   @Query(value="SELECT COUNT(*) FROM board",nativeQuery = true)
   public int boardRowCount();
}










