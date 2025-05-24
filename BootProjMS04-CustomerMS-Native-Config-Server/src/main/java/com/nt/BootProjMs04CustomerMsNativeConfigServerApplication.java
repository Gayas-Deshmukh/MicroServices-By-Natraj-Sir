package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootProjMs04CustomerMsNativeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProjMs04CustomerMsNativeConfigServerApplication.class, args);
	}

}
