package com.sist.di;
import java.util.*;

import org.apache.ibatis.annotations.Select;
// JOIN , 동적쿼리 
public interface EmpMapper {
   @Select("SELECT empno,ename,job,hiredate,sal "
		  +"FROM emp")
   public List<EmpVO> empListData();
   //     resultType    id      parameterType
   // DataSet => SQL없이 사용이 가능 
   
}
