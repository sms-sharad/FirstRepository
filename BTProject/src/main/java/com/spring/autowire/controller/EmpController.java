package com.spring.autowire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.autowire.concept.Employee;

//@Controller("empController")
public class EmpController {
	
	//@Autowired(required=false)
	Employee emp;
	
	//@Autowired
	public EmpController(@Qualifier("abc")Employee employee){
		this.emp=employee;
	}
	public EmpController(){
		
	}
	public void m1(){
		System.out.println(emp.getId());
		emp.show();
	}
	@Autowired
	public void setEmp(@Qualifier("myFirstBean")Employee emp) {
		this.emp = emp;
	}
}
