package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Entity(name="food_house")
@Getter
@Setter
public class FoodEntity {
	@Id
	private int fno;
	private int cno;
	private String name,address,tel,type,price,time,parking,menu,poster;
	private double score;
}
