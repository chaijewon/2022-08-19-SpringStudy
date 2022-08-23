package com.sist.spring5;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

// xml 대신 사용 
// spring5 => 순수 자바로만 생성 
@Configuration
@ComponentScan(basePackages = {"com.sist.spring5"})
// xml의 태그 => 어노테이션화 
// <context:component-scan base-package="com.sist.xmlanno"></context:component-scan>
public class MovieConfig {
   @Bean("ds") // <bean id="ds" >
   public DataSource dataSource()
   {
	   BasicDataSource ds=new BasicDataSource(); // class=""
	   ///////////////////////////////// p:~
	   ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	   ds.setUsername("hr");
	   ds.setPassword("happy");
	   return ds;
   }
   
   @Bean("ssf")
   public SqlSessionFactory sqlSessionFactory() throws Exception
   {
	   SqlSessionFactoryBean ssf=
			   new SqlSessionFactoryBean();
	   ssf.setDataSource(dataSource());
	   ssf.setConfigLocation(new ClassPathResource("Config.xml")); // classpath:
	   return ssf.getObject();
   }
   
}
