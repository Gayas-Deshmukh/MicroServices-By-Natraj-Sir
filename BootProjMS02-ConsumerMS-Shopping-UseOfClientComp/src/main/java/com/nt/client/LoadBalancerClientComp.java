package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoadBalancerClientComp 
{
	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo()
	{
		// Get service instance
		ServiceInstance	serviceInstance	=	client.choose("Billing-Service");
		
		// Get instance URI
		URI uri = serviceInstance.getUri();
		
		// Get Produces MS URI & make it as URL
		String	url	=	uri.toString() + "/billing/info";
		
		// Create Rest Template Object
		RestTemplate restTemplate	=	new RestTemplate();
		
		// Invoke Produce MS service method 
		String response	= restTemplate.getForObject(url, String.class);
		
		return response;
	}
}
