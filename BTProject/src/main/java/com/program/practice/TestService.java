package com.program.practice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
//@SpringBootApplication
public class TestService {

	@WebMethod
	public String sauHello(String msg){
		return "Hello "+msg;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestService.class, args);
		Endpoint.create(new TestService());
	}
	
}
