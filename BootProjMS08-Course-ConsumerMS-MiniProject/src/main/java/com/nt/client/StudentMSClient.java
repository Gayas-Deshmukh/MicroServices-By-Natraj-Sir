package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.Student;

@FeignClient("Student-ProviderMS")
public interface StudentMSClient 
{
	@GetMapping("/student-api/byId/{id}")
	Student getStudentById(@PathVariable("id") int id);
}
