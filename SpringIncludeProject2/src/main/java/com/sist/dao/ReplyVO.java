package com.sist.dao;
/*
 *      NO         NOT NULL NUMBER       
		BNO                 NUMBER       
		ID                  VARCHAR2(20) 
		NAME       NOT NULL VARCHAR2(34) 
		MSG        NOT NULL CLOB         
		REGDATE             DATE         
		GROUP_ID            NUMBER       
		GROUP_STEP          NUMBER       
		GROUP_TAB           NUMBER       
		ROOT                NUMBER       
		DEPTH               NUMBER       
		TYPE                NUMBER    
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReplyVO {
  private int no,bno,group_id,group_step,group_tab,root,depth,type;
  private String id,name,msg,dbday;
  private Date regdate;
}
















