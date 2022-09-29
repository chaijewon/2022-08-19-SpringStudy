package com.sist.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.board.mapper.*;
import com.sist.board.vo.*;
// 멘텍 ==> react/vue ==> 10/17 AWS 
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper mapper;
    
	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.boardListData(map);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(mapper.boardTotalPage()/10.0));
	}

	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return mapper.boardDetailData(no);
	}

	@Override
	public String boardGetPassword(int no) {
		// TODO Auto-generated method stub
		return mapper.boardGetPassword(no);
	}

	@Override
	public void boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardUpdate(vo);
	}

	@Override
	public void boardDelete(int no) {
		// TODO Auto-generated method stub
		mapper.boardDelete(no);
	}
  
}







