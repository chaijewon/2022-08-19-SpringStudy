package com.sist.di;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class MovieDAO extends SqlSessionDaoSupport{
   public List<MovieVO> movieListData(Map map)
   {
	   return getSqlSession().selectList("movieListData",map);
   }
}
