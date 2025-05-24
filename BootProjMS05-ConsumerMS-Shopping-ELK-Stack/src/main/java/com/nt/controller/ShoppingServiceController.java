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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shopping")
@Slf4j
public class ShoppingServiceController 
{
	@Autowired
	//private DiscoveryClientComp clientComp;
	//private LoadBalancerClientComp clientComp;
	private IFeignClientComp  clientComp;
	
	@GetMapping("/info")
	public ResponseEntity<String> getShoppingInfo()
	{
		/**
		 * Using Discovery Client comp
		 * 
		String resultBody = clientComp.getBillingInfo();
		
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
		
		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
		*/
		
		/**
		 * Using LoadBanceComp
		 *
		
		String resultBody 	=	clientComp.getBillingInfo();
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
		
		try 
		{
			Thread.sleep(20000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
		*/
		
		/**
		 * Using FeignClient
		 */
		
		log.info("Inside getShoppingInfo() method");
		
		String resultBody 	=	clientComp.getPaymentBillInfo();
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
		
		try 
		{
			Thread.sleep(20000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		log.info("Got billing info " + billingInfo);

		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
	}
	
	@GetMapping("/info/{code}")
	public ResponseEntity<String> getShoppingInfo(@PathVariable("code") String code)
	{
		String resultBody 	=	clientComp.getPaymentBillInfoWithCode(code);
		String billingInfo	=	"Bill amount : "+ new Random().nextInt() + " ......... " + resultBody;
		
		try 
		{
			Thread.sleep(20000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(billingInfo, HttpStatus.OK);
	}
}
