package com.sist.board.service;

import java.util.List;
import java.util.Map;

import com.sist.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(Map map);
	public int boardTotalPage();
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public BoardVO boardUpdateData(int no);
	public String boardGetPassword(int no);
	public void boardUpdate(BoardVO vo);
	public void boardDelete(int no);
}
