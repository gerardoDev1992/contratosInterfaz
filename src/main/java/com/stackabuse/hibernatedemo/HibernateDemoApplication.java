package com.stackabuse.hibernatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.stackabuse.hibernatedemo.entidades.Gender;
import com.stackabuse.hibernatedemo.entidades.JOB;
import com.stackabuse.hibernatedemo.repository.GenderRepository;
import com.stackabuse.hibernatedemo.repository.JOBRepository;
/**  HibernateDemoApplication 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	
	  @Autowired
		GenderRepository repo;
		
		@Autowired
		JOBRepository repojob;
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			Gender g=new Gender();
			JOB a=new JOB();			
			g.setName("M");
			repo.save(g);			
			a.setName("EG");
			a.setSalary(300000.0);
			repojob.save(a);
			
			

		};
	}

	

}
