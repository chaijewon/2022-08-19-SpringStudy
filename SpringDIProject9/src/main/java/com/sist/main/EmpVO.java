package com.sist.main;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
   private int empno,sal,comm,mgr,deptno;
   private String ename,job;
   private Date hiredate;
   private DeptVO dvo=new DeptVO();
}
