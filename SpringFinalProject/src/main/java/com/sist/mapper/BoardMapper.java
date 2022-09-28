package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
/*
 *   let sum=0;
 *   for(let i=0;i<arr.length;i++)
 *   {
 *       sum+=i;
 *   }
 *   
 *   FROM emp,dept
 *   WHERE emp.deptno(+)=dept.deptno 
 *   
 *   FROM emp RIGHT OUTER JOIN dept
 *   ON emp.deptno=dept.deptno 
 *   
 *   FROM emp JOIN dept
 *   ON emp.deptno=dept.deptno 
 *   
 *   => , JOIN
 *     WHERE => ON
 *     
 *   <div onclick="aaa()"></div>
 *   
 *   Number(데이터) , parseInt(데이터) , String(데이터)
 *   
 */
public interface BoardMapper {
  /*
   *    @Select("SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
   *     +"FROM goods_board ORDER BY no DESC"
		 +"LIMIT #{start},#{end})
   */
  @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM goods_board ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(Map map);
  
  @Select("SELECT COUNT(*) FROM goods_board")
  public int boardRowCount();
  /*
   *    @Insert("INSERT INTO goods_board(no,name,subject,content,pwd) VALUES("
		 +"(SELECT IFNULL(MAX(no)+1,1) FROM goods_board),"
		 +"#{name},#{subject},#{content},#{pwd})")
   */
  @Insert("INSERT INTO goods_board(no,name,subject,content,pwd) VALUES("
		 +"(SELECT NVL(MAX(no)+1,1) FROM goods_board),"
		 +"#{name},#{subject},#{content},#{pwd})")
  public void boardInsert(BoardVO vo);
  
  @Update("UPDATE goods_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		 +"FROM (SELECT no,name,subject,content,regdate,hit,rownum as num  "
		 +"FROM (SELECT no,name,subject,content,regdate,hit "
		 +"FROM goods_board ORDER BY no DESC)) "
		 +"WHERE no=#{no}")
  public BoardVO boardDetail(int no);
  
  @Select("SELECT no,subject,num "
			 +"FROM (SELECT no,subject,rownum as num  "
			 +"FROM (SELECT no,subject "
			 +"FROM goods_board ORDER BY no DESC)) "
			 +"WHERE num=#{num}")
  public BoardVO boardPNData(int num);
  
  @Select("SELECT no,subject,hit,rownum "
		 +"FROM (SELECT no,subject,hit "
		 +"FROM goods_board ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
  public List<BoardVO> boardFooterData();
}









