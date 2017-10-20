package com.equitativa.employee;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.employee.service.EmployeeService;

/**
 * @author amit
 *
 */
public class EmployeePage extends HomePage{

private static final long serialVersionUID = 1L;
	
	@SpringBean
	transient EmployeeService employeeService;
	
	public EmployeePage(PageParameters pageParameters) {
		super(pageParameters);
		add(new EmployeeForm("employeeForm"));
		add(new EmployeeListView("employees", employeeService));
	}
}
