package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="recipe")
@Getter
@Setter
public class RecipeEntity {
	@Id
    private int no;
	private String title,poster,chef,link;
	private int hit;
}
