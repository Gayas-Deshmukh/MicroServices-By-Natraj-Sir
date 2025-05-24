package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entiry.Student;
import com.nt.repo.StudentRepo;

@Service
public class StudentMgmtServiceImpl implements StudentMgmtService
{
	@Autowired
	private StudentRepo repo;

	@Override
	public String registerStudent(Student student) 
	{
		int id = repo.save(student).getId();
		return "Student saved with id " + id;
	}

	@Override
	public List<Student> getAllStudent() 
	{
		return repo.findAll();
	}

	@Override
	public Student getStudentById(int id) throws Exception
	{
		return repo.findById(id).orElseThrow(()-> new Exception("Student does not found with given id : " + id));
	}

}
