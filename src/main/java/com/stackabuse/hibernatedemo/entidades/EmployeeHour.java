package com.stackabuse.hibernatedemo.entidades;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/**  EmployeeHour 
 *  * @author Gerardo Leyva 
 * @version 1.0
*/
@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
@EntityListeners(AuditingEntityListener.class)
public class EmployeeHour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "WORKED_HOURS", nullable = false)
	private int workedHour;
	
	@Column(name = "WORKED_DATE", nullable = false)
	private Date workedDate;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employees employee;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}

	public Date getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	

}
