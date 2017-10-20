package com.equitativa.employee.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.equitativa.model.Employee;

/**
 * @author amit
 *
 */
public interface EmployeeService {

	/**
	 * @param employee
	 */
	@Transactional
	void create(Employee employee);

	/**
	 * @return
	 */
	@Transactional(readOnly = true)
	List<Employee> getAllEmployees();

	/**
	 * @param employee
	 */
	@Transactional
	void deleteEmployee(Employee employee);

}
