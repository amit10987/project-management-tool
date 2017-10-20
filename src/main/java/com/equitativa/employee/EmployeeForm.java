package com.equitativa.employee;

import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.employee.service.EmployeeService;
import com.equitativa.model.Employee;
import com.equitativa.model.Organization;
import com.equitativa.organization.service.OrganizationService;

/**
 * @author amit
 *
 */
public class EmployeeForm extends Form<Void> {

	private static final long serialVersionUID = 1L;
	
	private Employee employee = new Employee();
	
	@SpringBean
	transient EmployeeService employeeService;
	
	@SpringBean
	transient OrganizationService organizationService;
	
	public EmployeeForm(String id) {
		super(id);
		addEmployeeId();
		addEmployeeFirstName();
		addEmployeeLastName();
		addCompanyDropDownMenu();
	}

	private void addCompanyDropDownMenu() {
		List<Organization> organizations = organizationService.getOrganizationNames();
		PropertyModel<Organization> organizationDropDownModel = new PropertyModel<Organization>(employee, "organization");
		organizationDropDownModel.setObject(organizations.get(0));
		DropDownChoice<Organization> organizationDropDownChoice = new DropDownChoice<Organization>("companies", organizationDropDownModel, organizations, new ChoiceRenderer<Organization>("name", "id"));
		add(organizationDropDownChoice);
	}

	private void addEmployeeLastName() {
		add(new TextField<String>("lastName", new PropertyModel<String>(employee, "lastName")));
	}

	private void addEmployeeFirstName() {
		add(new TextField<String>("firstName", new PropertyModel<String>(employee, "firstName")));
	}

	private void addEmployeeId() {
		add(new HiddenField<String>("id", new PropertyModel<String>(employee, "id")));
	}

	public void onSubmit() {
		boolean isUpdated = null != employee.getId() ? true : false;
		employeeService.create(employee);
		prepareFeedback(isUpdated);
		setResponsePage(EmployeePage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info("Employee updated successfully.");
		} else {
			getSession().info("Employee saved successfully.");
		}
	}
}
