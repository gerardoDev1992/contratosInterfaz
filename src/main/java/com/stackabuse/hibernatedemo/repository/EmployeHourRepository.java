package com.stackabuse.hibernatedemo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackabuse.hibernatedemo.entidades.EmployeeHour;
import com.stackabuse.hibernatedemo.entidades.Employees;


public interface EmployeHourRepository extends JpaRepository<EmployeeHour, Long> {
	
			List<EmployeeHour>	findByWorkedDateBetweenAndEmployee(Date start, Date end,Employees employyeDd);
	
}
