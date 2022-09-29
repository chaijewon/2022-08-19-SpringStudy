package com.sist.board.service;

import java.util.List;
import java.util.Map;

import com.sist.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(Map map);
	public int boardTotalPage();
	public int boardRowCount();
}
