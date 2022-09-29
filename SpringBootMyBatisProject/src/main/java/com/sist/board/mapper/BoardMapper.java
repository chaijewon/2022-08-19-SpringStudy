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
	/*
	 *  <insert id="boardInsert" parameterType="com.sist.board.vo.BoardVO">
        INSERT INTO board(name,subject,content,pwd) VALUES(#{name},#{subject},#{content},#{pwd})
        </insert>
	 */
	public void boardInsert(BoardVO vo);
	/*
	 *   <!-- 상세보기  -->
	  <update id="hitIncrement" parameterType="int">
	   UPDATE board SET
	   hit=hit+1
	   WHERE no=#{no}
	  </update>
	  <select id="boardDetailData" resultType="com.sist.board.vo.BoardVO" parameterType="int">
	   SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
	   FROM board
	   WHERE no=#{no}
	  </select>
	 */
	public void hitIncrement(int no);
	public BoardVO boardDetailData(int no); // 구현완료
	/*
	 *   메소드  ====> id
	 *   매개변수 ==> parameterType
	 *   리턴형  ===> resultType
	 */
	/*
	 *   <!-- 수정하기  -->
		  <select id="boardGetPassword" resultType="string" parameterType="int">
		    SELECT pwd FROM board
		    WHERE no=#{no}
		  </select>
		  <update id="boardUpdate" parameterType="com.sist.board.vo.BoardVO">
		    UPDATE board SET 
		    name=#{name},
		    subject=#{subject},
		    content=#{content}
		    WHERE no=#{no}
		  </update>
	 */
	public String boardGetPassword(int no);
	public void boardUpdate(BoardVO vo);
	/*
	 *   <delete id="boardDelete" parameterType="int">
		    DELETE FROM board 
		    WHERE no=#{no}
		  </delete>
	 */
	public void boardDelete(int no);
	
}
