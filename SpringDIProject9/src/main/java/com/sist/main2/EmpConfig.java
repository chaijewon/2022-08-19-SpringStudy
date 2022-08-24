package com.sist.main2;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//<context:component-scan base-package="com.sist.main"/>
@ComponentScan(basePackages = {"com.sist.main2"})
public class EmpConfig {
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
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 *   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
         p:dataSource-ref="ds"
      />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
	/*
	 *   <bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
        p:sqlSessionFactory-ref="ssf"
        p:mapperInterface="com.sist.main.EmpMapper"
      />
	 */
	// 권장 (스프링5)
	@Bean("mapper")
	public MapperFactoryBean  mapperFactoryBean() throws Exception
	{
		MapperFactoryBean mapper=new MapperFactoryBean();
		mapper.setSqlSessionFactory(sqlSessionFactory());
		mapper.setMapperInterface(com.sist.main2.EmpMapper.class);
		return mapper;
	}
}







