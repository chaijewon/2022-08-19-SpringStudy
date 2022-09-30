package com.sist.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.board.entity","com.sist.board.dao","com.sist.board.controller"})
public class SpringBootJpaProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject2Application.class, args);
	}

}
