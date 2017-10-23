package com.equitativa.employee;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.employee.service.EmployeeService;
import com.equitativa.model.Employee;

/**
 * @author amit
 *
 */
public class EmployeeListView extends ListView<Employee>{
	
private static final long serialVersionUID = 1L;
	
	transient EmployeeService employeeService;

	/**
	 * @param id
	 * @param employeeService
	 */
	public EmployeeListView(String id, EmployeeService employeeService) {
		super(id, employeeService.getAllEmployees());
		this.employeeService = employeeService;
	}
	
	@Override
	protected void populateItem(ListItem<Employee> item) {
		item.add(new Label(EmployeeConstant.EMPLOYEE_ID, new PropertyModel<String>(item.getModel(), EmployeeConstant.ID)));
		item.add(new Label(EmployeeConstant.EMPLOYEE_FIRST_NAME, new PropertyModel<String>(item.getModel(), EmployeeConstant.FIRST_NAME)));
		item.add(new Label(EmployeeConstant.EMPLOYEE_LAST_NAME, new PropertyModel<String>(item.getModel(), EmployeeConstant.LAST_NAME)));
		item.add(new Label(EmployeeConstant.COMPANY_ID, new PropertyModel<String>(item.getModelObject().getOrganization(), EmployeeConstant.ID)));
		item.add(new Label(EmployeeConstant.COMPANY_NAME, new PropertyModel<String>(item.getModelObject().getOrganization(), EmployeeConstant.NAME)));
		item.add(deleteEmployeeLink(item));
	}
	
	/**
	 * @param item
	 * @return
	 */
	private Link<String> deleteEmployeeLink(final ListItem<Employee> item) {
		return new Link<String>(EmployeeConstant.DELETED_LINK){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				employeeService.deleteEmployee(item.getModelObject());
				getSession().info(EmployeeConstant.DELETED_SUCCESS);
				setResponsePage(EmployeePage.class);
			}
		};
	}

}
