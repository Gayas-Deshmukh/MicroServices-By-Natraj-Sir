package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootProjMs08EurekaServerMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProjMs08EurekaServerMiniProjectApplication.class, args);
	}

}
