package com.stackabuse.hibernatedemo.servicios;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackabuse.hibernatedemo.entidades.EmployeeHour;
import com.stackabuse.hibernatedemo.entidades.Employees;
import com.stackabuse.hibernatedemo.entidades.Gender;
import com.stackabuse.hibernatedemo.entidades.JOB;
import com.stackabuse.hibernatedemo.repository.EmployeHourRepository;
import com.stackabuse.hibernatedemo.repository.EmployeeRepository;
import com.stackabuse.hibernatedemo.repository.GenderRepository;
import com.stackabuse.hibernatedemo.repository.JOBRepository;
/**  EmployeeService 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@Service
public class EmployeeService {
	@Autowired
	GenderRepository repo;

	@Autowired
	JOBRepository repojob;

	@Autowired
	EmployeeRepository emploRepo;
	
	@Autowired
	EmployeHourRepository ehp;

	public String agregarEmpleado(Employees em, int genderId, int jobId) {
		JSONObject res = null;
		String r="";
		try {
			
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			long diff = date.getYear() - em.getBirthdate().getYear();
			System.out.println(" hola : "+diff);
			if(diff<18) {
				res = new JSONObject();
				res.put("id", "null");
				res.put("success", false);
				res.put("error", "debe ser mayor a 18 años edad: "+ diff);
			}else {
			Gender g = repo.findById((long) genderId).get();
			JOB j = repojob.findById((long) jobId).get();
			em.setJob(j);
			em.setGender(g);			
			if (emploRepo.save(em).getId() > 0) {
				res = new JSONObject();
				res.put("id", em.getId());
				res.put("success", true);

			} else {
				res = new JSONObject();
				res.put("id", "null");
				res.put("success", false);
			}
			}
		} catch (Exception e) {
			res = new JSONObject();
			res.put("id", "null");
			res.put("success", false);
			res.put("error", e.getMessage());
			
			
		} 
		r=res.toString();
		

		return r;
	}
	
	public String dameHoras(Employees em ,String startDate,String endDate) throws ParseException {
		
		JSONObject a=new JSONObject();
		try {
		 Date date1 = new java.sql.Date(
                 ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(startDate)).getTime());
		 Date date2 = new java.sql.Date(
                 ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(endDate)).getTime());
		
		 
		 
		 if(date2.after(date1)) {
			List<EmployeeHour> list=ehp.findByWorkedDateBetweenAndEmployee(date1, date2,em);
			int horas=0;
			for (EmployeeHour employeeHour : list) {
				horas=employeeHour.getWorkedHour()+horas;
			}
			
			
			a.put("total_worked_hours", horas);
			a.put("success", true);
		 }else {
			 	a.put("total_worked_hours", "null");
				a.put("success", false);
		 }
			} catch (Exception e) {
			a = new JSONObject();
			a.put("total_worked_hours", "null");
			a.put("success", false);
			a.put("error", e.getMessage());
			
			
		} 
		 
		return a.toString();
	}
	public String pagoEmpleado(Employees em ,String startDate,String endDate) throws ParseException {
		JSONObject b=new JSONObject();
		try {
		Employees a=emploRepo.findById(em.getId()).get();
		double dia=a.getJob().getSalary()/22;
		double hora=dia/8;
		 Date date1 = new java.sql.Date(
                 ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(startDate)).getTime());
		 Date date2 = new java.sql.Date(
                 ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(endDate)).getTime());
		 if(date2.after(date1)) {
				List<EmployeeHour> list=ehp.findByWorkedDateBetweenAndEmployee(date1, date2,em);
				double pago=0.0;
				for (EmployeeHour employeeHour : list) {
					pago=employeeHour.getWorkedHour()*hora+pago;
				}
				
				
				b.put("payment", pago);
				b.put("success", true);
			 }else {
				 	b.put("payment", "null");
					b.put("success", false);
			 }
		} catch (Exception e) {
			b = new JSONObject();
			b.put("payment", "null");
			b.put("success", false);
			b.put("error", e.getMessage());
			
			
		} 
	
		return b.toString();
	}
	
}
