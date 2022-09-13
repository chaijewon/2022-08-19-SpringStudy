package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.SeoulVO;
@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   
   /*@Select("SELECT no,title,poster,num "
			 +"FROM (SELECT no,title,poster,rownum as num "
			 +"FROM (SELECT no,title,poster "
			 +"FROM ${table_name} ORDER BY no ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")*/
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	  
	/*@Select("SELECT * FROM ${table_name} "
			 +"WHERE no=#{no}")*/
	public SeoulVO seoulDetailData(Map map)
	{
		mapper.hitIncrement(map);
		return mapper.seoulDetailData(map);
	}
	
	//@Select("SELECT CEIL(COUNT(*) FROM ${table_name}")
	public int seoulTotalPage(Map map)
	{
		return mapper.seoulTotalPage(map);
	}
	
	/*@Select("SELECT no,title,poster,rownum "
			 +"FROM (SELECT no,title,poster "
			 +"FROM ${table_name} ORDER BY hit DESC) "
			 +"WHERE rownum<=5")*/
	 public List<SeoulVO> seoulTop5(Map map)
	 {
		 return mapper.seoulTop5(map);
	 }
}
