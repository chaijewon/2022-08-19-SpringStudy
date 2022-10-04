package com.sist.web.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name="food_category")
public class CategoryEntity {
   @Id
   private int cno;
   private String title,subject,poster,link;
}
