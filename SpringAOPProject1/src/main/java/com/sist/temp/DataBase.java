package com.sist.temp;

public interface DataBase {
  public void getConnection();
  public void disConnection();
  public void selectOne();
  public void selectList();
  public default void insert() {}
}
