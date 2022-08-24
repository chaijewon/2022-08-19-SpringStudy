package com.sist.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 17page
//<context:component-scan base-package="com.sist.main"></context:component-scan>
@Configuration
@ComponentScan(basePackages = {"com.sist.main"})
public class MovieConfig {

}
