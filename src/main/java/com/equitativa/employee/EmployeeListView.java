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

	public EmployeeListView(String id, EmployeeService employeeService) {
		super(id, employeeService.getAllEmployees());
		this.employeeService = employeeService;
	}
	
	@Override
	protected void populateItem(ListItem<Employee> item) {
		item.add(new Label("employeeId", new PropertyModel<String>(item.getModel(), "id")));
		item.add(new Label("employeeFirstName", new PropertyModel<String>(item.getModel(), "firstName")));
		item.add(new Label("employeeLastName", new PropertyModel<String>(item.getModel(), "lastName")));
		item.add(new Label("companyId", new PropertyModel<String>(item.getModelObject().getOrganization(), "id")));
		item.add(new Label("companyName", new PropertyModel<String>(item.getModelObject().getOrganization(), "name")));
		item.add(deleteEmployeeLink(item));
	}
	
	private Link<String> deleteEmployeeLink(ListItem<Employee> item) {
		return new Link<String>("deleteEmployeeLink"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				employeeService.deleteEmployee(item.getModelObject());
				getSession().info("Employee deleted successfully.");
				setResponsePage(EmployeePage.class);
			}
		};
	}

}
