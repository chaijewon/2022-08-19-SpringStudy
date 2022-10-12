package com.sist.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/*
 *   NO int 
GOODS_NAME text 
GOODS_SUB text 
GOODS_PRICE text 
GOODS_DISCOUNT int 
GOODS_FIRST_PRICE text 
GOODS_DELIVERY text 
GOODS_POSTER text 
HIT int
 */
@Entity(name="good_all")
@Getter
@Setter
// table = 컬럼과 반드시 일치 
public class GoodsEntity {
  @Id
  private int no;
  private String goods_name,goods_sub,goods_first_price,goods_poster;
  private int goods_discount,hit;
}
