package com.spring.autowire.singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext confApp=  SpringApplication.run(MainApp.class, args);
		AccountService serv= (AccountService) confApp.getBean(AccountService.class);
		System.out.println(serv.hashCode());
		serv.setAccountNumber("123");
		System.out.println(serv.getAccountNumber());
		
		AccountService serv1= (AccountService) confApp.getBean(AccountService.class);
		System.out.println(serv1.hashCode());
		System.out.println(serv1.getAccountNumber());
		System.out.println(serv==serv1);
	}
}
