package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class EmpDAO {
   @Autowired
   private EmpMapper mapper;
   
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   
   
}
