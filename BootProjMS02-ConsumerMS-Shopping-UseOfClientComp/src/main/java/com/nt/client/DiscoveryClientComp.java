package com.nt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DiscoveryClientComp 
{
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public String getBillingInfo()
	{
		// Get Service instances by service id
		List<ServiceInstance>	instances 		=	discoveryClient.getInstances("Billing-Service");
		
		// Get first instance
		ServiceInstance 		serviceInstance	=	instances.get(0);
		
		// Get Produces MS URI & make it as URL
		String 					url				= 	serviceInstance.getUri() + "/billing/info";
		
		// Create Rest Template Object
		RestTemplate restTemplate	=	new RestTemplate();
		
		// Invoke Produce MS service method 
		String response	= restTemplate.getForObject(url, String.class);
		
		return response;
	}
}
