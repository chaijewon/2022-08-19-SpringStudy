package com.sist.auto;

import org.springframework.stereotype.Repository;

@Repository("ora")
public class Oracle implements DataBase{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 연결 해제...");
	}

}
