package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class MovieDAO {
   @Autowired
   private MovieMapper mapper;
   
   public List<MovieVO> movieListData()
   {
	   return mapper.movieListData();
   }
   public MovieVO movieDetailData(int mno)// 매개변수가 여러개 와도 상관없다 
   {
	   return mapper.movieDetailData(mno);
   }
   
}
