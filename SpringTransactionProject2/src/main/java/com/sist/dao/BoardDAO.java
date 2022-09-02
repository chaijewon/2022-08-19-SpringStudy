package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;

@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   public List<BoardVO> boardLisData(Map map)
   {
	   return mapper.boardLisData(map);
   }
   public int boardTotalPage()
   {
	   return mapper.boardTotalPage();
   }
   public int boardCount()
   {
	   return mapper.boardCount();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
}
