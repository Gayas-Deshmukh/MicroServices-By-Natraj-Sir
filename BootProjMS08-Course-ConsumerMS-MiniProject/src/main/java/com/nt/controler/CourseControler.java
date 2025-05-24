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

import com.nt.client.StudentMSClient;
import com.nt.entity.Course;
import com.nt.entity.Student;
import com.nt.service.CourseMgmtService;


@RestController
@RequestMapping("/course-api")
public class CourseControler 
{
	@Autowired
	private CourseMgmtService courseMgmtService;
	
	@Autowired
	private StudentMSClient client;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Course course)
	{
		int 	studentid	=	course.getStudent().getId();
		Student	student		=	client.getStudentById(studentid);
		
		course.setStudent(student);
		
		return new ResponseEntity<String>(courseMgmtService.registerCourse(course), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllCourse()
	{
		return new ResponseEntity<List<Course>>(courseMgmtService.getAllCourses(), HttpStatus.OK);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Course> getCourseByID(@PathVariable("id") int id) throws Exception
	{
		return new ResponseEntity<Course>(courseMgmtService.getCourseById(id), HttpStatus.OK);
	}
}
