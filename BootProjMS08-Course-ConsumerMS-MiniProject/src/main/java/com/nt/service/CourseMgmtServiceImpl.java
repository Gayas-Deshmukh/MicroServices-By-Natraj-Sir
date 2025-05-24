package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Course;
import com.nt.repo.CourseRepository;

@Service
public class CourseMgmtServiceImpl implements CourseMgmtService
{
	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public String registerCourse(Course course) 
	{
		int id = courseRepo.save(course).getId();
		return "Course is saved with id " + id;
	}

	@Override
	public List<Course> getAllCourses()
	{
		return courseRepo.findAll();
	}

	@Override
	public Course getCourseById(int id) throws Exception
	{
		return courseRepo.findById(id).orElseThrow(() -> new Exception("Course not found with given id " + id));
	}

}
