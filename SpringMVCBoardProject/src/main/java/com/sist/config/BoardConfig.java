package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
/*
 *  <aop:aspectj-autoproxy/>
    <context:component-scan base-package="com.sist.*"/>
 */
// <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = {"com.sist.*"})
// <mybatis-spring:scan base-package="com.sist.mapper"/>
@MapperScan(basePackages = {"com.sist.mapper"})
public class BoardConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable(); //HandlerMapping , HandlerAdapter
	}
    /*
     *   <bean id="viewResolver"
	        class="org.springframework.web.servlet.view.InternalResourceViewResolver"
	        p:prefix="/"
	        p:suffix=".jsp"
         />
     */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	/*
	 *  <bean id="ds"
        class="org.apache.commons.dbcp.BasicDataSource"
        p:driverClassName="oracle.jdbc.driver.OracleDriver"
        p:url="jdbc:oracle:thin:@localhost:1521:XE"
        p:username="hr"
        p:password="happy"
     />
     <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
       p:configLocation="/WEB-INF/config/Config.xml"
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
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		ssf.setConfigLocation(new ClassPathResource("Config.xml"));
		return ssf.getObject();
	}
}









