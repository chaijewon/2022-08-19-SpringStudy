package com.sist.dao;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class MovieVO {
	private int mno,cno,hit;
    private String title,grade,reserve,genre,time,regdate,director,actor,showuser,poster,key;
    private double score;
}
