package com.nt.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IFeignClientComp;
import com.nt.client.LoadBalancerClientComp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceController 
{
	@Autowired
	private IFeignClientComp  clientComp;
	
	@GetMapping("/info")
	@CircuitBreaker(name = "Shopping-Service", fallbackMethod = "billingFallBack")
	public ResponseEntity<String> getShoppingInfo()
	{	
		System.out.println("Calling Billing Service....");
		
		String resultBody 	=	clientComp.getPaymentBillInfo();
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
		
		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
	}
	
	@GetMapping("/info/{code}")
	public ResponseEntity<String> getShoppingInfo(@PathVariable("code") String code)
	{
		String resultBody 	=	clientComp.getPaymentBillInfoWithCode(code);
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
			
		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
	}
	
	public ResponseEntity<String> billingFallBack(Exception e)
	{
		System.out.println("ShoppingServiceController.billingFallBack()");
		
		return new ResponseEntity<String>("Billing Service is down, Please try after some time", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
