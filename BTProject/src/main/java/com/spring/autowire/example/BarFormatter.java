package com.spring.autowire.example;

import org.springframework.stereotype.Component;

@Component("bar")
public class BarFormatter implements Formatter {

	@Override
	public String value() {
		return "bar";
	}

}
