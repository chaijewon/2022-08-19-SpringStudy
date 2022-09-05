package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 버전 호환 
import java.util.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
    // 필요한 객체주소를 설정 (스프링에서 관리)
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	public void boardInsert(DataBoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	public DataBoardVO databoardUpdateData(int no)
	{
		return mapper.databoardDetailData(no);
	}
}
