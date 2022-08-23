package com.sist.xmlanno;
/*
 *   MNO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE             VARCHAR2(500) 
	GRADE             VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE             VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR          VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER            VARCHAR2(260) 
	STORY             CLOB          
	KEY               VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2) 
	
	1. XML
	2. Annotation
	3. XML+Annotation (O)
	--------------------------- 스프링 4
	4. 자바 (스프링 5 권장)
 */
public class MovieVO {
    private int mno,cno,hit;
    private String title,grade,reserve,genre,time,regdate,director,actor,showuser,poster,key;
    private double score;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getShowuser() {
		return showuser;
	}
	public void setShowuser(String showuser) {
		this.showuser = showuser;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
   
}



