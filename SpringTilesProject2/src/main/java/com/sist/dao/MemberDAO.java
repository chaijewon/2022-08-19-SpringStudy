package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   /*
    *      @Select("SELECT COUNT(*) FROM spring_member2 "
            +"WHERE id=#{id}")
		   public int memberIdCount(String id);
		   @Select("SELECT pwd,name FROM spring_member2 "
				  +"WHERE id=#{id}")
		   public MemberVO memberInfoData(String id);
    */
   public MemberVO isLogin(String id,String pwd)
   {
	   MemberVO vo=new MemberVO();
	   int count=mapper.memberIdCount(id);
	   if(count==0)
	   {
		   vo.setMsg("NOID");
	   }
	   else
	   {
		   MemberVO mvo=mapper.memberInfoData(id);
		   if(pwd.equals(mvo.getPwd()))
		   {
			   vo.setMsg("OK");
			   vo.setName(mvo.getName());
		   }
		   else
		   {
			   vo.setMsg("NOPWD");
		   }
	   }
	   return vo;
   }
   
}





