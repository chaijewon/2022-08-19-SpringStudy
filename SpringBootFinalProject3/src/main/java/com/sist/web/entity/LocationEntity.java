package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/*
 *  NO int 
TITLE text 
POSTER text 
MSG text 
ADDRESS text 
HIT int
 */
@Entity(name="seoul_location") // name=table명
@Setter
@Getter
public class LocationEntity {
   @Id
   private int no;
   private String title,poster,msg,address;
   private int hit;
}
