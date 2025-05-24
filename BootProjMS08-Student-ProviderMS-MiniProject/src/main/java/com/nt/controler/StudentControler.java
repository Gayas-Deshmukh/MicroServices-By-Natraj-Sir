package com.nt.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entiry.Student;
import com.nt.service.StudentMgmtService;

@RestController
@RequestMapping("/student-api")
public class StudentControler
{
	@Autowired
	private StudentMgmtService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student)
	{
		return new ResponseEntity<String>(studentService.registerStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatus.OK);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable("id") int id) throws Exception
	{
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
}
