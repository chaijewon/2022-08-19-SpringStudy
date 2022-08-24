package com.sist.spring5;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
// <context:component-scan base-package="com.sist.spring5"/>
@ComponentScan(basePackages = {"com.sist.spring5"})
public class MovieConfig {
  /*
   *   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
         p:driverClassName="oracle.jdbc.driver.OracleDriver"
         p:url="jdbc:oracle:thin:@localhost:1521:XE"
         p:username="hr"
         p:password="happy"
         p:maxActive="10"
         p:maxIdle="10"
         p:maxWait="-1"
      />
   */
	// spring5 , spring-boot
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		return ds;
	}
	/*
	 *   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
           p:dataSource-ref="dataSource"
           p:configLocation="classpath:Config.xml"
         />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		ssf.setConfigLocation(new ClassPathResource("Config.xml"));
		return ssf.getObject();
	}
}








