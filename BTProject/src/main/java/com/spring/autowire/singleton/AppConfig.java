package com.spring.autowire.singleton;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.autowire.lazyExample.BeanOne;

@Configuration
public class AppConfig {

	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public AccountService accountService(){
		return new AccountService();
	}
	
}
