package com.stackabuse.hibernatedemo.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**  JOB 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/

@Entity
@Table(name = "JOBS")
public class JOB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SALARY", nullable = false)
	private Double salary;
	
	@OneToMany(mappedBy = "gender")
	private Set<Employees> employyes;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Set<Employees> getEmployyes() {
		return employyes;
	}

	public void setEmployyes(Set<Employees> employyes) {
		this.employyes = employyes;
	}


	
	
	
}
