package com.sist.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class EmpDAO {
   @Autowired  // 자동 주입 (스프링에 의해서 메모리 할당시 자동으로 구현된 주소값을 설정)
   private EmpMapper mapper;
   
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   
}
