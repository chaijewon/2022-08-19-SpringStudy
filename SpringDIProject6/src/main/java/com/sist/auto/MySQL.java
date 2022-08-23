package com.sist.auto;

import org.springframework.stereotype.Repository;

@Repository("ms")
public class MySQL implements DataBase{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 연결 해제");
	}

}
