package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BoardEntity;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
    public BoardEntity findByNo(int no);// 상세보기 
    
    @Query(value="SELECT * "
    		  +"FROM board ORDER BY no DESC "
    		  +"LIMIT :start,10",nativeQuery = true)
    public List<BoardEntity> boardListData(@Param("start") Integer start);
    
    @Query(value="SELECT CEIL(COUNT(*)/10.0) FROM board")
    public int boardTotalPage();
    
    // 추가 
    // 삭제
    // 수정 
}








