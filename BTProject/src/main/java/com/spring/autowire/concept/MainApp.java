package com.spring.autowire.concept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.autowire.controller.EmpController;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext confApp=  SpringApplication.run(MainApp.class, args);
		EmpController empCont= (EmpController) confApp.getBean("empController");
		empCont.m1();
	}
}
