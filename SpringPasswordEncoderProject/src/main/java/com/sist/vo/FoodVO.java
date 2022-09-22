package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *   FNO     NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(1000) 
	SCORE   NOT NULL NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(1000) 
	TEL     NOT NULL VARCHAR2(20)   
	TYPE    NOT NULL VARCHAR2(50)   
	PRICE            VARCHAR2(60)   
	TIME             VARCHAR2(60)   
	PARKING          VARCHAR2(60)   
	MENU             VARCHAR2(1000) 
	HIT              NUMBER         
	CNO     NOT NULL NUMBER         
	POSTER           VARCHAR2(2000) 
	RDAY             VARCHAR2(2000)
 */
@Getter
@Setter
public class FoodVO {
  private int fno,cno,hit;
  private String name,address,tel,type,price,time,parking,menu,poster,id,msg,rday;
  private double score;
}
