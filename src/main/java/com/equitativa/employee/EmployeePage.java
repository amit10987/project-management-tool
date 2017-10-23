package com.equitativa.employee;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.CommonUtil;
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
	
	/**
	 * @param pageParameters
	 */
	public EmployeePage(PageParameters pageParameters) {
		super(pageParameters);
		add(new EmployeeForm(EmployeeConstant.FORM));
		add(new EmployeeListView(EmployeeConstant.EMPLOYEES, employeeService));
		
		get(EmployeeConstant.PAGE_LINK).add(CommonUtil.appendAttributeClassActive());
	}
	
}
