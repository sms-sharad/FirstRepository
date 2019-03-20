package com.spring.rest.example;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Component
public class Employee implements Serializable {

	
	private int id;
	private String name;
	//private Date createdDate;
	
	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*@JsonSerialize(using=DateSerializer.class)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}*/
}
