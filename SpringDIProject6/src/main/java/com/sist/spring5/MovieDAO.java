package com.sist.spring5;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MovieDAO extends SqlSessionDaoSupport{
   
    @Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

   public List<MovieVO> movieListData(Map map)
   {
	   return getSqlSession().selectList("movieListData",map);
   }
   /*
    *   DataSource (데이터베이스 정보)
    *   ----------------------------> SqlSessionFactory (getConnection,disConnection)
    *                            -----------------------------------------------------> MovieDAO
    *                                                         ---------------------------------------> MainClass
    */
}
