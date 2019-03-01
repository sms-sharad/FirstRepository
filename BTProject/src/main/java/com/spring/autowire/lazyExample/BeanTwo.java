package com.spring.autowire.lazyExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanTwo {
	
	@Autowired
	BeanOne beanOne;

	/*@Autowired
	public BeanTwo(BeanOne beanOne) {
		System.out.println("BeanTwo instantiated..");
		this.beanOne=beanOne;
	}*/
	public void m1(){
		System.out.println("B2::Hello");
		beanOne.m2();
	}
	
}
