package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.dao.DataBoardVO;
public interface DataBoardMapper {
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit "
		  +"FROM spring_databoard ORDER BY no DESC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<DataBoardVO> boardListData(Map map);
   
   // 총페이지 
   @Select("SELECT CEIL(COUTN(*)/10.0) FROM spring_databoard")
   public int boardTotalPage();
   // 1. sequence , 2. selectkey , 3. subquery
   /*
    *   @Insert("INSERT INTO spring_databoard VALUES("
		  +"(SELECT NVL(MAX(no)+1,1) as no FROM spring_databoard),#{name},#{subject},#{content},#{pwd},"
		  +"SYSDATE,0,#{filename},#{filesize},#{filecount})")
    */
   @SelectKey(keyProperty = "no",resultType = int.class,before = true,
		   statement = "SELECT NVL(MAX(no)+1,1) as no FROM spring_databoard")
   @Insert("INSERT INTO spring_databoard VALUES("
		  +"#{no},#{name},#{subject},#{content},#{pwd},"
		  +"SYSDATE,0,#{filename},#{filesize},#{filecount})")
   public void boardInsert(DataBoardVO vo);
}
