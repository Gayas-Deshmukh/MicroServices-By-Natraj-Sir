package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>
{

}
