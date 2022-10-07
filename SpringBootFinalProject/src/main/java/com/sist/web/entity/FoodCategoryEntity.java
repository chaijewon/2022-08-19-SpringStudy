package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/*
 *   CNO int 
TITLE text 
SUBJECT text 
POSTER text 
LINK text
 */
@Entity(name="food_category")
@Getter
@Setter
public class FoodCategoryEntity {
   // 테이블에 존재하는 컬럼만 지정 
   @Id
   private int cno;
   private String title,subject,poster,link;
}
