package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;
   
   /*
    *  @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM goods_board ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(Map map);
    */
   public List<BoardVO> boardListData(Map map)
   {
	   return mapper.boardListData(map);
   }
   /*
    *  @Insert("INSERT INTO goods_board(no,name,subject,content,pwd) VALUES("
		 +"(SELECT NVL(MAX(no)+1,1) FROM goods_board),"
		 +"#{name},#{subject},#{content},#{pwd})")
  public void boardInsert(BoardVO vo);
    */
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   /*
    *  @Update("UPDATE goods_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
	  public void hitIncrement(int no);
	  
	  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			 +"FROM (SELECT no,name,subject,content,regdate,hit,rownum as num  "
			 +"FROM (SELECT no,name,subject,content,regdate,hit "
			 +"FROM goods_board ORDER BY no DESC)) "
			 +"WHERE no=#{no}")
	  public BoardVO boardDetail(int no);
    */
   public BoardVO boardDetail(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetail(no);
   }
}
