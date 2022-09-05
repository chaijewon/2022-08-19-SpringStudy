package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.SeoulVO;
public interface SeoulMapper {
   @Select("SELECT no,title,poster,rownum "
		  +"FROM seoul_location "
		  +"WHERE rownum<=12")
   public List<SeoulVO> locationData();
   
   @Select("SELECT no,title,poster,rownum "
			  +"FROM seoul_nature "
			  +"WHERE rownum<=12")
   public List<SeoulVO> natureData();
   
   @Select("SELECT no,title,poster,rownum "
			  +"FROM seoul_shop "
			  +"WHERE rownum<=12")
   public List<SeoulVO> shopData();
   
   @Select("SELECT no,title,poster,rownum "
			  +"FROM seoul_hotel "
			  +"WHERE rownum<=12")
   public List<SeoulVO> hotelData();
   
   @Select("SELECT no,title,poster,rownum "
			  +"FROM seoul_guest "
			  +"WHERE rownum<=12")
   public List<SeoulVO> guestData();
}
