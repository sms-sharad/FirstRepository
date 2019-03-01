package com.spring.autowire.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext confApp=  SpringApplication.run(MainApp.class, args);
		FooService serv= (FooService) confApp.getBean("fooService");
		serv.show();
	}
}
