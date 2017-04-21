package com.dpt.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.dpt.dao.EmployeeDao;
import com.dpt.model.Employee;

@Service
@ComponentScan("com.dpt.*")
@Transactional
public class EmployeeService {

	@Autowired(required = true)
	private EmployeeDao dao;
	public long startTime;
	public long endTime;
	public long totalTime;
	List<Employee> employees = null;

	public void saveEmployee() {
		Employee employee = null;
		for (int i = 0; i <= 10000; i++) {
			employee = new Employee();
			employee.setEmpId("CTS" + new Random().nextInt(354574));
			employee.setName("EMPLOYEE" + i);
			dao.save(employee);
		}
		System.out.println("Record Saved Successfully...");
	}

	public void displayFetchTime() {
		countHQLFetchTime();
		countCriteriaFetchTime();
		countNativeSQLFetchTime();
	}

	public void countHQLFetchTime() {
		startTime = System.currentTimeMillis();
		employees = dao.fetchUsingHQL();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Total Execution time for HQL Hit : "
				+ convertMsToSec(totalTime) + " or " + totalTime
				+ " miliSeconds");
	}

	public void countCriteriaFetchTime() {
		startTime = System.currentTimeMillis();
		employees = dao.fetchUsingCriteria();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Total Execution time for CRITERIA : "
				+ convertMsToSec(totalTime) + " or " + totalTime
				+ " miliSeconds");
	}

	public void countNativeSQLFetchTime() {
		startTime = System.currentTimeMillis();
		employees = dao.fetchUsingNativeSQL();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Total Execution time for NAtive SQL : "
				+ convertMsToSec(totalTime) + " or " + totalTime
				+ " miliSeconds");
	}

	public String convertMsToSec(long totalTime) {
		return String.format(
				"%d min, %d sec",
				TimeUnit.MILLISECONDS.toMinutes(totalTime),
				TimeUnit.MILLISECONDS.toSeconds(totalTime)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes(totalTime)));
	}
}
