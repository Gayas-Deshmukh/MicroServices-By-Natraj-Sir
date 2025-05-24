package com.nt.service;

import java.util.List;

import com.nt.entiry.Student;

public interface StudentMgmtService 
{
	String registerStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(int id) throws Exception;
}
