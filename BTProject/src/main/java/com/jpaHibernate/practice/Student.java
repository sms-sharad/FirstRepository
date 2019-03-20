package com.jpaHibernate.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stud_id")
	private int id;
	private String name;
	@Column(name="passportNo",unique=true,nullable=false,length=10)
	private String passportNumber;
	
	
	
	public Student() {
		super();
	}
	
	public Student(String name, String passportNumber) {
		super();
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public Student(int id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
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
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String toString(){
		return String.format("Student[id=%s, name=%s, PassPortNum=%s]",id,name,passportNumber);
	}
}
