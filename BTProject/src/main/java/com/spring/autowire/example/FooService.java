package com.spring.autowire.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FooService {

	@Autowired
	Formatter fooFormatter;
	
	
	@Autowired
	Formatter barFormatter;
	
	public void show(){
		System.out.println(barFormatter.value());
	}
	
	
	
}
