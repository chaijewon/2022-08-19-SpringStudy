package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
// 목록 / 추가 / 상세 
public class BoardVO {
   private int no,hit;
   private String name,subject,content,pwd,dbday;
   private Date regdate;
   private int num;
}
