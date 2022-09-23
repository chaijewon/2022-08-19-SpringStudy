package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
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
     *     @Select("SELECT COUNT(*) FROM spring_join WHERE id=#{id}")
		   public int memberIdCheck(String id);
		   @Insert("INSERT INTO spring_join VALUES("
				  +"#{id},#{pwd},#{name},#{sex},#{birthday},#{email},#{post},"
				  +"#{addr1},#{addr2},#{tel},#{content},#{sessionId},#{limited},'ROLE_USER'")
		   public void memberJoinInsert(MemberVO vo);
		   // 로그인    ==> 복호화 ====> 자동로그인
		   @Select("SELECT pwd,name,role FROM spring_join "
				  +"WHERE id=#{id}")
		   public MemberVO memberJoinInfoData(String id);
     */
    public int memberIdCheck(String id)
    {
    	return mapper.memberIdCheck(id);
    }
    public void memberJoinInsert(MemberVO vo)
    {
    	mapper.memberJoinInsert(vo);
    }
    public MemberVO memberJoinInfoData(String id)
    {
    	return mapper.memberJoinInfoData(id);
    }
    //@Select("SELECT pwd FROM spring_join "
  		  //+"WHERE id=#{id}")
     public String memberGetPassword(String id)
     {
    	 return mapper.memberGetPassword(id);
     }
     
     /*
      *  @Select("SELECT * FROM spring_join "
		  +"WHERE id=#{id}")
         public MemberVO memberUpdateData(String id);
      */
     public MemberVO memberUpdateData(String id)
     {
    	 return mapper.memberUpdateData(id);
     }
}
