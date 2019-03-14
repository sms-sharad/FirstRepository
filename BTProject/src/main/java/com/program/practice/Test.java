package com.program.practice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Test {
	
	
	static Logger log=Logger.getLogger(Test.class);
    public static void main(String[] args)
    {
        //PropertiesConfigurator is used to configure logger from properties file
       // PropertyConfigurator.configure("src/main/resources/log4j.properties");
        //Log in console in and log file
        log.info("logger");
    }
}
