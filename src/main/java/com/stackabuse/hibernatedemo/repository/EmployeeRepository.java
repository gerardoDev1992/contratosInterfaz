package com.stackabuse.hibernatedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackabuse.hibernatedemo.entidades.Employees;
import com.stackabuse.hibernatedemo.entidades.Gender;
import com.stackabuse.hibernatedemo.entidades.JOB;


public interface EmployeeRepository extends JpaRepository<Employees, Long> {
	
	List<Employees> findByJob(JOB jobId);
}
