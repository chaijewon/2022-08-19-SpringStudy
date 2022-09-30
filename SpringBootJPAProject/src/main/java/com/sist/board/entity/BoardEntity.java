package com.sist.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity(name="board") //table명과 매칭 ==> 테이블에 없는 변수명을 설정 할 수 없다 
// JPA ==> 수동 / 자동 (SQL)
/*
 *   수동 : 복잡한 SQL  ==> 페이지 나누기 
 *   자동 : INSERT , UPADTE , DELETE
 *   ============================== 메소드를 이용한 쿼리문장 => 검색 
 *                    findByName,findByNo
 *                    ========== ======== WHERE no=
 *                    WHERE name=
 */
@Getter
@Setter
public class BoardEntity {
  @Id
  private int no; //Primary key  
  private String name,subject,content,pwd;
  private LocalDateTime regdate;
  private int hit;
  // 날짜 출력 
  @PrePersist
  public void regdate() {
	  this.regdate=LocalDateTime.now();
  }
  
}
