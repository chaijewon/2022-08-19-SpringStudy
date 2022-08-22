package com.sist.dao;
import java.util.*;
public class EmpDAO {
    private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
   
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);// getConnection() , disConnection()
		// insert , update , delete ==> autocommit
	}
	public void init()
	{
		System.out.println("======================= 사원 목록 =======================");
	}
}
