package com.sist.recommand;
import java.util.*;
import java.sql.*;
public class FoodRecommandDAO {
  private Connection conn;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
  
  public FoodRecommandDAO()
  {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
  }
  
  public void getConnection()
  {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex){}
  }
  
  public void disConnection()
  {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
  }
  public List<String> foodAllData()
  {
	  List<String> list=new ArrayList<String>();
	  try
	  {
		  getConnection();
		  String sql="SELECT DISTINCT name FROM food_location "
				    +"WHERE LENGTH(name)>1";
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  String name=rs.getString(1);
			  list.add(name);
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
}
