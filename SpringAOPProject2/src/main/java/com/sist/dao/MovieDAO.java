package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MovieDAO {
   private Connection conn;
   private PreparedStatement ps;
   //private String URL="";
   private MyDataSource ds;
   public MovieDAO(MyDataSource ds)
   {
	   this.ds=ds;
	   try
	   {
		   Class.forName(ds.getDriver());
	   }catch(Exception ex) {}
   }
   
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	  try
	  {
	     if(ps!=null) ps.close();
	     if(conn!=null) conn.close();
	  }catch(Exception ex) {}
   }
   //////////////////////////////////////////////// SqlSessionFactory
   public List<MovieVO> movieListData()
   {
	   List<MovieVO> list=new ArrayList<MovieVO>();
	   // Before
	   try
	   {
		   // Around
		   getConnection();
		   String sql="SELECT /*+INDEX_ASC(project_movie pm_mno_pk)*/mno,title,genre FROM project_movie";  //selectList()
		   /*
		    *    <select id="aaa" resultType="MovieVO">
		    *      SELECT mno,title,genre,TO_CHAR() as dbday FROM project_movie
		    *    </select>
		    *    
		    *    HashMap
		    *    ----------------------------------------
		    *       id                         sql
		    *    ----------------------------------------
		    *       aaa            SELECT mno,title,genre FROM project_movie
		    *    ----------------------------------------
		    *    
		    *    aaa=> map.get("aaa")
		    */
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   MovieVO vo=new MovieVO(); // resultType
			   vo.setMno(rs.getInt("mno"));
			   vo.setTitle(rs.getString("title"));
			   vo.setGenre(rs.getString("genre"));
			   
			   list.add(vo);
		   }
		   rs.close();
		   // Around
	   }catch(Exception ex)
	   {
		   //AfterThrowing
		   ex.printStackTrace();
	   }
	   finally
	   {
		   //After
		   disConnection();
	   }
	   return list; // AfterReturning
   }
}






