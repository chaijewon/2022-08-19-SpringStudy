package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
/*
 *    1. Controller(Model)  ====> @Controller,@RestController
 *    2. 데이터베이스 (DAO,Service) ===> @Repository , @Service
 *    3. 데이터분석 (Manager) ==> @Component
 */
// 순수하게 데이터베이스 연결 ==> 결과값을 받아서 JSP로 전송 (@Controller)
@Repository
public class GoodsDAO {
   // 스프링에서 구현한 객체를 자동 주입 요청 
   @Autowired
   private GoodsMapper mapper;
   
   /*@Select("SELECT no,goods_name,goods_price,goods_poster,num "
			  +"FROM (SELECT no,goods_name,goods_price,goods_poster,rownum as num "
			  +"FROM (SELECT no,goods_name,goods_price,goods_poster "
			  +"FROM ${table_name} ORDER BY no ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	
	//@Select("SELECT CEIL(COUNT(*)/5.0) FROM ${table_name}")
	public int goodsTotalPage(Map map)
	{
		return mapper.goodsTotalPage(map);
	}
	
	/*
	 *  @Select("SELECT * FROM ${table_name} "
		  +"WHERE no=#{no}")
   
	 */
	public GoodsVO goodsDetailData(Map map)
	{
		return mapper.goodsDetailData(map);
	}
	
	  /*//1. ID 체크
	   @Select("SELECT COUNT(*) FROM project_member "
			  +"WHERE id=#{id}")
	   public int idCount(String id);
	   //2. 비밀번호 비교 
	   @Select("SELECT pwd,name FROM project_member "
			 +"WHERE id=#{id}")
	   public MemberVO memberGetPassword(String id);*/
	public MemberVO memberLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		int count=mapper.idCount(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else
		{
			MemberVO dbVO=mapper.memberGetPassword(id);
			if(pwd.equals(dbVO.getPwd())) // 로그인 상태
			{
				vo.setId(id);
				vo.setName(dbVO.getName());
				vo.setMsg("OK");
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
	
	/*@Select("SELECT * FROM ${table_name} "
			 +"WHERE REGEXP_LIKE(goods_name,#{ss})")*/
	 public List<GoodsVO> goodsFindData(Map map)
	 {
		 return mapper.goodsFindData(map);
	 }
}







