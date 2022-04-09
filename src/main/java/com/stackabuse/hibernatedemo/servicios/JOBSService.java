package com.stackabuse.hibernatedemo.servicios;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackabuse.hibernatedemo.entidades.Employees;
import com.stackabuse.hibernatedemo.entidades.JOB;

import com.stackabuse.hibernatedemo.repository.EmployeeRepository;
import com.stackabuse.hibernatedemo.repository.GenderRepository;
import com.stackabuse.hibernatedemo.repository.JOBRepository;
/**  JOBSService 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@Service
public class JOBSService {
	
	@Autowired
	JOBRepository jr;
	
	@Autowired
	EmployeeRepository ep;
	@Autowired
	GenderRepository gr;
	
	
	public String BuscarEmpleado(long jobId) {
		
		JSONArray empleados=new JSONArray();
		try {
			JOB jo=jr.findById(jobId).get();
			for (Employees object : ep.findByJob(jo)) {
				JSONObject j=new JSONObject();
					j.put("id", object.getId());
					j.put("name", object.getName());
					j.put("last_name", object.getLastName());
					j.put("birthdate", object.getBirthdate());
						
						JSONObject g=new JSONObject();
						g.put("id", object.getGender().getId());
						g.put("name", object.getGender().getName());
						j.put("gender", g);
						JSONObject job=new JSONObject();
						job.put("id", jo.getId());
						job.put("name", jo.getName());
						job.put("salary", jo.getSalary());
						j.put("job", job);
						
					j.put("success", true);
					empleados.put(j);
				
			}
			
			
			
			
		} catch (Exception e) {
			JSONObject j=new JSONObject();
			// TODO: handle exception
			j.put("success", false);
			j.put("error", "no existe");
			empleados.put(j);
		}
		
		
		return empleados.toString();
	}
	

}
