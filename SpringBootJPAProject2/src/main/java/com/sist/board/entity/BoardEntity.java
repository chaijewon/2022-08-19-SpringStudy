package com.sist.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
/*
 *  VO , DTO => 유연성 (컬럼과 다른 변수 설정이 가능)
 *  Entity => 테이블의 컬러명과 일치 
 *  ==> JOIN/SubQuery
 */
@Entity(name="board")
@Getter
@Setter
public class BoardEntity {
   @Id
   private int no;
   private String name,subject,content,pwd;
   private LocalDateTime regdate;
   private int hit;
   
   @PrePersist
   public void regdate()
   {
	   regdate=LocalDateTime.now();
   }
   /*@PrePersist
   public void hit()
   {
	   hit=0;
   }*/
}
