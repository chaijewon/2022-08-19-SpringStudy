package com.sist.mapper;
import java.util.*;
// C(Create)U(Update)R(Read)D(Delete)
//  INSERT   UPDATE SELECT DELETE
//  응용 => Transaction , JOIN...
//  파일 업로드 (자료) , 지니/멜론 => 조인 => 사용자 순위 결정 

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.BoardVO;
public interface BoardMapper {
  // 목록 출력 
  @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM spring_board ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(Map map);// 자동 구현 
  // 총페이지 
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
  public int boardTotalPage();
  // 상세보기 
  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		 +"FROM spring_board "
		 +"WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
  // 게시물 추가 
  @SelectKey(keyProperty = "no",resultType = int.class,before = true,
		  statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_board")
  @Insert("INSERT INTO spring_board VALUES("
		 +"#{no},#{name},#{subject},#{content},#{pwd},SYSDATE,0)")
  public void boardInsert(BoardVO vo);
  // 게시물 삭제
  // 게시물 수정 
  @Update("UPDATE spring_board SET "
		 +"name=#{name},subject=#{subject},content=#{content} "
		 +"WHERE no=#{no}")
  public void boardUpdate(BoardVO vo);
  // 조회수 증가 
  @Update("UPDATE spring_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  // 비밀번호 검색 
  @Select("SELECT pwd FROM spring_board "
		 +"WHERE no=#{no}")
  public String boardGetPassword(int no);

}











