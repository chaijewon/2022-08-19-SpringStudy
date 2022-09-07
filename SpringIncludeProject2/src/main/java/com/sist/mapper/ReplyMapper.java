package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
/*
 *    private int no,bno,group_id,group_step,group_tab,root,depth,type;
	  private String id,name,msg,dbday;
	  private Date regdate;
 */
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.ReplyVO;
public interface ReplyMapper {
  @Select("SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,group_tab,type "
		 +"FROM spring_reply "
		 +"WHERE bno=#{bno} AND type=#{type} "
		 +"ORDER BY group_id DESC , group_step ASC")
  public List<ReplyVO> replyListData(ReplyVO vo);
  
  @SelectKey(keyProperty = "no",resultType = int.class,before = true, 
		  statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_reply")
  // MySQL  ====> NVL() : IFNULL
  //              TO_CHAR : DATE_FORMAT
  // NUMBER : int ,double , VARCHAR2:VARCHAR , CLOB : text
  @Insert("INSERT INTO spring_reply(no,bno,id,name,msg,group_id,type) VALUES("
		 +"#{no},#{bno},#{id},#{name},#{msg},(SELECT NVL(MAX(group_id)+1,1) as no FROM spring_reply),#{type})")
  public void replyInsert(ReplyVO vo);
  
  // 수정 
  @Update("UPDATE spring_reply SET "
		 +"msg=#{msg} "
		 +"WHERE no=#{no}")
  public void replyUpdate(ReplyVO vo);
  // 삭제  ====================
  // 댓글 => 댓글  =============  트랜잭션 적용 
}













