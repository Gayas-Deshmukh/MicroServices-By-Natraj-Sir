package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-api")
public class SearchServiceController
{
	@GetMapping("/display")
	public String getDisplayMessage()
	{
		return "Welcome to search service application";
	}
}
