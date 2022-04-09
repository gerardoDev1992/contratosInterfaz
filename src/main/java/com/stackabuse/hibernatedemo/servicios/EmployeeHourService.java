package com.stackabuse.hibernatedemo.servicios;

import java.sql.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackabuse.hibernatedemo.entidades.EmployeeHour;
import com.stackabuse.hibernatedemo.entidades.Employees;
import com.stackabuse.hibernatedemo.repository.EmployeHourRepository;
import com.stackabuse.hibernatedemo.repository.EmployeeRepository;
/**  EmployeeHourService 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@Service
public class EmployeeHourService {
	@Autowired
	EmployeHourRepository emhr;
	@Autowired
	EmployeeRepository ep;
	
	/*  Ejercicio 2. Realiza un web service que permita agregar horas trabajadas de un empleado (ver anexo 1.2).
        Se debe validar que el empleado exista, que el total de horas trabajadas no sea mayor a 20 horas y que la
        fecha de trabajo sea menor o igual a la actual y no se duplique por empleado (un empleado sólo puede tener
        un registro de horas trabajadas por día).
	 * */
	public String registraHoras(EmployeeHour emH,long idE) {
		JSONObject r=null;
		try {
			
	        long now = System.currentTimeMillis();

	        Date sqlDate = new Date(now);
			Employees a=ep.findById(idE).get();
			emH.setEmployee(a);
			emhr.save(emH);
			if(emH.getWorkedHour()>20 || emH.getWorkedDate().after(sqlDate)) {
				r=new JSONObject();
				r.put("success", false);
				r.put("id", "null");
				
			}else{
				r=new JSONObject();
				r.put("success", true);
				r.put("id", emH.getId());
				System.out.println("pasamos");
			}
			
		} catch (Exception e) {
			r=new JSONObject();
			r.put("success", false);
			r.put("id", e.getMessage());
		
		}
		
		return r.toString();
	}

	

}
