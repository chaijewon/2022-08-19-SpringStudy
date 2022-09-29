package com.sist.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.board.controller","com.sist.board.service","com.sist.board.mapper"})
// <context:component-scan base-package="">
public class SpringBootMyBatisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisProjectApplication.class, args);
	}

}
