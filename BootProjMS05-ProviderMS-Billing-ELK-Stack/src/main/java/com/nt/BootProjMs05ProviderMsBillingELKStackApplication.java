package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootProjMs05ProviderMsBillingELKStackApplication 
{
	public static void main(String[] args) 
	{
		log.info("Start of main method - Billing Service");
		
		SpringApplication.run(BootProjMs05ProviderMsBillingELKStackApplication.class, args);
	
		log.info("End of main method - Billing Service");
	}
}
