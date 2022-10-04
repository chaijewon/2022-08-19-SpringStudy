package com.sist.web.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name="seoul_location")
public class SeoulLocationEntity {
   @Id
   private int no;
   private String poster,title,msg,address;
   private int hit;
}
