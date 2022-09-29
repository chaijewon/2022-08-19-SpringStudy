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
  
}







