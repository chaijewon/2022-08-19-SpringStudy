package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *  ID        NOT NULL VARCHAR2(20)  
	PWD       NOT NULL VARCHAR2(100) 
	NAME      NOT NULL VARCHAR2(34)  
	SEX                VARCHAR2(10)  
	BIRTHDAY  NOT NULL VARCHAR2(30)  
	EMAIL              VARCHAR2(100) 
	POST      NOT NULL VARCHAR2(10)  
	ADDR1     NOT NULL VARCHAR2(200) 
	ADDR2              VARCHAR2(100) 
	TEL                VARCHAR2(20)  
	CONTENT            CLOB          
	SESSIONID          VARCHAR2(100) 
	LIMITED            DATE          
	ROLE               VARCHAR2(10)
 */
public interface MemberMapper {
   // 회원가입  ==> 비밀번호 암호화 
   @Select("SELECT COUNT(*) FROM spring_join WHERE id=#{id}")
   public int memberIdCheck(String id);
   @Insert("INSERT INTO spring_join VALUES("
		  +"#{id},#{pwd},#{name},#{sex},#{birthday},#{email},#{post},"
		  +"#{addr1},#{addr2},#{tel},#{content},'',null,'ROLE_USER')")
   public void memberJoinInsert(MemberVO vo);
   // 로그인    ==> 복호화 ====> 자동로그인
   @Select("SELECT pwd,name,role FROM spring_join "
		  +"WHERE id=#{id}")
   public MemberVO memberJoinInfoData(String id);
   // 회원 탈퇴  ==> 복호화 
   // 회원 수정  ==> 복호화 
   @Select("SELECT pwd FROM spring_join "
		  +"WHERE id=#{id}")
   public String memberGetPassword(String id);
   
   @Select("SELECT * FROM spring_join "
		  +"WHERE id=#{id}")
   public MemberVO memberUpdateData(String id);
		  
}







