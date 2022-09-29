package com.sist.board.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BoardVO {
  private int no,hit;
  private String name,subject,content,pwd,dbday;
  private Date regdate;
}
