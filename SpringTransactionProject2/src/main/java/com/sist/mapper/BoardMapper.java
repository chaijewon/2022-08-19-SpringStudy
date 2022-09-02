package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.*;
public interface BoardMapper {
  // 목록
  @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,group_tab,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
				     +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
				     +"FROM spring_replyboard ORDER BY group_id DESC,group_step ASC)) "
				     +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardLisData(Map map);
  // 총페이지
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_replyboard")
  public int boardTotalPage();
  
  @Select("SELECT COUNT(*) FROM spring_replyboard")
  public int boardCount();
  
  @Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id) "
				     +"VALUES(sr1_no_seq.nextval,#{name},#{subject},#{content},#{pwd},(SELECT NVL(MAX(group_id)+1,1) FROM spring_replyboard))")
  public void boardInsert(BoardVO vo);
  
  // 상세보기
  @Update("UPDATE spring_replyboard SET "
				     +"hit=hit+1 "
				     +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
			  +"FROM spring_replyboard "
			  +"WHERE no=#{no}")
  public BoardVO boardDetailData(int no);
  
  // 답변하기
  @Select("SELECT group_id,group_step,group_tab "
				     +"FROM spring_replyboard "
				     +"WHERE no=#{no}")
  public BoardVO boardParentInfoData(int no);
  
  @Update("UPDATE spring_replyboard SET "
			  +"group_step=group_step+1 "
		      +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
  public void boardGroupStepIncrement(BoardVO vo);
  
  @Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
			  +"VALUES(sr1_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{group_id},#{group_step},#{group_tab},#{root})")
  public void boardReplyInsert(BoardVO vo);
  
  @Update("UPDATE spring_replyboard SET "
		      +"depth=depth+1 "
			  +"WHERE no=#{no}")
  public void depthIncrement(int no);
  
  @Select("SELECT pwd FROM spring_replyboard "
				     +"WHERE no=#{no}")
  public String boardGetPassword(int no);
  
  @Update("UPDATE spring_replyboard SET "
				  +"name=#{name},subject=#{subject},content=#{content} "
				  +"WHERE no=#{no}")
  public void boardUpdate(BoardVO vo);
  
  // 삭제
  @Select("SELECT root,depth FROM spring_replyboard "
				  +"WHERE no=#{no}")
  public BoardVO boardGetRootDepthData(int no);
  @Delete("DELETE FROM spring_replyboard "
					  +"WHERE no=#{no}")
  public void boardDelete(int no);
  @Update("UPDATE spring_replyboard SET "
					  +"subject=#{subject},content=#{content} "
					  +"WHERE no=#{no}")
  public void boardSubjectContentUpdate(BoardVO vo);
  @Update("UPDATE spring_replyboard SET "
				  +"depth=depth-1 "
				  +"WHERE no=#{no}")
  public void depthDecrement(int no);
}






