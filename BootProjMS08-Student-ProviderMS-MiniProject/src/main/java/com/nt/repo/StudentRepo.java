package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entiry.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
