package com.equitativa.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equitativa.model.Employee;

/**
 * @author amit
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
