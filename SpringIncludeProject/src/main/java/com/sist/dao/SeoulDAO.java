package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;

@Repository
public class SeoulDAO {
  @Autowired
  private SeoulMapper mapper;
  
  public List<SeoulVO> locationData()
  {
	  return mapper.locationData();
  }
  
  public List<SeoulVO> natureData()
  {
	  return mapper.natureData();
  }
  
  public List<SeoulVO> shopData()
  {
	  return mapper.shopData();
  }
  
  public List<SeoulVO> hotelData()
  {
	  return mapper.hotelData();
  }
  
  public List<SeoulVO> guestData()
  {
	  return mapper.guestData();
  }
}
