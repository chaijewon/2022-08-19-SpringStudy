package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
  private int no;
  private int account,total;
  private String name,poster,price;
}
