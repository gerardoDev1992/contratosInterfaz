package com.stackabuse.hibernatedemo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackabuse.hibernatedemo.entidades.EmployeeHour;
import com.stackabuse.hibernatedemo.servicios.EmployeeHourService;

/**  EmployeeHourController 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@RestController
public class EmployeeHourController {
	
	@Autowired
	EmployeeHourService ems;
	
	@RequestMapping("/horas")
	public String egregaHora(@RequestParam(name = "employee_id") int  emId,
			@RequestParam(name = "worked_hours") int  wh,
			@RequestParam(name = "worked_date") String fecha) throws ParseException {
			EmployeeHour eh=new EmployeeHour();
			Date date1 = new java.sql.Date(
                    ((java.util.Date) new SimpleDateFormat("dd-mm-yy").parse(fecha)).getTime());
			eh.setWorkedDate(date1);
			eh.setWorkedHour(wh);
		return ems.registraHoras(eh, emId);
	}

}
