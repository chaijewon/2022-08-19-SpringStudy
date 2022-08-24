package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
// SqlSessionFactory
public class MovieDAO extends SqlSessionDaoSupport{
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
