package com.spring.rest.example;

import java.util.Arrays;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(MainApp.class, args);
		String beanNames[] = appContext.getBeanDefinitionNames();
		
		
		Arrays.sort(beanNames);
		for (String s1 : beanNames) {
			System.out.println(s1);
		}
	}
}
