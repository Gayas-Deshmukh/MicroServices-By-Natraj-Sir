package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class BootProjMs05ConsumerMsShoppingELKStackApplication {

	public static void main(String[] args) 
	{
		log.info("Start of main method - Shopping Service");

		SpringApplication.run(BootProjMs05ConsumerMsShoppingELKStackApplication.class, args);
	
		log.info("End of main method - Shopping Service");
	}
}
