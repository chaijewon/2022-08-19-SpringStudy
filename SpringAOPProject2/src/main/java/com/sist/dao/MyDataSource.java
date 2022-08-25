package com.sist.dao;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class MyDataSource {
   private String driver;
   private String url;
   private String username;
   private String password;
}
