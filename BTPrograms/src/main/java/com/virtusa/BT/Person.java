package com.virtusa.BT;

public class Person {
	
	private String firstName;
	private String lastname;
	private String line_1;
	private String line_2;
	private String line_3;
	
	public Person() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLine_1() {
		return line_1;
	}
	public void setLine_1(String line_1) {
		this.line_1 = line_1;
	}
	public String getLine_2() {
		return line_2;
	}
	public void setLine_2(String line_2) {
		this.line_2 = line_2;
	}
	public String getLine_3() {
		return line_3;
	}
	public void setLine_3(String line_3) {
		this.line_3 = line_3;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastname=" + lastname
				+ ", line_1=" + line_1 + ", line_2=" + line_2 + ", line_3="
				+ line_3 + "]";
	}

}
	