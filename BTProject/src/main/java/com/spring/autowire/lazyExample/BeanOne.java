package com.spring.autowire.lazyExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanOne {
	
	@Autowired
	//@Lazy
	BeanTwo beanTwo;
	
	//@Autowired
	/*public BeanOne(@Lazy BeanTwo beanTwo){
		System.out.println("BeanOne is initiliazed");
		this.beanTwo=beanTwo;
	}*/
	public void m1(){
		System.out.println("B1::Hello");
		beanTwo.m1();
	}
	
	public void m2(){
		System.out.println("B1: Byee");
	}
}
