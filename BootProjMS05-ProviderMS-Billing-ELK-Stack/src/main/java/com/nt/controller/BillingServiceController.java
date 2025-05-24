package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingServiceController 
{
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@GetMapping("/info")
	public String getBillingInfo()
	{
		log.info("Inside getBillingInfo() method");
		
		return "We can accept Card Payment, UPI Payment, NetBanking Payment" + "... Using intance::" + instanceId + " @port::" + port;
	}
	
	@GetMapping("/info/{billCode}")
	public String getBillingInfo(@PathVariable("billCode") String billCode)
	{
		return "We can accept Card Payment, UPI Payment & NetBanking Payment for BillCode::"+ billCode + "... Using intance::" + instanceId + " @port::" + port;
	}
}
