package com.sist.main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieVO {
	private int mno,cno,hit;
    private String title,grade,reserve,genre,time,regdate,director,actor,showuser,poster,key;
    private double score;
}
