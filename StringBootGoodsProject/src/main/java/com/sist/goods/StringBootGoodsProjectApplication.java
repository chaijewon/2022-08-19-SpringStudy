package com.sist.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.goods.controller","com.sist.goods.vo","com.sist.goods.service","com.sist.goods.dao"})
public class StringBootGoodsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringBootGoodsProjectApplication.class, args);
	}

}
