package com.dpt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dpt.service.EmployeeService;

public class DBPeformanceTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				EmployeeService.class);
		EmployeeService service = (EmployeeService) context
				.getBean("employeeService");
		// Save Record Manually....
		//service.saveEmployee();

		 service.displayFetchTime();
	}
}
