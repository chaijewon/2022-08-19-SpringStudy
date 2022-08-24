package com.sist.main;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
  @Results({
	  @Result(property = "dvo.dname",column = "dname"),
	  @Result(property = "dvo.loc",column = "loc")
  })
  // vo.getDvo().setDname(rs.getString("dname"));
  // dname==> vo.setDname() => Error
  // property  ==> 변수명 ==> setXxx()
  // type ==> class명을 지정 
  // {} ==> getXxx() 호출  ${vo.name} => vo.getName()  #{name} vo.getName()
  @Select("SELECT empno,ename,job,hiredate,sal,emp.deptno,dname,loc "
		 +"FROM emp,dept "
		 +"WHERE emp.deptno=dept.deptno")
  public List<EmpVO> empListData();
}
