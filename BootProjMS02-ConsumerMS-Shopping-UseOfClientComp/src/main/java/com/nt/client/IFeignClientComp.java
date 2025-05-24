package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Billing-Service")
public interface IFeignClientComp 
{
	@GetMapping("/billing/info")
	public String getPaymentBillInfo();
	
	@GetMapping("/billing/info/{billCode}")
	public String getPaymentBillInfoWithCode(@PathVariable("billCode") String code);
}
