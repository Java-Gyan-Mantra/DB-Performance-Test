package com.dpt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dpt.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	// Avoid duplicate session creation
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void save(Employee employee) {
		getSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> fetchUsingHQL() {
		return getSession().createQuery("from Employee e").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> fetchUsingCriteria() {
		return getSession().createCriteria(Employee.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> fetchUsingNativeSQL() {
		return getSession().createSQLQuery("select * from EMPLOYEE_DB_RECORDS")
				.list();
	}
}
