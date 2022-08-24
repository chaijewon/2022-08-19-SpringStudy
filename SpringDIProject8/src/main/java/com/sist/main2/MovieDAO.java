package com.sist.main2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
// SqlSessionFactory
@Repository("dao")
public class MovieDAO extends SqlSessionDaoSupport{
	
    @Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
    *   <select id="movieListData" resultType="MovieVO">
		   SELECT mno,title,genre,grade,director,actor,rownum
		   FROM (SELECT mno,title,genre,grade,director,actor
		   FROM project_movie ORDER BY mno ASC)
		   WHERE rownum&lt;=50
		 </select>
    */
	public List<MovieVO> movieListData()
	{
		return getSqlSession().selectList("movieListData");
	}
	// <select id="movieFindData" resultType="MovieVO" parameterType="hashmap">
	public List<MovieVO> movieFindData(Map map)
	{
		return getSqlSession().selectList("movieFindData", map);
	}
}
