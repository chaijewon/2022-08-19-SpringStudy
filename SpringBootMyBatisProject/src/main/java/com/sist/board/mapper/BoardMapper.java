package com.sist.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.board.vo.*;
@Repository
@Mapper
public interface BoardMapper {
   /*
    *   <select id="boardListData" resultType="com.sist.board.vo.BoardVO" parameterType="hashmap">
    *              ============= 메소드명              =================== return              == 매개변수
		    SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
		    FROM board ORDER BY no DESC
		    LIMIT #{start},10
		    <!-- 
		          LIMIT => 0부터 시작 
		                                     시작위치,갯수
		     -->
		  </select>
		  <select id="boardTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/10.0) FROM board
		  </select>
    */
	public List<BoardVO> boardListData(Map map);
	public int boardTotalPage();
}
