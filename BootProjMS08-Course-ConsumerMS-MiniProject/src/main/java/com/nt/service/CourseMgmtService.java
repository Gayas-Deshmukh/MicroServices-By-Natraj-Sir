package com.nt.service;

import java.util.List;

import com.nt.entity.Course;

public interface CourseMgmtService 
{
	String registerCourse(Course course);
	List<Course> getAllCourses();
	Course getCourseById(int id) throws Exception;
}
