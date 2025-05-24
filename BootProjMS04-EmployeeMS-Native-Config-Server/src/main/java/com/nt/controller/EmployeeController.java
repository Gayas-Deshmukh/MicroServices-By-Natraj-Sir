package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeController 
{
	@Value("${dbuser}")
	private String dbuser;
	
	@Value("${dbpwd}")
	private String pwd;
	
	@GetMapping("/show")
	public String showEmployeeData()
	{
		return "Employee (MS) - Data Collected from Config Server :" + dbuser + "...." + pwd;
	}
}
