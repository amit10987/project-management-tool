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

	/**
	 * add company drop down, to attach employee to particular company
	 */
	private void addCompanyDropDownMenu() {
		List<Organization> organizations = organizationService.getOrganizationNames();
		PropertyModel<Organization> organizationDropDownModel = new PropertyModel<Organization>(employee, EmployeeConstant.ORGANIZATION);
		organizationDropDownModel.setObject(organizations.get(0));
		DropDownChoice<Organization> organizationDropDownChoice = new DropDownChoice<Organization>(EmployeeConstant.COMPANIES, organizationDropDownModel, organizations, new ChoiceRenderer<Organization>("name", "id"));
		add(organizationDropDownChoice);
	}

	/**
	 * add employee last name
	 */
	private void addEmployeeLastName() {
		add(new TextField<String>(EmployeeConstant.LAST_NAME, new PropertyModel<String>(employee, EmployeeConstant.LAST_NAME)));
	}

	private void addEmployeeFirstName() {
		add(new TextField<String>(EmployeeConstant.FIRST_NAME, new PropertyModel<String>(employee, EmployeeConstant.FIRST_NAME)));
	}

	private void addEmployeeId() {
		add(new HiddenField<String>(EmployeeConstant.ID, new PropertyModel<String>(employee, EmployeeConstant.ID)));
	}

	public void onSubmit() {
		boolean isUpdated = null != employee.getId() ? true : false;
		employeeService.create(employee);
		prepareFeedback(isUpdated);
		setResponsePage(EmployeePage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info(EmployeeConstant.UPDATED_SUCCESS);
		} else {
			getSession().info(EmployeeConstant.SAVED_SUCCESS);
		}
	}
}
