package com.jpaHibernate.practice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMain implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//static Logger logger=Logger.getLogger(SpringBootMain.class);
	
	@Autowired
	StudentRepository repository;
	
	public static void main(String[] args) throws Exception {
		
		ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringBootMain.class, args);
		StudentResource resource=applicationContext.getBean(StudentResource.class);
		resource.m1();
		
	}
	@Override
	public void run(String... args) throws Exception {/*
		
		logger.info("Student id 10001 -> {}", repository.findById(10001));
		
		logger.info("All users 1 -> {}", repository.findAll());
		
		//Insert
		logger.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));

		//Update
		//logger.info("Update 10001 -> {}", repository.save(new Student(10001, "Name-Updated", "New-Passport")));

		//repository.deleteById(10002);
		
		logger.info("All users 2 -> {}", repository.findAll());
	*/}
	

}
