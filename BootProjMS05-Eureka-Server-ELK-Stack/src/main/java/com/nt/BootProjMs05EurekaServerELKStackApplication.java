package com.nt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class BootProjMs05EurekaServerELKStackApplication {

	private static Logger	log	=	LoggerFactory.getLogger("BootProjMs05EurekaServerELKStackApplicationLOG");
	
	public static void main(String[] args) 
	{
		log.info("Start of main method - Eureka Server");
		
		SpringApplication.run(BootProjMs05EurekaServerELKStackApplication.class, args);
		
		log.info("End of main method - Eureka Server");
	}

}
