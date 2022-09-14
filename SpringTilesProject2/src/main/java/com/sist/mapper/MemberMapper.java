package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
   @Select("SELECT COUNT(*) FROM spring_member2 "
          +"WHERE id=#{id}")
   public int memberIdCount(String id);
   @Select("SELECT pwd,name FROM spring_member2 "
		  +"WHERE id=#{id}")
   public MemberVO memberInfoData(String id);
}
