package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   NO                NOT NULL NUMBER         
	GOODS_NAME        NOT NULL VARCHAR2(1000) 
	GOODS_SUB                  VARCHAR2(1000) 
	GOODS_PRICE       NOT NULL VARCHAR2(50)   
	GOODS_DISCOUNT             NUMBER         
	GOODS_FIRST_PRICE          VARCHAR2(20)   
	GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
	GOODS_POSTER               VARCHAR2(260)
 */
@Getter
@Setter
public class GoodsVO {
   private int no,goods_discount;
   private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
}
