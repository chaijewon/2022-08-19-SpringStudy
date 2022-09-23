package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO        NOT NULL NUMBER        
CHEF      NOT NULL VARCHAR2(300) 
POSTER    NOT NULL VARCHAR2(260) 
MEM_CONT1          VARCHAR2(20)  
MEM_CONT2          VARCHAR2(20)  
MEM_CONT3          VARCHAR2(20)  
MEM_CONT7          VARCHAR2(20)
 */
@Getter
@Setter
public class ChefVO {
   private int no;
   private String chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont7;
}
