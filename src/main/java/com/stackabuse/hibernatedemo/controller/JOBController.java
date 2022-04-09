package com.stackabuse.hibernatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackabuse.hibernatedemo.servicios.JOBSService;
/**  JOBController 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@RestController
public class JOBController {
	
	@Autowired
	JOBSService jr;
	@RequestMapping("/puestos")
	public String buscaTrabajos(@RequestParam(name = "job_id") long  jobId) {
		
		return jr.BuscarEmpleado(jobId);
		
	}

}
