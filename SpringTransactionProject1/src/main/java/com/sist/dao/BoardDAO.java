package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
@Repository
public class BoardDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 드라이버 등록 
   public BoardDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   
   // 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 닫기 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null)
			   ps.close();
		   if(conn!=null)
			   conn.close();
	   }catch(Exception ex) {}
   }
   
   // 목록 
   public List<BoardVO> boardLisData(int page)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   try
	   {
		   // 연결 
		   getConnection();
		   // SQL
		   String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				     +"FROM (SELECT /*+INDEX_DESC(spring_replyboard sr1_no_pk)*/no,subject,name,regdate,hit "
				     +"FROM spring_replyboard)) "
				     +"WHERE num BETWEEN ? AND ?";
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   // sql 문장 전송 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   // ====> parameterType
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   // 실행후 결과값을 받는다 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   // resultType="BoardVO"
			   BoardVO vo=new BoardVO();
			   vo.setNo(rs.getInt(1)); // vo.setNo(rs.getInt("no"))
			   vo.setSubject(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setDbday(rs.getString(4));
			   vo.setHit(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // 총페이지
   public int boardTotalPage()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT CEIL(COUNT(*)/10.0) FROM spring_replyboard";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // 글쓰기
   /*
    *    no NUMBER,
	    name VARCHAR2(34) CONSTRAINT sr1_name_nn NOT NULL,
	    subject VARCHAR2(1000) CONSTRAINT sr1_sub_nn NOT NULL,
	    content CLOB CONSTRAINT sr1_cont_nn NOT NULL,
	    pwd VARCHAR2(10) CONSTRAINT sr1_pwd_nn NOT NULL,
	    regdate DATE DEFAULT SYSDATE,
	    hit NUMBER DEFAULT 0,
	    group_id NUMBER,
	    group_step NUMBER DEFAULT 0,
	    group_tab NUMBER DEFAULT 0,
	    root NUMBER DEFAULT 0,
	    depth NUMBER DEFAULT 0,
	    CONSTRAINT sr1_no_pk PRIMARY KEY(no)
    */
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id) "
				     +"VALUES(sr1_no_seq.nextval,?,?,?,?,(SELECT NVL(MAX(group_id)+1,1) FROM spring_replyboard))";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 상세보기 
   public BoardVO boardDetailData(int no)
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   getConnection();
		   String sql="UPDATE spring_replyboard SET "
				     +"hit=hit+1 "
				     +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.executeUpdate();
		   
		   sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD'),hit "
			  +"FROM spring_replyboard "
			  +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   vo.setName(rs.getString(2));
		   vo.setSubject(rs.getString(3));
		   vo.setContent(rs.getString(4));
		   vo.setDbday(rs.getString(5));
		   vo.setHit(rs.getInt(6));
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return vo;
   }
   // 답변하기 ==> 트랙잭션  
   
   public void boardReplyInsert(int pno,BoardVO vo)
   {
	   try
	   {
		   // 연결 
		   getConnection();
		   // AutoCommit 해제 
		   conn.setAutoCommit(false); // @Around
		   
		   
		   conn.commit();// @Around
	   }catch(Exception ex)
	   { 
		   // rollback()  @AfterThrowing
	   }
	   finally
	   {
		   // 원상복위  //@After
	   }
   }
   // 수정 
   // 삭제       ==> 트랜잭션 
}













