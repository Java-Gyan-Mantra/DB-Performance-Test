package com.dpt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE_DB_RECORDS")
public class Employee {
	@Id
	@GenericGenerator(name = "snoGen", strategy = "increment")
	@GeneratedValue(generator = "snoGen")
	@Column(name = "SLNO")
	private int serialNo;
	@Column(name = "EMPID")
	private String empId;
	@Column(name = "NAME")
	private String name;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
