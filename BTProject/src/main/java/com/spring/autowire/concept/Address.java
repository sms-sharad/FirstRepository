package com.spring.autowire.concept;

import org.springframework.stereotype.Component;

@Component("address")
public class Address {

	private String city;
	private String add;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
}
