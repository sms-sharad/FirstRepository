package com.spring.autowire.concept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.autowire.controller.EmpController;

@Configuration
public class AppConfig {

	@Bean
	public EmpController  empController(){
		return new EmpController();
	}
	
	@Bean
	public Employee myFirstBean(){
		return new Employee(100);
	}
	
	@Bean
	public Employee mySecondBean(){
		return new Employee(200);
	}
	
	
}
