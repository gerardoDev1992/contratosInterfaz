package com.stackabuse.hibernatedemo.controller;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackabuse.hibernatedemo.entidades.Employees;
import com.stackabuse.hibernatedemo.entidades.Gender;
import com.stackabuse.hibernatedemo.entidades.JOB;
import com.stackabuse.hibernatedemo.repository.EmployeeRepository;
import com.stackabuse.hibernatedemo.repository.GenderRepository;
import com.stackabuse.hibernatedemo.repository.JOBRepository;
import com.stackabuse.hibernatedemo.servicios.EmployeeService;

/**  EmployeeController 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/

@RestController
public class EmployeeController {

 

@Autowired
EmployeeService emplService;
  /*
   * }
   * 
   * 
   {
    "gender_id": 1, // Id del catálogo genders
    "job_id": 1, // Id del catálogo jobs
    "name": "Juan", // Nombre del empleado
    "last_name": "Pérez", // Apellido del empleado
    "birthdate": "1983-01-01" // Fecha de nacimiento del empleado
}
   
   * 
	{
    "employee_id": 1, // Id del empleado
    "worked_hours": 10, // Horas trabajadas
    "worked_date": "2019-01-01" // Fecha que trabajó el empleado
}
	
	*/
	@RequestMapping("/empleado")  
  public String saveEmployee(@RequestParam(name = "gender_id") int  genderId,@RequestParam(name = "job_id") int  jobId,@RequestParam(name = "name") String name
		  ,@RequestParam(name = "last_name") String lastName,@RequestParam(name = "birthdate") String birthdate) throws ParseException {
		
			  Employees em=new Employees();			  
			  Date date1 = new java.sql.Date(
	                     ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(birthdate)).getTime());			  			  			  
			  em.setName(name);
			  em.setLastName(lastName);			  			  			  			  
			  em.setBirthdate(date1);			  			  			 
	  return emplService.agregarEmpleado(em, genderId, jobId);
  }
	
	@RequestMapping("/horasTrabajadas")  
	public String horasTrabajadas(@RequestParam(name = "employee_id") int  emplId,@RequestParam(name = "start_date") String  startDate,@RequestParam(name = "end_date") String endDate) throws ParseException {
		Employees em=new Employees();	
		em.setId(emplId);
		return emplService.dameHoras  ( em ,startDate, endDate);
	}	
	
	@RequestMapping("/pagos")  
	public String pagos(@RequestParam(name = "employee_id") int  emplId,@RequestParam(name = "start_date") String  startDate,@RequestParam(name = "end_date") String endDate) throws ParseException {
		Employees em=new Employees();	
		em.setId(emplId);
		return emplService.pagoEmpleado( em ,startDate, endDate);
	}	
 
}
