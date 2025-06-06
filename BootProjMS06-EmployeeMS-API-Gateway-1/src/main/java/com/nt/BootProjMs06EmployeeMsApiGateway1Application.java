package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootProjMs06EmployeeMsApiGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootProjMs06EmployeeMsApiGateway1Application.class, args);
	}

}
