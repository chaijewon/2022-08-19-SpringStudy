package com.sist.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 *   <bean id="a" class="com.sist.web.AModel"/>
    <bean id="b" class="com.sist.web.BModel"/>
    <bean id="c" class="com.sist.web.CModel"/>
 */
@Configuration
public class ModelConfig {
  @Bean("a")
  public AModel aModel()
  {
	  return new AModel();
  }
  
  @Bean("b")
  public BModel bModel()
  {
	  return new BModel();
  }
  
  @Bean("c")
  public CModel cModel()
  {
	  return new CModel();
  }
}
