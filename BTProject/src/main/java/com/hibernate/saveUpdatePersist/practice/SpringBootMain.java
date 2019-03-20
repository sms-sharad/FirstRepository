package com.hibernate.saveUpdatePersist.practice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class SpringBootMain {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringBootMain.class, args);
		EmpResource resource=applicationContext.getBean(EmpResource.class);
		resource.perform();
	}
	
}
