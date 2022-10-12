package com.sist.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

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