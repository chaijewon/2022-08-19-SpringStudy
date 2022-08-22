package com.sist.spring2;

import org.springframework.stereotype.Component;

@Component("a")
public class AModel {
  public void display()
  {
	  System.out.println("AModel:display Call...");
  }
}
