package com.spring.autowire.lazyExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext confApp=  SpringApplication.run(MainApp.class, args);
		BeanOne obj= (BeanOne) confApp.getBean(BeanOne.class);
		obj.m1();
		
	}
}
