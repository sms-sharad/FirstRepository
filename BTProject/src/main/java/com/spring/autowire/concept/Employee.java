package com.spring.autowire.concept;

//@Component("abc")
public class Employee {
	
	private int id;
	
	public Employee(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void show(){
		System.out.println("Employee Bean called");
	}
}
