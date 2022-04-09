package com.stackabuse.hibernatedemo.entidades;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**  Employees 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@Entity
@Table(name = "Employees")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", nullable = false,unique=true)
	private String name;

	@Column(name = "LAST_NAME", nullable = false,unique=true)
	private String lastName;

	@Column(name = "BIRTHDATE", nullable = false)
	private Date birthdate;
	
	@OneToMany(mappedBy = "employee")
	private Set<EmployeeHour> employeeHours;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	private Gender gender;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private JOB job;
	
	
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public JOB getJob() {
		return job;
	}

	public void setJob(JOB job) {
		this.job = job;
	}



}
