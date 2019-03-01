package com.spring.autowire.example;

import org.springframework.stereotype.Component;

@Component
public class FooFormatter implements Formatter {

	@Override
	public String value() {
		return "foo";
	}

}
