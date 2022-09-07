package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class ReplyDAO {
  @Autowired
  private ReplyMapper mapper;
  
 /*@Select("SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,group_tab,type "
			 +"FROM spring_reply "
			 +"WHERE bno=#{bno} AND type=#{type} "
			 +"ORDER BY group_id DESC , group_step ASC")*/
  public List<ReplyVO> replyListData(ReplyVO vo)
  {
	  return mapper.replyListData(vo);
  }
	  
  /*@SelectKey(keyProperty = "no",resultType = int.class,before = true, 
			  statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_reply")
	  // MySQL  ====> NVL() : IFNULL
	  //              TO_CHAR : DATE_FORMAT
	  // NUMBER : int ,double , VARCHAR2:VARCHAR , CLOB : text
  @Insert("INSERT INTO spring_reply(no,bno,id,name,msg,group_id,type) VALUES("
			 +"#{no},#{bno},#{id},#{name},#{msg},(SELECT NVL(MAX(group_id)+1,1) as no FROM spring_reply),#{type})")
  */
  public void replyInsert(ReplyVO vo)
  {
	  mapper.replyInsert(vo);
  }
}
