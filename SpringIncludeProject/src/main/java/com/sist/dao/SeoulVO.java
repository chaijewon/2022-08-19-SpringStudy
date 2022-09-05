package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   NO      NOT NULL NUMBER         
TITLE   NOT NULL VARCHAR2(1000) 
POSTER  NOT NULL VARCHAR2(1000) 
MSG     NOT NULL CLOB           
ADDRESS NOT NULL VARCHAR2(500)  
 */
@Getter
@Setter
public class SeoulVO {
   private int no;
   private String title,poster,msg,address;
}
