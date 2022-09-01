package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 스프링에서 클래스 관리 제외 (~VO(사용자 정의 데이터형),Mapper(interface))

import com.sist.mapper.BoardMapper;
@Repository
public class BoardDAO {
   // 인터페이스를 구현한 클래스의 주소값가 스프링에 요청 
   @Autowired
   private BoardMapper mapper;
   /*@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			 +"FROM (SELECT no,subject,name,regdate,hit "
			 +"FROM spring_board ORDER BY no DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")*/
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	 //@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board")
	public int boardTotalPage()
	{
	    return mapper.boardTotalPage();	  
	}
	
	/*@SelectKey(keyProperty = "no",resultType = int.class,before = true,
			  statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_board")
	 @Insert("INSERT INTO spring_board VALUES("
			 +"#{no},#{name},#{subject},#{content},#{pwd},SYSDATE,0)")*/
	 public void boardInsert(BoardVO vo)
	 {
		  mapper.boardInsert(vo);
	 }
	 
	 /*
	  *   @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		 +"FROM spring_board "
		 +"WHERE no=#{no}")
		 
		 @Update("UPDATE spring_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
	  */
	 
	 public BoardVO boardDetailData(int no)
	 {
		 mapper.hitIncrement(no);
		 return mapper.boardDetailData(no);
	 }
	 /*
	  *    @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		 +"FROM spring_board "
		 +"WHERE no=#{no}")
	  */
	 public BoardVO boardUpdateData(int no)
	 {
		 return mapper.boardDetailData(no);
	 }
	 
	 /*
	  *   @Update("UPDATE spring_board SET "
		 +"name=#{name},subject=#{subject},content=#{content} "
		 +"WHERE no=#{no}")
		 
		 @Select("SELECT pwd FROM spring_board "
		 +"WHERE no=#{no}")
	  */
	 public boolean boardUpdate(BoardVO vo)
	 {
		 boolean bCheck=false;
		 String db_pwd=mapper.boardGetPassword(vo.getNo());
		 if(db_pwd.equals(vo.getPwd()))
		 {
			 bCheck=true;
			 mapper.boardUpdate(vo);
		 }
		 else
		 {
			 bCheck=false;
		 }
		 return bCheck;
	 }
	 
	 public boolean boardDelete(int no,String pwd)
	 {
		 boolean bCheck=false;
		 String db_pwd=mapper.boardGetPassword(no);
		 if(db_pwd.equals(pwd))
		 {
			 bCheck=true;
			 mapper.boardDelete(no);
		 }
		 else
		 {
			 bCheck=false;
		 }
		 return bCheck;
	 }
	 
	 public List<BoardVO> boardFindData(Map map)
	 {
		 return mapper.boardFindData(map);
	 }
}









